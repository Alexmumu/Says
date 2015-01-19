package org.dateutil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
  public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
  public static String getDateStr(Date date){
	  return sdf.format(date);
  }
}
