package com.shijo.di.component;

import com.shijo.di.PerActivity;
import com.shijo.di.module.ActivityModule;
import com.shijo.view.weather.ForecastFragment;
import com.shijo.view.weather.WeatherFragment;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  void inject(WeatherFragment weatherFragment);

  void inject(ForecastFragment forecastFragment);
}
