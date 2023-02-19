package com.pms.client;

import java.util.Scanner;

import com.pms.details.ProductDetails;

public class ProductClient {

	public static void productApp() {
		while(true) {
			System.out.println();
			System.out.println("----------------------------------------------------------");
			System.out.println("-                   Press 1 for Product                  -");
			System.out.println("-                   Press 2 to Exit                      -");
			System.out.println("----------------------------------------------------------");
		System.out.println("Enter The Choice");
		Scanner sc1 = new Scanner(System.in);
		int choice=sc1.nextInt();
		switch(choice){
			case 1:
				System.out.println("Welcome To Product Management App!!");
				ProductDetails.productMenuDetails();
				break;
			case 2:
				System.out.println("Thx for Using App!");
				System.exit(0);
				break;
		default:
			System.out.println("******** Choose between 1 to 2 *******");
			break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productApp();
	}

}
