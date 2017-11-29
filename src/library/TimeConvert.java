package library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConvert {
	public static String getStringDatetime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dateFormat.format(cal.getTime());
	}
	public static Date getDateTime(String stringDate) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date date = df.parse(stringDate);
			return date;
		}
		catch (ParseException ex){
			return null;
		}
	}
	public static java.sql.Date getSqlDate(Date normalDate){
		return new java.sql.Date(normalDate.getTime());
	}
	public static Date getNormalDate(java.sql.Date sqlDate){
		return new Date(sqlDate.getTime());
	}
	public static boolean isDate(String something){
		boolean result = false;
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(something);
			result = true;
			} catch (Exception ex) {
				
			}
		return result;
	}
	public static String getDateNow(){
		Date today=new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = timeFormat.format(today.getTime());
		return dateStr;
	}
	public static boolean isEnddate(String dateSql,String dateNow){
		boolean result;
		if(dateSql.equals(dateNow)){
			result = true;
		}else {
			result = false;
		}
		return result;
	}
}
