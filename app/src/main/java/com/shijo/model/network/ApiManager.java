package com.shijo.model.network;

import com.shijo.model.network.models.WeatherData;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class ApiManager implements WeatherApiManager {
  private Retrofit mRetrofit;

  @Inject ApiManager(Retrofit retrofit) {
    mRetrofit = retrofit;
  }

  @Override
  public Observable<WeatherData> getWeatherData(String key, String latitude, String longitude,
      int numberOfDays) {
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("key", key);
    queryParams.put("q", latitude + "," + longitude);
    queryParams.put("days", String.valueOf(numberOfDays));
    return mRetrofit.create(WeatherApi.class).getWeatherData(queryParams);
  }
}
