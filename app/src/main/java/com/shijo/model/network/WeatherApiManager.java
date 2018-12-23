package com.shijo.model.network;

import com.shijo.model.network.models.WeatherData;
import io.reactivex.Observable;

public interface WeatherApiManager {
  Observable<WeatherData> getWeatherData(String key, String latitude, String longitude,
      int numberOfDays);
}
