package com.shijo.di.component;

import com.shijo.di.PerActivity;
import com.shijo.di.module.ActivityModule;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
}
