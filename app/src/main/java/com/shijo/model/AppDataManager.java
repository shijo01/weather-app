package com.shijo.model;

import android.content.Context;
import com.shijo.di.ApplicationContext;
import com.shijo.model.network.WeatherApiManager;
import javax.inject.Inject;

public class AppDataManager implements DataManager {
  private final WeatherApiManager mApiManager;

  @Inject public AppDataManager(@ApplicationContext Context context, WeatherApiManager apiManager) {
    mApiManager = apiManager;
  }
}
