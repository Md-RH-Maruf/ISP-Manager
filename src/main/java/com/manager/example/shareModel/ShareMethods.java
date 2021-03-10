package com.manager.example.shareModel;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ShareMethods {

	 public static Date addDay(Date date, int i) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_YEAR, i);
	        return cal.getTime();
	    }
	    public static Date addMonth(Date date, int i) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.MONTH, i);
	        return cal.getTime();
	    }
	    public static Date addYear(Date date, int i) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.YEAR, i);
	        return cal.getTime();
	    }
}
