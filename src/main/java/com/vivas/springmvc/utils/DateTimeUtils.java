/*
 * Copyright (C) 2010 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.vivas.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sondm2@viettel.com.vn
 * @since Apr,12,2010
 * @version 1.0
 */
public class DateTimeUtils {

    /**
     * .
     */
    public static final int CONST3 = 3;
    /**
     * .
     */
    public static final int CONST4 = 4;
    /**
     * .
     */
    public static final int CONST5 = 5;
    /**
     * .
     */
    public static final int CONST6 = 6;
    /**
     * .
     */
    public static final int CONST7 = 7;
    /**
     * .
     */
    public static final int CONST8 = 8;
    /**
     * .
     */
    public static final int CONST9 = 9;
    /**
     * .
     */
    public static final int CONST10 = 10;
    /**
     * .
     */
    public static final int CONST11 = 11;
    /**
     * .
     */
    public static final int CONST12 = 12;

    /**
     * private constructor
     */
    private DateTimeUtils() {
    }

    /**
     *
     * @param date to convert
     * @param pattern in converting
     * @return date
     */
    public static Date convertStringToTime(String date, String pattern) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(date);

        } catch (ParseException e) {
            System.out.println("Date ParseException, string value:" + date);
            throw e;
        }
    }

    /**
     *
     * @param date to convert
     * @return String
     * @throws Exception if error
     */
    public static Date convertStringToDate(String date) throws Exception {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        if (date.length() <= 10) {
            date = date + " 00:00:00";
        }
        return convertStringToTime(date, pattern);
    }

    /**
     *
     * @param date to convert
     * @return String
     * @throws Exception if error
     */
    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (date == null) {
            return "";
        }
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            throw e;
        }
    }

    public static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        if (date == null) {
            return "";
        }
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     *
     * @return String
     * @throws Exception if error
     */
    public static String getSysdate() throws Exception {
        Calendar calendar = Calendar.getInstance();
        return convertDateToString(calendar.getTime());
    }

    /**
     *
     * @return String
     * @throws Exception if error
     */
    public static String getSysDateTime() throws Exception {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return dateFormat.format(calendar.getTime());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param pattern to convert
     * @return String
     * @throws Exception if error
     */
    public static String getSysDateTime(String pattern) throws Exception {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.format(calendar.getTime());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param date to convert
     * @return String
     * @throws Exception if error
     */
    public static Date convertStringToDateTime(String date) throws Exception {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        return convertStringToTime(date, pattern);
    }

    /**
     *
     * @param date to convert
     * @return String
     * @throws Exception if error
     */
    public static String convertDateTimeToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param utilDate to convert
     * @return date
     */
    public static java.sql.Date convertToSqlDate(Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }

    /**
     *
     * @param monthInput to parse
     * @return String
     */
    public static String parseDate(int monthInput) {
        String dateReturn = "01/01/";
        Calendar cal = Calendar.getInstance();
        switch (monthInput) {
            case 1:
                dateReturn = "01/01/";
                break;
            case 2:
                dateReturn = "01/02/";
                break;
            case CONST3:
                dateReturn = "01/03/";
                break;
            case CONST4:
                dateReturn = "01/04/";
                break;
            case CONST5:
                dateReturn = "01/05/";
                break;
            case CONST6:
                dateReturn = "01/06/";
                break;
            case CONST7:
                dateReturn = "01/07/";
                break;
            case CONST8:
                dateReturn = "01/08/";
                break;
            case CONST9:
                dateReturn = "01/09/";
                break;
            case CONST10:
                dateReturn = "01/10/";
                break;
            case CONST11:
                dateReturn = "01/11/";
                break;
            case CONST12:
                dateReturn = "01/12/";
                break;
        }
        return dateReturn + cal.get(Calendar.YEAR);
    }

    public static int compareDateTime(Date d1, Date d2) {
        int result = 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (cal1.after(cal2)) {
            result = 1;
        } else if (cal1.before(cal2)) {
            result = -1;
        }
        return result;
    }

    public static String date2ddMMyyyyString(Date value) {
        if (value != null) {
            SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
            return ddMMyyyy.format(value);
        }
        return "";
    }

    public static Date string2Date(String value) throws ParseException {
        if (!DateTimeUtils.isNullOrEmpty(value)) {
            SimpleDateFormat dateTime = new SimpleDateFormat(
                    "dd/MM/yyyy");
            return dateTime.parse(value);
        }
        return null;
    }

    public static boolean isNullOrEmpty(String obj1) {
        return (obj1 == null || "".equals(obj1.trim()));
    }

    public static String getSysdate(String format) {
        String selectTocharSysdate = "select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual";
        long time = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(time);
        return convertDateToString(date, format);
    }
}
