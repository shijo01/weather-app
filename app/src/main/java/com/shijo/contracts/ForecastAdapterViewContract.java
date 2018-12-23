package com.shijo.contracts;

import com.shijo.view.base.BaseViewContract;

public interface ForecastAdapterViewContract extends BaseViewContract {
  void setDayAndCondition(String data);

  void setWeatherConditionImage(String url);

  void setMinimumAndMaximumTemperature(String temperature);
}
