package com.shijo.utils;

import android.content.Context;
import android.location.LocationManager;

public class DeviceUtils {
  public static boolean isGpsEnabled(Context context) {

    LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    boolean gps_enabled = false;
    boolean network_enabled = false;

    try {
      gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
      network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return network_enabled;
  }
}