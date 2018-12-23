package com.shijo.presenter;

import com.shijo.contracts.ForecastAdapterPresenterContract;
import com.shijo.contracts.ForecastAdapterViewContract;
import com.shijo.model.DataManager;
import com.shijo.model.network.models.ForecastdayItem;
import com.shijo.utils.SchedulerProvider;
import com.shijo.view.base.BasePresenter;
import com.shijo.view.weather.ForecastViewHolder;
import io.reactivex.disposables.CompositeDisposable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;

public class ForecastAdapterPresenter<V extends ForecastAdapterViewContract>
    extends BasePresenter<V> implements ForecastAdapterPresenterContract<V> {
  @Inject
  public ForecastAdapterPresenter(DataManager dataManager, SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    super(dataManager, schedulerProvider, compositeDisposable);
  }

  @Override
  public void onBindForecastItemAtPosition(int position, ForecastViewHolder forecastViewHolder) {
    ForecastdayItem forecastdayItem = getDataManager().getForecastData().get(position);
    try {
      SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
      Date dt1 = null;
      dt1 = format1.parse(forecastdayItem.getDate());
      DateFormat format2 = new SimpleDateFormat("EEEE");
      String finalDay = format2.format(dt1);
      forecastViewHolder.setDayAndCondition(
          finalDay + " \u2022 " + forecastdayItem.getDay().getCondition().getText());
    } catch (ParseException e) {
      forecastViewHolder.setDayAndCondition(forecastdayItem.getDate() + " \u2022 " + forecastdayItem
          .getDay()
          .getCondition()
          .getText());
    }

    forecastViewHolder.setWeatherConditionImage(
        "https://" + forecastdayItem.getDay().getCondition().getIcon());

    forecastViewHolder.setMinimumAndMaximumTemperature(
        forecastdayItem.getDay().getMaxtempC().split("\\.")[0] + " / " + forecastdayItem.getDay()
            .getMintempC()
            .split("\\.")[0] + "\u00b0C");
  }

  @Override public int getForecastItemsCount() {
    return 5;
  }
}
