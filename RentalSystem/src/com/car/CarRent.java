package com.car;
import java.util.Scanner;



public class CarRent {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	    System.out.println("****************************************************************************"); 
	    System.out.println("                              CAR RENTAL HOUSE                              ");
	    System.out.println("****************************************************************************");
	    System.out.println("\nThis is a rental house where you can rent car for any number of days!\n\n\nWho are you?");
	    System.out.println("1) Admin \n2) User ");
	    int choice=sc.nextInt();
	    switch(choice)
	    {
	    case 1:
	        {
	            Account acc1=new Account();
	            acc1.adminAccount();
	            break;
	        }

	    case 2:
	    {
	        Account acc1=new Account();
	        acc1.userAccount();
	        break;
	    }
	    default:
	    	System.out.println("\n\n Sorry, Wrong choice!");
	    }

	}

}
