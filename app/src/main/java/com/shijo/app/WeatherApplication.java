package com.shijo.app;

import android.app.Application;
import com.shijo.di.component.ApplicationComponent;
import com.shijo.di.component.DaggerApplicationComponent;
import com.shijo.di.module.ApplicationModule;
import com.shijo.model.DataManager;
import javax.inject.Inject;

public class WeatherApplication extends Application {
  @Inject DataManager mDataManager;
  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    mApplicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    mApplicationComponent.inject(this);
  }

  public ApplicationComponent getComponent() {
    return mApplicationComponent;
  }

  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
