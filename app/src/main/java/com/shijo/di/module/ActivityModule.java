package com.shijo.di.module;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.shijo.contracts.ForecastAdapterViewContract;
import com.shijo.contracts.WeatherFragmentPresenterContract;
import com.shijo.contracts.WeatherFragmentViewContract;
import com.shijo.di.ActivityContext;
import com.shijo.di.PerActivity;
import com.shijo.presenter.ForecastAdapterPresenter;
import com.shijo.presenter.WeatherFragmentPresenter;
import com.shijo.utils.AppSchedulerProvider;
import com.shijo.utils.SchedulerProvider;
import com.shijo.view.weather.ForecastAdapter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module public class ActivityModule {
  private Activity mActivity;

  public ActivityModule(AppCompatActivity activity) {
    this.mActivity = activity;
  }

  @Provides @ActivityContext Context provideContext() {
    return mActivity;
  }

  @Provides Activity provideActivity() {
    return mActivity;
  }

  @Provides CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }

  @Provides SchedulerProvider provideSchedulerProvider() {
    return new AppSchedulerProvider();
  }

  @Provides @PerActivity
  WeatherFragmentPresenterContract<WeatherFragmentViewContract> provideWeatherFragmentPresenter(
      WeatherFragmentPresenter<WeatherFragmentViewContract> presenter) {
    return presenter;
  }

  @Provides @PerActivity ForecastAdapter provideForecastAdapter(
      ForecastAdapterPresenter<ForecastAdapterViewContract> presenter) {
    return new ForecastAdapter(presenter);
  }
}
