package com.car;
import java.util.Scanner;
import java.sql.*;

public class BookingHistory {
	
	Scanner sc= new Scanner(System.in);
	private String bookingId;
	private String ownerName;
	private String model;
	private String fuelType;
	private String carNumber;
	private String mileage;
	private int no_of_passenger;
	private int cost_per_hour;
	private int cost_per_day;
	private int no_of_hour;
	private int no_of_days;
	private int total_rent;
	
	public void history() {
		System.out.print("\n\nEnter your email id: "); String id= sc.next();
		System.out.println("\n\n-----------------------Your booking history-----------------------");
		System.out.println("Booking id    Owner's Name     Model    Car Number    Fuel    Mileage    No of Passenger    Cost per hour    Cost per day    No of days  No of Hour  Total Rent");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
			PreparedStatement pstmt= connection.prepareStatement("SELECT * from bookings where bookingId=?");
			pstmt.setString(1, id);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString(1)+"    ");
				System.out.print(rs.getString(2)+"           ");
				System.out.print(rs.getString(3)+"       ");
				System.out.print(rs.getString(4)+"      ");
				System.out.print(rs.getString(5)+"       ");
				System.out.print(rs.getString(6)+"       ");
				System.out.print(rs.getInt(7)+"       ");
				System.out.print(rs.getInt(8)+"      ");
				System.out.print(rs.getInt(9)+"       ");
				System.out.print(rs.getInt(10)+"      ");
				System.out.print(rs.getInt(11)+"        ");
				System.out.print(rs.getInt(12)+"\n");
			}
			connection.close();
			System.out.println("\n**************************************************************************************************************\n");
			UserTask t=new UserTask();
			t.Task();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
