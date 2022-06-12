package com.car;
import java.util.Scanner;
import java.sql.*;

public class OtherDetailsForAdmin {
	Scanner sc=new Scanner(System.in);
	
	public void customerList() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "pass");
			PreparedStatement pstmt=connection.prepareStatement("select name from registeration");
			ResultSet rs= pstmt.executeQuery();
			System.out.println("\n-----------------------List of all registered customers-----------------------");
			while(rs.next()) {
				System.out.println(rs.getString(1));
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
