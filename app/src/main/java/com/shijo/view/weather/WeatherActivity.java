package com.shijo.view.weather;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.shijo.view.base.BaseActivity;

public class WeatherActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    setUp();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.content1, WeatherFragment.newInstance(),
        WeatherFragment.getFragmentTag()).commit();
  }

  @Override protected void setUp() {

  }

  @Override protected void addFragmentToBackStack(Fragment fragment, String fragmentTag,
      int layoutResourceId) {

  }

  @Override public boolean hasPermissions(String... permissions) {
    return super.hasPermissions(permissions);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }
}
