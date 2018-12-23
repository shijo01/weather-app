package com.shijo.presenter;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.shijo.model.AppDataManager;
import com.shijo.utils.AppSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(AndroidJUnit4.class) public class WeatherFragmentPresenterTest {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
  @InjectMocks AppSchedulerProvider schedulerProvider;
  CompositeDisposable compositeDisposable = new CompositeDisposable();
  @InjectMocks AppDataManager dataManager;

  @Before public void setUp() {

  }

  @Test public void testAttach() {
  }
}
