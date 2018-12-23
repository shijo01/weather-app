

package com.shijo;

import android.content.Context;
import com.shijo.app.WeatherApplication;
import com.shijo.di.component.TestComponent;
import com.shijo.di.module.ApplicationTestModule;
import com.shijo.model.DataManager;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestComponentRule implements TestRule {

  private TestComponent mTestComponent;
  private Context mContext;

  public TestComponentRule(Context context) {
    mContext = context;
  }

  public Context getContext() {
    return mContext;
  }

  public DataManager getDataManager() {
    return mTestComponent.getDataManager();
  }

  private void setupDaggerTestComponentInApplication() {
    WeatherApplication application = ((WeatherApplication) mContext.getApplicationContext());
    mTestComponent = DaggerTestComponent.builder()
        .applicationTestModule(new ApplicationTestModule(application))
        .build();
    application.setComponent(mTestComponent);
  }

  @Override public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override public void evaluate() throws Throwable {
        try {
          setupDaggerTestComponentInApplication();
          base.evaluate();
        } finally {
          mTestComponent = null;
        }
      }
    };
  }
}
