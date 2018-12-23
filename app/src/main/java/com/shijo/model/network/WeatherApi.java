package com.shijo.model.network;

import com.shijo.model.network.models.WeatherData;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WeatherApi {
  @GET("forecast.json") Observable<WeatherData> getWeatherData(
      @QueryMap Map<String, String> reqParams);
}
