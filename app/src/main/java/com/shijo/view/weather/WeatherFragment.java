package com.shijo.view.weather;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.shijo.app.Constants;
import com.shijo.contracts.WeatherFragmentPresenterContract;
import com.shijo.contracts.WeatherFragmentViewContract;
import com.shijo.view.base.BaseFragment;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class WeatherFragment extends BaseFragment implements WeatherFragmentViewContract {
  public static final int LOCATION_REQUEST = 123;
  String mWeatherApiKey = Constants.API_KEY;

  @Inject WeatherFragmentPresenterContract<WeatherFragmentViewContract> mPresenter;
  @Inject Activity mActivity;
  @BindView(R.id.imageViewIcon) ImageView mIconImageView;
  @BindView(R.id.textViewTemp) TextView mTempTextView;
  @BindView(R.id.textViewLoc) TextView mLocTextView;
  @BindView(R.id.textViewText) TextView mConditionTextView;
  @BindView(R.id.progressView) View mProgressView;
  private FusedLocationProviderClient mFusedLocationClient;

  public static WeatherFragment newInstance() {
    Bundle args = new Bundle();
    WeatherFragment fragment = new WeatherFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public static String getFragmentTag() {
    return WeatherFragment.class.getSimpleName();
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_weather, container, false);
    setUp(view);
    return view;
  }

  @Override protected void setUp(View view) {
    if (getActivityComponent() != null) {
      getActivityComponent().inject(this);
      setUnBinder(ButterKnife.bind(this, view));
      mPresenter.onAttach(this);
    }
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mActivity);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (!hasPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
          Manifest.permission.ACCESS_COARSE_LOCATION)) {
        requestPermissions(new String[] {
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
        }, LOCATION_REQUEST);
      } else {
        getLastLocation();
      }
    } else {
      getLastLocation();
    }
  }

  @SuppressLint("MissingPermission") private void getLastLocation() {
    mFusedLocationClient.getLastLocation().addOnSuccessListener(mActivity, location -> {
      if (location != null) {
        mPresenter.getWeatherData(mWeatherApiKey, String.valueOf(location.getLatitude()),
            String.valueOf(location.getLongitude()), 6);
      } else {
        Toast.makeText(mActivity, "Failed to get location!", Toast.LENGTH_SHORT).show();
        mPresenter.getWeatherData(mWeatherApiKey, "13.0238231", "77.5508521", 6);
      }
    });
  }

  @SuppressLint("SetTextI18n") @Override
  public void displayWeatherData(String tempC, String city, String country, String text,
      String icon) {
    Picasso.get().load("https://" + icon).into(mIconImageView);
    mConditionTextView.setText(text);
    mLocTextView.setText(city + "\n" + country);
    mTempTextView.setText(tempC.split("\\.")[0] + "\u00b0");
    hideProgressView();
  }

  private void hideProgressView() {
    mProgressView.animate().alpha(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
      @Override public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        mProgressView.setVisibility(View.GONE);
        getChildFragmentManager().beginTransaction()
            .setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up)
            .add(R.id.content3, ForecastFragment.newInstance(), ForecastFragment.getFragmentTag())
            .addToBackStack(null)
            .commit();
      }
    });
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
      case LOCATION_REQUEST: {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          getLastLocation();
        } else {
          Toast.makeText(mActivity, "App will not work with location access", Toast.LENGTH_SHORT)
              .show();
        }
        break;
      }
    }
  }
}
