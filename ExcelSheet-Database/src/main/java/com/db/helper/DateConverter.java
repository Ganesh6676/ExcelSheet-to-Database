package com.db.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	// Define input and output date formats
	SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Date getDate(String dateString) {
		String sqlServerDate = null;
		Date dbdate=null;
		try {
			// Parse the input string into a Date object
			Date date =  inputFormat.parse(dateString);
			// Format the Date object into the desired SQL Server date format
			sqlServerDate = outputFormat.format(date);
			dbdate =  outputFormat.parse(sqlServerDate);
			//System.out.println("SQL Server Date: " + sqlServerDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dbdate;
	}
}
