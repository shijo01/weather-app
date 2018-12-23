package com.shijo.model;

import android.content.Context;
import com.shijo.di.ApplicationContext;
import com.shijo.model.network.WeatherApiManager;
import com.shijo.model.network.models.ForecastdayItem;
import com.shijo.model.network.models.WeatherData;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

public class AppDataManager implements DataManager {
  private final WeatherApiManager mApiManager;
  private List<ForecastdayItem> mForecastItems;

  @Inject public AppDataManager(@ApplicationContext Context context, WeatherApiManager apiManager) {
    mApiManager = apiManager;
  }

  @Override
  public Observable<WeatherData> getWeatherData(String key, String latitude, String longitude,
      int numberOfDays) {
    return mApiManager.getWeatherData(key, latitude, longitude, numberOfDays);
  }

  @Override public void setForecastData(List<ForecastdayItem> forecastdayItemList) {
    mForecastItems = forecastdayItemList;
  }

  @Override public List<ForecastdayItem> getForecastData() {
    return mForecastItems;
  }
}
