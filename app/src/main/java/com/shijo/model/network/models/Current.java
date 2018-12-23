package com.shijo.model.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Current implements Serializable {

  @SerializedName("feelslike_c") private String feelslikeC;

  @SerializedName("uv") private String uv;

  @SerializedName("last_updated") private String lastUpdated;

  @SerializedName("feelslike_f") private double feelslikeF;

  @SerializedName("wind_degree") private String windDegree;

  @SerializedName("last_updated_epoch") private String lastUpdatedEpoch;

  @SerializedName("is_day") private String isDay;

  @SerializedName("precip_in") private String precipIn;

  @SerializedName("wind_dir") private String windDir;

  @SerializedName("temp_c") private String tempC;

  @SerializedName("pressure_in") private double pressureIn;

  @SerializedName("temp_f") private double tempF;

  @SerializedName("precip_mm") private String precipMm;

  @SerializedName("cloud") private String cloud;

  @SerializedName("wind_kph") private String windKph;

  @SerializedName("condition") private Condition condition;

  @SerializedName("wind_mph") private double windMph;

  @SerializedName("vis_km") private String visKm;

  @SerializedName("humidity") private String humidity;

  @SerializedName("pressure_mb") private String pressureMb;

  @SerializedName("vis_miles") private String visMiles;

  public void setFeelslikeC(String feelslikeC) {
    this.feelslikeC = feelslikeC;
  }

  public String getFeelslikeC() {
    return feelslikeC;
  }

  public void setUv(String uv) {
    this.uv = uv;
  }

  public String getUv() {
    return uv;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setFeelslikeF(double feelslikeF) {
    this.feelslikeF = feelslikeF;
  }

  public double getFeelslikeF() {
    return feelslikeF;
  }

  public void setWindDegree(String windDegree) {
    this.windDegree = windDegree;
  }

  public String getWindDegree() {
    return windDegree;
  }

  public void setLastUpdatedEpoch(String lastUpdatedEpoch) {
    this.lastUpdatedEpoch = lastUpdatedEpoch;
  }

  public String getLastUpdatedEpoch() {
    return lastUpdatedEpoch;
  }

  public void setIsDay(String isDay) {
    this.isDay = isDay;
  }

  public String getIsDay() {
    return isDay;
  }

  public void setPrecipIn(String precipIn) {
    this.precipIn = precipIn;
  }

  public String getPrecipIn() {
    return precipIn;
  }

  public void setWindDir(String windDir) {
    this.windDir = windDir;
  }

  public String getWindDir() {
    return windDir;
  }

  public void setTempC(String tempC) {
    this.tempC = tempC;
  }

  public String getTempC() {
    return tempC;
  }

  public void setPressureIn(double pressureIn) {
    this.pressureIn = pressureIn;
  }

  public double getPressureIn() {
    return pressureIn;
  }

  public void setTempF(double tempF) {
    this.tempF = tempF;
  }

  public double getTempF() {
    return tempF;
  }

  public void setPrecipMm(String precipMm) {
    this.precipMm = precipMm;
  }

  public String getPrecipMm() {
    return precipMm;
  }

  public void setCloud(String cloud) {
    this.cloud = cloud;
  }

  public String getCloud() {
    return cloud;
  }

  public void setWindKph(String windKph) {
    this.windKph = windKph;
  }

  public String getWindKph() {
    return windKph;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setWindMph(double windMph) {
    this.windMph = windMph;
  }

  public double getWindMph() {
    return windMph;
  }

  public void setVisKm(String visKm) {
    this.visKm = visKm;
  }

  public String getVisKm() {
    return visKm;
  }

  public void setHumidity(String humidity) {
    this.humidity = humidity;
  }

  public String getHumidity() {
    return humidity;
  }

  public void setPressureMb(String pressureMb) {
    this.pressureMb = pressureMb;
  }

  public String getPressureMb() {
    return pressureMb;
  }

  public void setVisMiles(String visMiles) {
    this.visMiles = visMiles;
  }

  public String getVisMiles() {
    return visMiles;
  }

  @Override public String toString() {
    return "Current{"
        + "feelslike_c = '"
        + feelslikeC
        + '\''
        + ",uv = '"
        + uv
        + '\''
        + ",last_updated = '"
        + lastUpdated
        + '\''
        + ",feelslike_f = '"
        + feelslikeF
        + '\''
        + ",wind_degree = '"
        + windDegree
        + '\''
        + ",last_updated_epoch = '"
        + lastUpdatedEpoch
        + '\''
        + ",is_day = '"
        + isDay
        + '\''
        + ",precip_in = '"
        + precipIn
        + '\''
        + ",wind_dir = '"
        + windDir
        + '\''
        + ",temp_c = '"
        + tempC
        + '\''
        + ",pressure_in = '"
        + pressureIn
        + '\''
        + ",temp_f = '"
        + tempF
        + '\''
        + ",precip_mm = '"
        + precipMm
        + '\''
        + ",cloud = '"
        + cloud
        + '\''
        + ",wind_kph = '"
        + windKph
        + '\''
        + ",condition = '"
        + condition
        + '\''
        + ",wind_mph = '"
        + windMph
        + '\''
        + ",vis_km = '"
        + visKm
        + '\''
        + ",humidity = '"
        + humidity
        + '\''
        + ",pressure_mb = '"
        + pressureMb
        + '\''
        + ",vis_miles = '"
        + visMiles
        + '\''
        + "}";
  }
}