package com.java.assignments;
	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserAuthentication {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc"; // Modify for your DB
	    private static final String USER = "root";  // DB Username
	    private static final String PASSWORD = "abbu123"; // DB Password

	    public static void main(String[] args) {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	             Scanner scanner = new Scanner(System.in)) {

	            createTable(conn);  // Ensure table exists
	            insertUser(conn, "admin", "admin123"); // Insert sample user

	            System.out.print("Enter User ID: ");
	            String userId = scanner.nextLine();

	            System.out.print("Enter Password: ");
	            String password = scanner.nextLine();

	            if (authenticateUser(conn, userId, password)) {
	                System.out.println("Access Granted!");
	            } else {
	                System.out.println("Access Denied!");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void createTable(Connection conn) throws SQLException {
	        String sql = "create table user(userId varchar(150) primary key, passwordHash varchar(64))"; 
	        try (Statement stmt = conn.createStatement()) {
	            stmt.executeUpdate(sql);
	        }
	    }

	    private static void insertUser(Connection conn, String userId, String password) throws SQLException {
	        String hashedPassword = hashPassword(password);

	        String checkSql = "select * from user where userId=?";
	        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
	            checkStmt.setString(1, userId);
	            ResultSet rs = checkStmt.executeQuery();
	            if (rs.next()) {
	                return; // User already exists
	            }
	        }

	        String sql = "insert into user (userId, passwordHash) values (?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, userId);
	            pstmt.setString(2, hashedPassword);
	            pstmt.executeUpdate();
	        }
	    }
	    PreparedStatement pstmt = conn.prepareStatement(sql)

	    private static boolean authenticateUser(Connection conn, String userId, String password) throws SQLException {
	        String sql = "SELECT PasswordHash FROM User WHERE UserID=?";
	        try (PreparedStatement p = conn.prepareStatement(sql)) {
	            pstmt.setString(1, userId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                String storedHash = rs.getString("PasswordHash");
	                return storedHash.equals(hashPassword(password));
	            }
	        }
	        return false;
	    }

	    private static String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashBytes) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error hashing password", e);
	        }
	    }
	}
	

