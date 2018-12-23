package com.shijo.contracts;

import com.shijo.view.base.BasePresenterContract;
import com.shijo.view.weather.ForecastViewHolder;

public interface ForecastAdapterPresenterContract<V extends ForecastAdapterViewContract>
    extends BasePresenterContract<V> {
  void onBindForecastItemAtPosition(int position, ForecastViewHolder forecastViewHolder);

  int getForecastItemsCount();
}
