package com.shijo.contracts;

import com.shijo.view.base.BasePresenterContract;

public interface WeatherFragmentPresenterContract<V extends WeatherFragmentViewContract>
    extends BasePresenterContract<V> {
  void getWeatherData(String weatherApiKey, String latitude, String longitude, int numberOfDays);
}
