package com.my.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommUtil {
	
	static public String DateToString(Date date,String format){
		SimpleDateFormat transFormat = new SimpleDateFormat(format);
		return transFormat.format(date);
	}
	
	static public Date StringToDate(String str,String format){
		SimpleDateFormat transFormat = new SimpleDateFormat(format);		
		Date result = null;
		try {
			result = transFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}

}
