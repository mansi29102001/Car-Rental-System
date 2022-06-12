package com.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CustomerBooking {

	Scanner sc= new Scanner(System.in);
	
	public void BookingDetails() {
		System.out.println("\n**************************************************************************************************************\n");
		System.out.println("\n\n----------------------- Details of bookings of customer-----------------------");
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
			PreparedStatement pstmt= connection.prepareStatement("SELECT * from bookings");
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString(1)+"    ");
				System.out.print(rs.getString(2)+"    ");
				System.out.print(rs.getString(3)+"    ");
				System.out.print(rs.getString(4)+"    ");
				System.out.print(rs.getString(5)+"    ");
				System.out.print(rs.getString(6)+"    ");
				System.out.print(rs.getInt(7)+"    ");
				System.out.print(rs.getInt(8)+"    ");
				System.out.print(rs.getInt(9)+"    ");
				System.out.print(rs.getInt(10)+"    ");
				System.out.print(rs.getInt(11)+"    ");
				System.out.print(rs.getInt(12)+"\n");
			}
			connection.close();
			System.out.println("\n**************************************************************************************************************\n");
			AdminTask t1=new AdminTask();
			t1.Task();
		}
		catch(Exception e) {
			System.out.println(e);
		}
}
}