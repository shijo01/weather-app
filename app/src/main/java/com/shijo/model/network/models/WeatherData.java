package com.shijo.model.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WeatherData implements Serializable {

  @SerializedName("current") private Current current;

  @SerializedName("location") private Location location;

  @SerializedName("forecast") private Forecast forecast;

  public Current getCurrent() {
    return current;
  }

  public Location getLocation() {
    return location;
  }

  public Forecast getForecast() {
    return forecast;
  }
}