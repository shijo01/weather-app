package com.shijo.di.component;

import android.app.Application;
import android.content.Context;
import com.shijo.app.WeatherApplication;
import com.shijo.di.ApplicationContext;
import com.shijo.di.module.ApplicationModule;
import com.shijo.model.DataManager;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {

  void inject(WeatherApplication weatherApplication);

  @ApplicationContext Context context();

  Application application();

  DataManager getDataManager();
}
