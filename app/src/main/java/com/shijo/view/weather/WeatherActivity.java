package com.shijo.view.weather;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.shijo.view.base.BaseActivity;

public class WeatherActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    setUp();
  }

  @Override protected void setUp() {

  }

  @Override protected void addFragmentToBackStack(Fragment fragment, String fragmentTag,
      int layoutResourceId) {

  }
}
