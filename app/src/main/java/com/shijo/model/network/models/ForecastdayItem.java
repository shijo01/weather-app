package com.shijo.model.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ForecastdayItem implements Serializable {

  @SerializedName("date") private String date;

  @SerializedName("date_epoch") private String dateEpoch;

  @SerializedName("day") private Day day;

  public void setDate(String date) {
    this.date = date;
  }

  public String getDate() {
    return date;
  }

  public void setDateEpoch(String dateEpoch) {
    this.dateEpoch = dateEpoch;
  }

  public String getDateEpoch() {
    return dateEpoch;
  }

  public void setDay(Day day) {
    this.day = day;
  }

  public Day getDay() {
    return day;
  }
}