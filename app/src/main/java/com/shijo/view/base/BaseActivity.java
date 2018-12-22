package com.shijo.view.base;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import butterknife.Unbinder;
import com.shijo.app.WeatherApplication;
import com.shijo.di.component.ActivityComponent;
import com.shijo.di.component.DaggerActivityComponent;
import com.shijo.di.module.ActivityModule;
import com.shijo.utils.NetworkUtils;
import com.shijo.view.weather.R;

public abstract class BaseActivity extends AppCompatActivity implements BaseViewContract {

  private ActivityComponent mActivityComponent;
  private Unbinder mUnBinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mActivityComponent = DaggerActivityComponent.builder()
        .activityModule(new ActivityModule(this))
        .applicationComponent(((WeatherApplication) getApplication()).getComponent())
        .build();
  }

  @Override protected void onDestroy() {

    if (mUnBinder != null) {
      mUnBinder.unbind();
    }
    super.onDestroy();
  }

  public boolean isActivityRunning() {
    return !isDestroyed() || !isFinishing();
  }

  public int fetchColor(@ColorRes int color) {
    return ContextCompat.getColor(this, color);
  }

  public ActivityComponent getActivityComponent() {
    return mActivityComponent;
  }

  @TargetApi(Build.VERSION_CODES.M)
  public void requestPermissionsSafely(String[] permissions, int requestCode) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      ActivityCompat.requestPermissions(this, permissions, requestCode);
    }
  }

  @TargetApi(Build.VERSION_CODES.M) public boolean hasPermissions(String... permissions) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
      for (String permission : permissions) {
        if (ActivityCompat.checkSelfPermission(this, permission)
            != PackageManager.PERMISSION_GRANTED) {
          return false;
        }
      }
    }
    return true;
  }

  @Override public void onError(@StringRes int resId) {
    onError(getString(resId));
  }

  @Override public void onError(String message) {
    if (message != null) {
      Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
    }
  }

  @Override public boolean isNetworkConnected() {
    return NetworkUtils.isNetworkConnected(getApplicationContext());
  }

  public void setUnBinder(Unbinder unBinder) {
    mUnBinder = unBinder;
  }

  protected abstract void setUp();

  protected abstract void addFragmentToBackStack(Fragment fragment, String fragmentTag,
      @IdRes int layoutResourceId);
}
