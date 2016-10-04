package com.my.blog.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
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
	
	static public boolean isNumberic(String str){		
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}

}
