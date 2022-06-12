package com.car;
import java.util.Scanner;

public class AdminTask {
	Scanner sc=new Scanner(System.in);
	public void Task() {
		System.out.println("\n**************************************************************************************************************");
		System.out.println("\nWhat you want to do? ");
		System.out.println("1) Add the car details \n2) List of registered customers \n3) List of customer booking \n4) Exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
		{
			CarDetails detail=new CarDetails();
			detail.AddCarDetails();
			break;
		}
		case 2: 
		{
			OtherDetailsForAdmin detail2=new OtherDetailsForAdmin();
			detail2.customerList();break;
		}
		case 3:
		{
			CustomerBooking booking= new CustomerBooking();
			booking.BookingDetails();break;
		}

		case 4: System.out.println("Logged out succesfully!!");System.out.println("\n**************************************************************************************************************\n");break;
		default: {
				System.out.println("Wrong choice!\n Try again......");
				Task();
			}
		
		}
	}

}
