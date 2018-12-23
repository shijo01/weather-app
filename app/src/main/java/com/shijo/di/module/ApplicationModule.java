package com.shijo.di.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.shijo.app.Constants;
import com.shijo.di.ApiKey;
import com.shijo.di.ApplicationContext;
import com.shijo.di.BaseUrl;
import com.shijo.model.AppDataManager;
import com.shijo.model.DataManager;
import com.shijo.model.network.ApiManager;
import com.shijo.model.network.WeatherApiManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

  @Provides @BaseUrl String provideBaseUrl() {
    return Constants.BASE_URL;
  }

  @Provides @ApiKey String provideWeatherApiKey() {
    return Constants.API_KEY;
  }

  @Provides @Singleton OkHttpClient provideHttpClient() {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    httpClient.addInterceptor(logging);
    Log.d(getClass().getSimpleName(), httpClient.toString());

    return httpClient.build();
  }

  @Provides @Singleton Retrofit provideRetrofit(@BaseUrl String baseUrl,
      OkHttpClient okHttpClient) {
    Log.d(getClass().getSimpleName(), baseUrl);
    return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
