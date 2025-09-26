package com.java.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TravelBookingPackage {
	
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/travel_db"; // Change as needed
	    private static final String DB_USER = "root";  // Change as needed
	    private static final String DB_PASSWORD = "abbu123";  // Change as needed


	
	public static void main(String[] args) {
	
		        try (Scanner scanner = new Scanner(System.in);
		             Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		        	

		            while (true) {
		                System.out.println("\nChoose an option:");
		                System.out.println("1. Insert New Package");
		                System.out.println("2. Update Package Price");
		                System.out.println("3. Delete Package(s)");
		                System.out.println("4. Display All Packages");
		                System.out.println("5. Exit");

		                int choice = scanner.nextInt();
		                scanner.nextLine(); // Consume newline

		                switch (choice) {
		                    case 1:
		                        insertPackage(connection, scanner);
		                        break;
		                    case 2:
		                        updatePackagePrice(connection, scanner);
		                        break;
		                    case 3:
		                        deletePackages(connection, scanner);
		                        break;
		                    case 4:
		                        displayAllPackages(connection);
		                        break;
		                    case 5:
		                        System.out.println("Exiting...");
		                        return;
		                    default:
		                        System.out.println("Invalid option. Try again.");
		                }
		            }
		        } catch (SQLException e) {
		            System.out.println("Database error: " + e.getMessage());
		        }
		    }
	
	private static void insertPackage(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter Package ID: ");
            int packageId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter Duration (days): ");
            int duration = scanner.nextInt();
            System.out.print("Enter Available Seats: ");
            int availableSeats = scanner.nextInt();

            String query = "INSERT INTO package (package_id, destination, price, duration, available_seats) VALUES (?, ?, ?, ?, ?)";
            try (java.sql.PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, packageId);
                pstmt.setString(2, destination);
                pstmt.setDouble(3, price);
                pstmt.setInt(4, duration);
                pstmt.setInt(5, availableSeats);
                pstmt.executeUpdate();
                System.out.println("Inserted Successfully");
                displayAllPackages(connection);
            }
        } catch (SQLException e) {
            System.out.println("Error inserting package: " + e.getMessage());
        }
    }

    private static void updatePackagePrice(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter lower price limit: ");
            double lowerLimit = scanner.nextDouble();
            System.out.print("Enter upper price limit: ");
            double upperLimit = scanner.nextDouble();

            String query = "UPDATE package SET price = price * 1.10 WHERE price BETWEEN ? AND ?";
            try (java.sql.PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setDouble(1, lowerLimit);
                pstmt.setDouble(2, upperLimit);
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Updated Successfully");
                    displayAllPackages(connection);
                } else {
                    System.out.println("No packages found in the specified range.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating package: " + e.getMessage());
        }
    }

    private static void deletePackages(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter max available seats threshold: ");
            int seatThreshold = scanner.nextInt();
            System.out.print("Enter max duration threshold: ");
            int durationThreshold = scanner.nextInt();

            String query = "DELETE FROM package WHERE available_seats < ? OR duration < ?";
            try (java.sql.PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, seatThreshold);
                pstmt.setInt(2, durationThreshold);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Deleted Successfully");
                    displayAllPackages(connection);
                } else {
                    System.out.println("No packages matched the criteria.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting package: " + e.getMessage());
        }
    }

    private static void displayAllPackages(Connection connection) {
        String query = "SELECT * FROM package ORDER BY price DESC, available_seats ASC";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.printf("PackageId: %d, Destination: %s, Price: %.2f, Duration: %d days, Available Seats: %d\n",
                        rs.getInt("package_id"),
                        rs.getString("destination"),
                        rs.getDouble("price"),
                        rs.getInt("duration"),
                        rs.getInt("available_seats"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving packages: " + e.getMessage());
        }
    }
}

