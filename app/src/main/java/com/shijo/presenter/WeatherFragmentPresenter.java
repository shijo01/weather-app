package com.shijo.presenter;

import com.shijo.contracts.WeatherFragmentPresenterContract;
import com.shijo.contracts.WeatherFragmentViewContract;
import com.shijo.model.DataManager;
import com.shijo.model.network.models.WeatherData;
import com.shijo.utils.SchedulerProvider;
import com.shijo.view.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public class WeatherFragmentPresenter<V extends WeatherFragmentViewContract>
    extends BasePresenter<V> implements WeatherFragmentPresenterContract<V> {
  @Inject
  public WeatherFragmentPresenter(DataManager dataManager, SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    super(dataManager, schedulerProvider, compositeDisposable);
  }

  @Override public void getWeatherData(String weatherApiKey, String latitude, String longitude,
      int numberOfDays) {
    getCompositeDisposable().add(
        getDataManager().getWeatherData(weatherApiKey, latitude, longitude, numberOfDays)
            .observeOn(getSchedulerProvider().ui())
            .subscribeOn(getSchedulerProvider().io())
            .retry(3)
            .subscribe(this::onWeatherDataRetrieved, this::onFailureRetrievingWeatherData));
  }

  private void onFailureRetrievingWeatherData(Throwable throwable) {
    if (isViewAttached()) {
      getView().onError("Failed to get weather data!");
    }
  }

  private void onWeatherDataRetrieved(WeatherData weatherData) {
    if (isViewAttached()) {
      if (weatherData.getForecast().getForecastday().size() > 0) {
        weatherData.getForecast().getForecastday().remove(0);
        getDataManager().setForecastData(weatherData.getForecast().getForecastday());
      }
      getDataManager().setForecastData(weatherData.getForecast().getForecastday());
      getView().displayWeatherData(weatherData.getCurrent().getTempC(),
          weatherData.getLocation().getName(), weatherData.getLocation().getCountry(),
          weatherData.getCurrent().getCondition().getText(),
          weatherData.getCurrent().getCondition().getIcon());
    }
  }
}
