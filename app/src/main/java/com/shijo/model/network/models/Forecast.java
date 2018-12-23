package com.shijo.model.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable {

  @SerializedName("forecastday") private List<ForecastdayItem> forecastday;

  public void setForecastday(List<ForecastdayItem> forecastday) {
    this.forecastday = forecastday;
  }

  public List<ForecastdayItem> getForecastday() {
    return forecastday;
  }
}