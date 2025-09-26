package Java8_LambdaExpressions;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Scanner;

public class TimeZoneTask {

	 public static String convertTimezone(String time, String fromTz, String toTz) throws ZoneRulesException {
	        try {
	            // Define formatter
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	            
	            // Parse input time
	            LocalTime inputTime = LocalTime.parse(time, formatter);
	            
	            // Get the current date
	            LocalDate currentDate = LocalDate.now();
	            
	            // Create ZonedDateTime in source timezone
	            ZonedDateTime fromZonedDateTime = ZonedDateTime.of(currentDate, inputTime, ZoneId.of(fromTz));
	            
	            // Convert to target timezone
	            ZonedDateTime toZonedDateTime = fromZonedDateTime.withZoneSameInstant(ZoneId.of(toTz));
	            
	            // Format and return the converted time
	            return toZonedDateTime.format(formatter);
	        } catch (DateTimeException e) {
	            return "Error: " + e.getMessage();
	        }
	 }
	        
	        public static void main(String[] args) {
	            String time = "14:30"; // 2:30 PM
	            String fromTimezone = "America/New_York";
	            String toTimezone = "Asia/Kolkata";
	            
	            String convertedTime = convertTimezone(time, fromTimezone, toTimezone);
	           System.out.println("Previous Time: " +time);
	            System.out.println("Converted Time: " + convertedTime);
	        }
	    }
		