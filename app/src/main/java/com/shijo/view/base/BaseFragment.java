package com.shijo.view.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import butterknife.Unbinder;
import com.shijo.di.component.ActivityComponent;

public abstract class BaseFragment extends Fragment implements BaseViewContract {
  private BaseActivity mActivity;
  private Unbinder mUnBinder;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setUp(view);
  }

  @Override public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof BaseActivity) {
      this.mActivity = (BaseActivity) context;
    }
  }

  @Override public void onAttach(@NonNull Activity context) {
    super.onAttach(context);
    if (context instanceof BaseActivity) {
      this.mActivity = (BaseActivity) context;
    }
  }

  public int fetchColor(@ColorRes int color) {
    return ContextCompat.getColor(mActivity, color);
  }

  @Override public void onError(String message) {
    if (mActivity != null) {
      mActivity.onError(message);
    }
  }

  @Override public void onError(@StringRes int resId) {
    if (mActivity != null) {
      mActivity.onError(resId);
    }
  }

  @Override public boolean isNetworkConnected() {
    if (mActivity != null) {
      return mActivity.isNetworkConnected();
    }
    return false;
  }

  @Override public void onDetach() {
    mActivity = null;
    super.onDetach();
  }

  public boolean hasPermissions(String... permissions) {
    return mActivity.hasPermissions(permissions);
  }

  @TargetApi(Build.VERSION_CODES.M)
  public void requestPermissionsSafely(String[] permissions, int requestCode) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      mActivity.requestPermissionsSafely(permissions, requestCode);
    }
  }

  public ActivityComponent getActivityComponent() {
    if (mActivity != null) {
      return mActivity.getActivityComponent();
    }
    return null;
  }

  public BaseActivity getBaseActivity() {
    return mActivity;
  }

  public void setUnBinder(Unbinder unBinder) {
    mUnBinder = unBinder;
  }

  protected abstract void setUp(View view);

  @Override public void onDestroy() {
    if (mUnBinder != null) {
      mUnBinder.unbind();
    }
    super.onDestroy();
  }
}
