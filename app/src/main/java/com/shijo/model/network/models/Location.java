package com.shijo.model.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Location implements Serializable {

  @SerializedName("localtime") private String localtime;

  @SerializedName("country") private String country;

  @SerializedName("localtime_epoch") private String localtimeEpoch;

  @SerializedName("name") private String name;

  @SerializedName("lon") private String lon;

  @SerializedName("region") private String region;

  @SerializedName("lat") private String lat;

  @SerializedName("tz_id") private String tzId;

  public void setLocaltime(String localtime) {
    this.localtime = localtime;
  }

  public String getLocaltime() {
    return localtime;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountry() {
    return country;
  }

  public void setLocaltimeEpoch(String localtimeEpoch) {
    this.localtimeEpoch = localtimeEpoch;
  }

  public String getLocaltimeEpoch() {
    return localtimeEpoch;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public String getLon() {
    return lon;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getRegion() {
    return region;
  }

  public void setTzId(String tzId) {
    this.tzId = tzId;
  }

  public String getTzId() {
    return tzId;
  }

  @Override public String toString() {
    return "Location{"
        + "localtime = '"
        + localtime
        + '\''
        + ",country = '"
        + country
        + '\''
        + ",localtime_epoch = '"
        + localtimeEpoch
        + '\''
        + ",name = '"
        + name
        + '\''
        + ",lon = '"
        + lon
        + '\''
        + ",region = '"
        + region
        + '\''
        + ",lat = '"
        + lat
        + '\''
        + ",tz_id = '"
        + tzId
        + '\''
        + "}";
  }
}