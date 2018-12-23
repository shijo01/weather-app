package com.shijo.model;

import com.shijo.model.network.WeatherApiManager;
import com.shijo.model.network.models.ForecastdayItem;
import java.util.List;

public interface DataManager extends WeatherApiManager {
  void setForecastData(List<ForecastdayItem> forecastdayItemList);

  List<ForecastdayItem> getForecastData();
}
