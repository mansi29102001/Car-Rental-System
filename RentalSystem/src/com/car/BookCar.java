package com.car;
import java.util.Scanner;


import java.sql.*;


public class BookCar {
	Scanner sc=new Scanner(System.in);
	private String ownerName;
	private String model;
	private String carNumber;
	private String fuelType;
	private String mileage;
	private int no_of_passenger;
	private int cost_per_hour;
	private int cost_per_day;
	
	public void BookCarRide() {
		System.out.println("\n**************************************************************************************************************");
		System.out.println("\nLet's book a car for you!!");
		System.out.print("\nNo of passenger: "); int passenger=sc.nextInt();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
			PreparedStatement pstmt1;
			System.out.println("\nList of all car models available for "+passenger+" passengers.....");
			pstmt1= connection.prepareStatement("SELECT model from cardetails where no_of_passenger>=?");
			pstmt1.setInt(1, passenger);
			ResultSet rs= pstmt1.executeQuery();
			
			
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\nWhich car model do you want? Enter your choice: ");
				String choice= sc.next();
				System.out.println("\n");
				System.out.println("List of car numbers available.....");
				PreparedStatement pstmt2=connection.prepareStatement("select carNumber from cardetails where model=? and no_of_passenger=?");
				pstmt2.setString(1, choice);
				pstmt2.setInt(2, passenger);
				ResultSet rs1=pstmt2.executeQuery();
				while(rs1.next()) {
					System.out.println(rs1.getString(1));
				}
				System.out.print("\nEnter the car number that you want to book: ");String car=sc.next();
				System.out.print("\nYou want to book: \n1) Based on days \n2) Based on hour \n");int typeOfBooking=sc.nextInt();
				if(typeOfBooking==1) {
					System.out.print("\nEnter the number of days you want to book a car: ");int days=sc.nextInt();
					System.out.print("\nEnter your email id: "); String id=sc.next();
					System.out.print("\nAre you sure you want to book the car (y/n)? ");char confirm=sc.next().charAt(0);
					if(confirm=='y' || confirm=='Y') {
						String sql="SELECT ownerName, model, carNumber, fuelType, mileage, no_of_passenger, cost_per_day, cost_per_hour from cardetails where carNumber=?";
						PreparedStatement pstmt3=connection.prepareStatement(sql);
						pstmt3.setString(1, car);
						ResultSet rs3=pstmt3.executeQuery();
						while(rs3.next()) {
							ownerName=rs3.getString(1);
							model=rs3.getString(2);
							carNumber=rs3.getString(3);
							fuelType=rs3.getString(4);
							mileage=rs3.getString(5);
							no_of_passenger=rs3.getInt(6);
							cost_per_day=rs3.getInt(7);
							cost_per_hour=rs3.getInt(8);
						}
						String query="INSERT into bookings values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pstmt4=connection.prepareStatement(query);
						pstmt4.setString(1, id);
						pstmt4.setString(2, ownerName);
						pstmt4.setString(3, model);
						pstmt4.setString(4, carNumber);
						pstmt4.setString(5, fuelType);
						pstmt4.setString(6, mileage);
						pstmt4.setInt(7, no_of_passenger);
						pstmt4.setInt(8, cost_per_hour);
						pstmt4.setInt(9, cost_per_day);
						pstmt4.setInt(10, 0);
						pstmt4.setInt(11, days);
						pstmt4.setInt(12, days*cost_per_day);
						pstmt4.executeUpdate();
						connection.close();
						System.out.println("Car booked successfully!");
						System.out.println("\nYour total rent: "+days*cost_per_day);
						System.out.println("\n**************************************************************************************************************");
						System.out.println("\n**************************************************************************************************************");
						UserTask t=new UserTask();
						t.Task();
					}
				}
				else {
					System.out.print("\nEnter the number of hours you want to book a car: ");int hr=sc.nextInt();
					System.out.print("\nEnter your email id: "); String id=sc.next();
					System.out.print("\nAre you sure you want to book the car (y/n)? ");char confirm=sc.next().charAt(0);
					if(confirm=='y' || confirm=='Y') {
						String sql="SELECT ownerName, model, carNumber, fuelType, mileage, no_of_passenger, cost_per_day, cost_per_hour from cardetails where carNumber=?";
						PreparedStatement pstmt3=connection.prepareStatement(sql);
						pstmt3.setString(1, car);
						ResultSet rs3=pstmt3.executeQuery();
						while(rs3.next()) {
							ownerName=rs3.getString(1);
							model=rs3.getString(2);
							carNumber=rs3.getString(3);
							fuelType=rs3.getString(4);
							mileage=rs3.getString(5);
							no_of_passenger=rs3.getInt(6);
							cost_per_day=rs3.getInt(7);
							cost_per_hour=rs3.getInt(8);
						}
						String query="INSERT into bookings values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pstmt4=connection.prepareStatement(query);
						pstmt4.setString(1, id);
						pstmt4.setString(2, ownerName);
						pstmt4.setString(3, model);
						pstmt4.setString(4, carNumber);
						pstmt4.setString(5, fuelType);
						pstmt4.setString(6, mileage);
						pstmt4.setInt(7, no_of_passenger);
						pstmt4.setInt(8, cost_per_hour);
						pstmt4.setInt(9, cost_per_day);
						pstmt4.setInt(10, hr);
						pstmt4.setInt(11, 0);
						pstmt4.setInt(12, hr*cost_per_hour);
						pstmt4.executeUpdate();
						connection.close();
						System.out.println("Car booked successfully!");
						System.out.println("\nYour total rent: "+hr*cost_per_hour);
						System.out.println("\n**************************************************************************************************************");
						System.out.println("\n**************************************************************************************************************");
						UserTask t=new UserTask();
						t.Task();
					}
				}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
