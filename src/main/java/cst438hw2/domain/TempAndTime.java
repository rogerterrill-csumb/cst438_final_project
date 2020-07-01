package cst438hw2.domain;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TempAndTime {

  public double temp;
  public long time;
  public int timezone;

  public TempAndTime(double temp, long time, int timezone) {
    this.temp = temp;
    this.time = time;
    this.timezone = timezone;
  }

  public double getTemp() {
    return temp;
  }

  public double getFormattedTemp() {
    Double fTemp = (temp-273.15) * (9.0 / 5.0) + 32;
    DecimalFormat df = new DecimalFormat("#.##");
    return Double.valueOf(df.format(fTemp));
  }

  public void setTemp(double temp) {
    this.temp = temp;
  }

  public long getTime() {
    return time;
  }

  public String getFormattedTime() {
    System.out.println(time);
    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(time * 1000);
    return formatter.format(calendar.getTime());
  }

  public void setTime(long time) {
    this.time = time;
  }

  public int getTimezone() {
    return timezone;
  }

  public void setTimezone(int timezone) {
    this.timezone = timezone;
  }

  @Override
  public String toString() {
    return "TempAndTime{" +
        "temp=" + temp +
        ", time=" + time +
        ", timezone=" + timezone +
        '}';
  }
}