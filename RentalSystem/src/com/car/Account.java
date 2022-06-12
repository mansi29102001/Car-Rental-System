package com.car;
import java.util.Scanner;
import java.sql.*;

public class Account {
	
	Scanner sc=new Scanner(System.in);
	
	public void adminAccount() {
		String adminEmail="admin@gmail.com", adminPassword="admin@1234";
		System.out.println("\n-----------------------Kindly enter your credentials!-----------------------");
		System.out.print("Enter your Email id: ");
		String email=sc.nextLine();
	    System.out.print("\nEnter the password: ");
	    String password=sc.nextLine();
	    if(email.equals(adminEmail))
	    {
	        if(password.equals(adminPassword)){
	            System.out.println("\n\nLogin Successful!");
	            AdminTask t1=new AdminTask();
				t1.Task();
	        }
	        else{
	        	System.out.println("\n\nOOps, wrong password!");
	        	System.out.println("\nPlease try again....");
	            
	            adminAccount();
	        }
	    }
	    else{
	    	System.out.println("\n\nInvalid email!\n Please try again....");
	        adminAccount();
	    }
	}
	
	public void userAccount() {
		
		System.out.print("\nAre you a new user (y/n)? ");
		char ch= sc.nextLine().charAt(0);
		if(ch=='y' || ch=='Y') {
			System.out.println("\n\nKindly, register yourself");
			newUser();
		}
		else {
			userLogin();
		}
	}
	
	public void newUser() {
		
		System.out.println("\n\n-----------------------Kindly fill the following details!-----------------------");
		System.out.print("\nEnter your name: ");
		String name=sc.nextLine();
		System.out.print("\nEnter your phone number: ");
		long phnNo= sc.nextLong();
		System.out.print("\nEnter your Email id: ");
		String email=sc.next();
		System.out.print("\nEnter the password: ");
		String password= sc.next();
		System.out.print("\nEnter the password again: ");
		String cpassword= sc.next();
	    if(password.equals(cpassword))
	    {
	    	//System.out.println("\n\nRegistered successfully!");
	    	try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
				String sql="INSERT into registeration values(?,?,?,?)";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setString(1, name);
				statement.setLong(2, phnNo);
				statement.setString(3, email);
				statement.setString(4, password);
				statement.executeUpdate();
				System.out.println("\n\nRegistered successfully!");
				System.out.println("\n**************************************************************************************************************\n");
				System.out.println("\n**************************************************************************************************************\n");
				connection.close();
				userLogin();
			}
			catch(Exception e) {
				System.out.println(e);
			}
	    }
	    else
	    {
	    	System.out.println("Password mismatch!");
	    	System.out.println("Please try again.......");
	    	newUser();
	    }
	}
	
	// user login
	public void userLogin() {
		System.out.println("\n-----------------------Kindly enter your credentials!-----------------------");
		System.out.print("Enter your Email id: ");
		String email=sc.next();
	    System.out.print("\nEnter the password: ");
	    String password=sc.next();
	    try {
	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
	    	PreparedStatement pstmt= connection.prepareStatement("SELECT * from registeration where email=? and password=?");
	    	pstmt.setString(1, email);
	    	pstmt.setString(2, password);
	    	ResultSet rs=pstmt.executeQuery();
	    	if(rs.next()) {
	    		System.out.println("\nLogin successful!");
	    		UserTask user=new UserTask();
	    		user.Task();
	    	}
	    	else {
	    		System.out.println("Invalid email or password!\nTry again......");
	    		userLogin();
	    	}
	    	connection.close();
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	}

}
