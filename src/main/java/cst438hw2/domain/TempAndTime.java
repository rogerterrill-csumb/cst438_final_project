package cst438hw2.domain;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TempAndTime {

  private double temp;
  private long time;
  private int timezone;

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
    Instant instant = Instant.ofEpochSecond(time);
    ZoneOffset offset = ZoneOffset.ofTotalSeconds(timezone);
    OffsetDateTime offsetDate = instant.atOffset(offset);
    String timeFormat = "hh:mm a";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timeFormat);
    return offsetDate.format(dtf);
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