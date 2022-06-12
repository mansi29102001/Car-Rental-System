package com.car;
import java.util.Scanner;

public class UserTask {
	Scanner sc=new Scanner(System.in);
	
	public void Task() {
		System.out.println("\n**************************************************************************************************************\n");
		System.out.println("\nWhat you want to do? ");
		System.out.println("1) Book a car \n2) Details of previous booking \n3) Exit");
		int choice=sc.nextInt();
		switch(choice) {
			case 1: 
			{
				BookCar car=new BookCar();
				car.BookCarRide();break;
			}
			case 2:
			{
				BookingHistory h=new BookingHistory();
				h.history();break;
			}
			case 3: 
			{
				System.out.println("Logged out successfully!");
				System.out.println("\n**************************************************************************************************************\n");
				break;
			}
			default: 
			{
				System.out.println("Wrong choice!\nPlease try again....");
				Task();
			}
		}
	}
}
