/*package com.jst.framework.common.util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil
{
  public static final String PATTERN_DATE = "yyyy-MM-dd";
  public static final String PATTERN_DATE_TWO = "yyyyMMdd";
  public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
  public static final String PATTERN_DATE_TIME_TWO = "MMddHHmmss";
  public static final String PATTERN_DATE_TIME_MILL = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String PATTERN_DATE_TIME_MILL_TWO = "yyyyMMddHHmmss";
  public static final String PATTERN_TIME = "HH:mm:ss";
  public static final String PATTERN_TIME_TWO = "HHmmss";
  
  public static String getSysDate()
  {
    return getDateStr("yyyy-MM-dd");
  }
  
  public static Integer getCuSysDate()
  {
    return Integer.valueOf(Integer.parseInt(getDateStr("yyyyMMdd")));
  }
  
  public static Integer getCuSysDate(Date date)
  {
    return Integer.valueOf(Integer.parseInt(getDateStr(date, "yyyyMMdd")));
  }
  
  public static String getSysDateTimeStr()
  {
    return getDateStr("MMddHHmmss");
  }
  
  public static String getSysDateTimeMillisForBussNo()
  {
    return getDateStr("yyyyMMddHHmmss");
  }
  
  public static String getSysDateTime()
  {
    return getDateStr("yyyy-MM-dd HH:mm:ss");
  }
  
  public static String getSysDateTimeMillis()
  {
    return getDateStr("yyyy-MM-dd HH:mm:ss.SSS");
  }
  
  public static String getDateStr(String pattern)
  {
    return format(new Date(), pattern);
  }
  
  public static String getDateStr(Date date, String pattern)
  {
    return format(date, pattern);
  }
  
  public static String format(Date date, String pattern)
  {
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    return formatter.format(date);
  }
  
  public static Date parseFormatDate(String aDateStr)
  {
    return parseFormatDate(aDateStr, "yyyy-MM-dd");
  }
  
  public static Date parseFormatDate(String aDateStr, String aDateFmtStr)
  {
    SimpleDateFormat smt = new SimpleDateFormat(aDateFmtStr);
    if ((aDateStr == null) || (aDateStr.equals(""))) {
      return null;
    }
    try
    {
      ret = smt.parse(aDateStr.trim());
    }
    catch (ParseException e)
    {
      Date ret;
      e.printStackTrace();
      return null;
    }
    Date ret;
    return ret;
  }
  
  public static String getMonthBegin(String strdate)
  {
    Date date = parseFormatDate(strdate);
    return formatDateByFormat(date, "yy-MM") + "-01";
  }
  
  public static String getMonthEnd(String strdate)
  {
    Date date = parseFormatDate(getMonthBegin(strdate));
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(2, 1);
    calendar.add(6, -1);
    return formatDate(calendar.getTime());
  }
  
  public static String formatDate(Date date)
  {
    return formatDateByFormat(date, "yyyy-MM-dd");
  }
  
  public static String formatDateByFormat(Date date, String format)
  {
    String result = "";
    if ((date != null) && (!"".equals(date))) {
      try
      {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        result = sdf.format(date);
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
    return result;
  }
  
  public static String formatStrDateToOtherFt(String StrDate, String StrConvertDateFt, String outPutFormat)
  {
    if ((StringUtils.isNotEmpty(StrDate)) && (StringUtils.isNotEmpty(StrConvertDateFt)) && (StringUtils.isNotEmpty(outPutFormat)))
    {
      Date dt = parseFormatDate(StrDate, StrConvertDateFt);
      String outPutDate = formatDateByFormat(dt, outPutFormat);
      return outPutDate;
    }
    return null;
  }
  
  public static Date getLastDateOfMonth(Date date, int i)
  {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.add(2, 1);
    c.set(5, 1);
    c.add(5, -i);
    c.set(10, 0);
    c.add(13, -1);
    return c.getTime();
  }
  
  public static Date getLastDateOfLastMonth(Date date, int i)
  {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.set(5, 1);
    c.add(5, -i);
    c.set(10, 0);
    c.add(13, -1);
    return c.getTime();
  }
  
  public static Date getDateOfMonth(Date date, int i)
  {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.set(5, i);
    return c.getTime();
  }
  
  public static Date getDateOfYear(Date date, int i)
  {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.set(2, i - 1);
    return c.getTime();
  }
  
  public static Date[] getSeason(Date date)
  {
    if (date != null)
    {
      Date[] season = new Date[2];
      try
      {
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
        String year = new SimpleDateFormat("yyyy").format(date);
        switch (month)
        {
        case 1: 
        case 2: 
        case 3: 
          season[0] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-1-1");
          season[1] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-3-31");
          break;
        case 4: 
        case 5: 
        case 6: 
          season[0] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-4-1");
          season[1] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-6-30");
          break;
        case 7: 
        case 8: 
        case 9: 
          season[0] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-7-1");
          season[1] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-9-30");
          break;
        case 10: 
        case 11: 
        case 12: 
          season[0] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-10-1");
          season[1] = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-12-31");
        }
      }
      catch (Exception localException) {}
      return season;
    }
    return null;
  }
  
  public static Date[] getMonth(Date date)
  {
    Date[] dates = new Date[2];
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.set(5, 1);
    dates[0] = c.getTime();
    c.add(2, 1);
    c.add(5, -1);
    dates[1] = c.getTime();
    return dates;
  }
  
  public static Date getRelativeDate(Date now, int relative, String style)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(style);
    Calendar c = Calendar.getInstance();
    try
    {
      c.setTime(sdf.parse(sdf.format(now)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    if (relative != 0) {
      c.add(5, relative);
    }
    return c.getTime();
  }
  
  public static Date getRelativeMonth(Date now, int relative)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    if (relative != 0) {
      c.add(2, relative);
    }
    return c.getTime();
  }
  
  public static String getRelativeMonth(Date now, int relative, String style)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(style);
    Calendar c = Calendar.getInstance();
    try
    {
      c.setTime(sdf.parse(sdf.format(now)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    if (relative != 0) {
      c.add(2, relative);
    }
    return sdf.format(c.getTime());
  }
  
  public static String getRelativeMonth(String now, int relative, String style)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(style);
    Calendar c = Calendar.getInstance();
    try
    {
      c.setTime(sdf.parse(now));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    if (relative != 0) {
      c.add(2, relative);
    }
    return sdf.format(c.getTime());
  }
  
  public static Integer getIntervalDays(Date startday, Date endday)
  {
    Calendar fromCalendar = Calendar.getInstance();
    fromCalendar.setTime(startday);
    fromCalendar.set(11, 0);
    fromCalendar.set(12, 0);
    fromCalendar.set(13, 0);
    fromCalendar.set(14, 0);
    
    Calendar toCalendar = Calendar.getInstance();
    toCalendar.setTime(endday);
    toCalendar.set(11, 0);
    toCalendar.set(12, 0);
    toCalendar.set(13, 0);
    toCalendar.set(14, 0);
    
    return Integer.valueOf((int)((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / 86400000L));
  }
  
  public static Integer getIntervalMonth(Date startDate, Date endday)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    int s = calendar.get(2);
    calendar.setTime(endday);
    return Integer.valueOf(s - calendar.get(2));
  }
  
  public static List<String> getMonthsBetweenTwoDays(String startDateStr, String endDateStr)
  {
    Date startDate = parseFormatDate(startDateStr, "yyyy-MM");
    Date endDate = parseFormatDate(endDateStr, "yyyy-MM");
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    List<String> dateList = new ArrayList();
    while (startDate.before(endDate))
    {
      dateList.add(formatDateByFormat(startDate, "yyyyMM"));
      calendar.add(2, 1);
      startDate = calendar.getTime();
    }
    dateList.add(formatDateByFormat(endDate, "yyyyMM"));
    return dateList;
  }
  
  public static List<String> getMonthsBetweenTwoDaysDesc(String startDateStr, String endDateStr)
  {
    Date startDate = parseFormatDate(startDateStr, "yyyy-MM");
    Date endDate = parseFormatDate(endDateStr, "yyyy-MM");
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(endDate);
    List<String> dateList = new ArrayList();
    while (endDate.after(startDate))
    {
      dateList.add(formatDateByFormat(endDate, "yyyyMM"));
      calendar.add(2, -1);
      endDate = calendar.getTime();
    }
    dateList.add(formatDateByFormat(startDate, "yyyyMM"));
    return dateList;
  }
  
  public static int getMonthEndInt(String date)
  {
    int endDayInt = -1;
    String endDay = getMonthEnd(date);
    if ((endDay != null) && (!"".equals(endDay))) {
      endDayInt = Integer.parseInt(endDay.substring(endDay.lastIndexOf("-") + 1));
    }
    return endDayInt;
  }
  
  public static void main(String[] args)
    throws ParseException
  {
    System.out.println(getRelativeMonth(new Date(), -4, "yyyy-MM"));
    System.out.println(getRelativeMonth(new Date(), -1, "yyyy-MM"));
    System.out.println(getLastDateOfLastMonth(new Date(), 0));
    System.out.println(getMonthEndInt("2010-02-01"));
    System.out.println(getRelativeMonth(new Date(), -1, "yyyyMMddHHmmss"));
    String Sdate = "000000";
    String Edate = "075959";
    Date dt = parseFormatDate(Sdate, "HHmmss");
    Date dt2 = parseFormatDate(Edate, "HHmmss");
    String strdate = formatDateByFormat(dt, "HH:mm:ss");
    String edate = formatDateByFormat(dt2, "HH:mm:ss");
    System.err.println("strdate=" + strdate + "~" + edate + "=edate");
  }
  
  public static Date getDatePossible(String datestr)
  {
    String[] fmt = { "MM/dd/yyyy", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" };
    Date ret = null;
    try
    {
      ret = DateUtils.parseDate(datestr, fmt);
    }
    catch (ParseException e)
    {
      ret = null;
    }
    return ret;
  }
  
  public static Date getLastDay(Date date)
  {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.add(5, -1);
    return c.getTime();
  }
  
  public static Date getNextDay(Date date)
  {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      c.setTime(sdf.parse(sdf.format(date)));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    c.add(5, 1);
    return c.getTime();
  }
  
  public static String dateToString(String date)
  {
    String[] dateArr = date.split("-");
    int m = Integer.parseInt(dateArr[1]);
    StringBuffer result = new StringBuffer();
    switch (m)
    {
    case 1: 
      result.append(dateArr[2]).append("JAN");
      break;
    case 2: 
      result.append(dateArr[2]).append("FEB");
      break;
    case 3: 
      result.append(dateArr[2]).append("MAR");
      break;
    case 4: 
      result.append(dateArr[2]).append("APR");
      break;
    case 5: 
      result.append(dateArr[2]).append("MAY");
      break;
    case 6: 
      result.append(dateArr[2]).append("JUN");
      break;
    case 7: 
      result.append(dateArr[2]).append("JUL");
      break;
    case 8: 
      result.append(dateArr[2]).append("AUG");
      break;
    case 9: 
      result.append(dateArr[2]).append("SEP");
      break;
    case 10: 
      result.append(dateArr[2]).append("OCT");
      break;
    case 11: 
      result.append(dateArr[2]).append("NOV");
      break;
    case 12: 
      result.append(dateArr[2]).append("DEC");
      break;
    }
    return result.toString();
  }
  
  public static int getCurrentMonth()
  {
    Calendar c = Calendar.getInstance();
    int month = c.get(2) + 1;
    return month;
  }
}
*/