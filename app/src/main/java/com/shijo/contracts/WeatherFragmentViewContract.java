package com.shijo.contracts;

import com.shijo.view.base.BaseViewContract;

public interface WeatherFragmentViewContract extends BaseViewContract {
  void displayWeatherData(String tempC, String city, String country, String text, String icon);
}
