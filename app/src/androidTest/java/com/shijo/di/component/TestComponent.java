package com.shijo.di.component;

import com.shijo.di.module.ApplicationTestModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationTestModule.class) public interface TestComponent
    extends ApplicationComponent {
}
