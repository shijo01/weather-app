package com.shijo.model.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Day implements Serializable {

  @SerializedName("avgvis_km") private double avgvisKm;

  @SerializedName("uv") private double uv;

  @SerializedName("avgtemp_f") private double avgtempF;

  @SerializedName("avgtemp_c") private double avgtempC;

  @SerializedName("maxtemp_c") private String maxtempC;

  @SerializedName("maxtemp_f") private double maxtempF;

  @SerializedName("mintemp_c") private String mintempC;

  @SerializedName("avgvis_miles") private String avgvisMiles;

  @SerializedName("mintemp_f") private double mintempF;

  @SerializedName("totalprecip_in") private String totalprecipIn;

  @SerializedName("avghumidity") private String avghumidity;

  @SerializedName("condition") private Condition condition;

  @SerializedName("maxwind_kph") private double maxwindKph;

  @SerializedName("maxwind_mph") private double maxwindMph;

  @SerializedName("totalprecip_mm") private String totalprecipMm;

  public String getAvghumidity() {
    return avghumidity;
  }

  public double getAvgvisKm() {
    return avgvisKm;
  }

  public void setAvgvisKm(double avgvisKm) {
    this.avgvisKm = avgvisKm;
  }

  public double getUv() {
    return uv;
  }

  public void setUv(double uv) {
    this.uv = uv;
  }

  public double getAvgtempF() {
    return avgtempF;
  }

  public void setAvgtempF(double avgtempF) {
    this.avgtempF = avgtempF;
  }

  public double getAvgtempC() {
    return avgtempC;
  }

  public void setAvgtempC(double avgtempC) {
    this.avgtempC = avgtempC;
  }

  public String getMaxtempC() {
    return maxtempC;
  }

  public void setMaxtempC(String maxtempC) {
    this.maxtempC = maxtempC;
  }

  public double getMaxtempF() {
    return maxtempF;
  }

  public void setMaxtempF(double maxtempF) {
    this.maxtempF = maxtempF;
  }

  public String getMintempC() {
    return mintempC;
  }

  public void setMintempC(String mintempC) {
    this.mintempC = mintempC;
  }

  public String getAvgvisMiles() {
    return avgvisMiles;
  }

  public void setAvgvisMiles(String avgvisMiles) {
    this.avgvisMiles = avgvisMiles;
  }

  public double getMintempF() {
    return mintempF;
  }

  public void setMintempF(double mintempF) {
    this.mintempF = mintempF;
  }

  public String getTotalprecipIn() {
    return totalprecipIn;
  }

  public void setTotalprecipIn(String totalprecipIn) {
    this.totalprecipIn = totalprecipIn;
  }

  public void setAvghumidity(String avghumidity) {
    this.avghumidity = avghumidity;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public double getMaxwindKph() {
    return maxwindKph;
  }

  public void setMaxwindKph(double maxwindKph) {
    this.maxwindKph = maxwindKph;
  }

  public double getMaxwindMph() {
    return maxwindMph;
  }

  public void setMaxwindMph(double maxwindMph) {
    this.maxwindMph = maxwindMph;
  }

  public String getTotalprecipMm() {
    return totalprecipMm;
  }

  public void setTotalprecipMm(String totalprecipMm) {
    this.totalprecipMm = totalprecipMm;
  }

  @Override public String toString() {
    return "Day{"
        + "avgvis_km = '"
        + avgvisKm
        + '\''
        + ",uv = '"
        + uv
        + '\''
        + ",avgtemp_f = '"
        + avgtempF
        + '\''
        + ",avgtemp_c = '"
        + avgtempC
        + '\''
        + ",maxtemp_c = '"
        + maxtempC
        + '\''
        + ",maxtemp_f = '"
        + maxtempF
        + '\''
        + ",mintemp_c = '"
        + mintempC
        + '\''
        + ",avgvis_miles = '"
        + avgvisMiles
        + '\''
        + ",mintemp_f = '"
        + mintempF
        + '\''
        + ",totalprecip_in = '"
        + totalprecipIn
        + '\''
        + ",avghumidity = '"
        + avghumidity
        + '\''
        + ",condition = '"
        + condition
        + '\''
        + ",maxwind_kph = '"
        + maxwindKph
        + '\''
        + ",maxwind_mph = '"
        + maxwindMph
        + '\''
        + ",totalprecip_mm = '"
        + totalprecipMm
        + '\''
        + "}";
  }
}