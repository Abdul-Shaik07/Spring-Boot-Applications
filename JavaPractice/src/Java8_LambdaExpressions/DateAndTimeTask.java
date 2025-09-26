package Java8_LambdaExpressions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateAndTimeTask {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateInput = sc.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateInput, formatter);

        // Get second date from the user
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateInput = sc.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateInput, formatter);

        // Calculate the difference in days
        long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);

        // Display the result
        System.out.println("Number of days between " + firstDate + " and " + secondDate + " is: " + Math.abs(daysBetween));

        sc.close();


	}

}
