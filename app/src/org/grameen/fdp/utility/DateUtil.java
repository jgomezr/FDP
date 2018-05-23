package org.grameen.fdp.utility;


import android.util.Log;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by AangJnr on 9/20/16.
 */
public class DateUtil {


    static String TAG = "DateUtil";
    public static String getDateInMillisToString() {

        long now = System.currentTimeMillis();

        return String.valueOf(now);

    }


    public static String getFormattedDate() {


        DateFormat df = new SimpleDateFormat("yyyy.MM.dd", Locale.US);
        return df.format(Calendar.getInstance().getTime());


    }

    public static String getFormattedDateMMDDYYYY() {


        DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        return df.format(Calendar.getInstance().getTime());


    }

    public static String getFormattedDateMMDDYYYYhhmmaa() {


        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US);
        return df.format(Calendar.getInstance().getTime());


    }


    public static Date formatDateMMDDYYYYhhmma() {

        String dateString = getFormattedDateMMDDYYYYhhmmaa();
        //Log.i(TAG, "DATE IS " + dateString);

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault());

        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }

        return date;
    }


    public static Date stringToDateMMDDYYYYhhmma(String s) {

        Date date = null;
        try {
            date = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH).parse(s);
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }

        return date;
    }


    public static Date formatDateMMDDYYYY() {

        String dateString = getFormattedDateMMDDYYYY();
        //Log.i(TAG, "DATE IS " + dateString);

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());

        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
        }

        return date;
    }




    //3/1/2018 12:20 PM

    public static String getFormattedTime() {

        DateFormat df = new SimpleDateFormat(" '@' HH:mm:ss", Locale.US);
        return df.format(Calendar.getInstance().getTime());


    }


    public static String convertStringToPrettyTime(String date) {

        try {
            PrettyTime prettyTime = new PrettyTime();
            long l = Long.parseLong(date);

            return prettyTime.format(new Date(l));
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }


}








