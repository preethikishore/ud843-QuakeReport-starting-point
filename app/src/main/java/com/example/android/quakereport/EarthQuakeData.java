package com.example.android.quakereport;

import android.icu.text.DecimalFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EarthQuakeData {
    private double quakeMagnitude;
    private String quakeLocation;
    private Long quakeTime;
    private String url_path;
    public EarthQuakeData(double eqMag, String eqLocation,Long eqTime,String url)
    {
      this.quakeMagnitude = eqMag;
      this.quakeLocation = eqLocation;
      this.quakeTime = eqTime;
      this.url_path = url;
    }


    public Double getQuakeMagnitude()
    {
        return quakeMagnitude;
    }
    public String getQuakeLocation()
    {
        return quakeLocation;
    }

    public String  getQuakeDate() {
        return formatDate(quakeTime);
    }

    public String  getQuakeTime() {
        return formatTime(quakeTime);
    }
    public String geturl_path()
    {
        return url_path;
    }

    private String formatDate(Long dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Long dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
