package com.shijo.di.module;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.shijo.di.ActivityContext;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {
  private Activity mActivity;

  public ActivityModule(AppCompatActivity activity) {
    this.mActivity = activity;
  }
  //
  //@Provides @ActivityContext Context provideContext() {
  //  return mActivity;
  //}
  //
  //@Provides Activity provideActivity() {
  //  return mActivity;
  //}
}
