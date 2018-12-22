package com.shijo.di.module;

import android.app.Application;
import android.content.Context;
import com.shijo.di.ApplicationContext;
import com.shijo.model.AppDataManager;
import com.shijo.model.DataManager;
import com.shijo.model.network.ApiManager;
import com.shijo.model.network.WeatherApiManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class ApplicationModule {
  private final Application mApplication;

  public ApplicationModule(Application application) {
    this.mApplication = application;
  }

  @Provides @ApplicationContext Context provideContext() {
    return mApplication;
  }

  @Provides Application provideApplication() {
    return mApplication;
  }

  @Provides @Singleton WeatherApiManager provideApiManager(ApiManager weatherApiManager) {
    return weatherApiManager;
  }

  @Provides @Singleton DataManager provideDataManager(AppDataManager appDataManager) {
    return appDataManager;
  }
}
