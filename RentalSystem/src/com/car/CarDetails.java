package com.car;
import java.util.Scanner;
import java.sql.*;

public class CarDetails {
	
	Scanner sc=new Scanner(System.in);
	
	public void AddCarDetails() {
		System.out.println("\n**************************************************************************************************************\n");
		System.out.println("\n-----------------------Kindly add the car details!-----------------------");
		System.out.print("\nOwner's name: ");String name=sc.nextLine();
		System.out.print("\nEnter the car model: ");String model=sc.nextLine();
		System.out.print("\nEnter the car number: ");String number=sc.nextLine();
		System.out.print("\nWhat is the fuel type (CNG/Petrol/Diesel)? ");String fuel=sc.nextLine();
		System.out.print("\nwhat is the mileage? ");String mileage=sc.nextLine();
		System.out.print("\nNo of passengers allowed: ");int no_of_passenger=sc.nextInt();
		System.out.print("\nWhat is the cost per hour? ");int cphr=sc.nextInt();
		System.out.print("\nWhat is the cost per day? ");int cpday=sc.nextInt();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
			String sql="INSERT into cardetails values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt= connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, model);
			pstmt.setString(3, number);
			pstmt.setString(4, fuel);
			pstmt.setString(5, mileage);
			pstmt.setInt(6, no_of_passenger);
			pstmt.setInt(7, cphr);
			pstmt.setInt(8, cpday);
			pstmt.executeUpdate();
			System.out.println("\nCar details added successfully!");
			System.out.println("\n**************************************************************************************************************");
			connection.close();
			AdminTask t1=new AdminTask();
			t1.Task();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
