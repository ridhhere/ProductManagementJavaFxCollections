package com.pms.details;

import java.util.Scanner;

import com.pms.client.ProductClient;
import com.pms.daoImpl.ProductDaoImpl;

public class ProductDetails {
	static ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	public static void productMenuDetails() {
		while (true) {
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.println("-                   Press 1 to Add Product                    -");
			System.out.println("-                   Press 2 to View All Products              -");
			System.out.println("-                   Press 3 to View Product                   -");
			System.out.println("-                   Press 4 to Update Product                 -");
			System.out.println("-                   Press 5 to Delete Product                 -");
			System.out.println("-                   Press 6 to Buy Product                    -");
			System.out.println("-                   Press 7 to Return to Main Menu            -");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Enter The Choice");
			Scanner sc1 = new Scanner(System.in);
			int choice = sc1.nextInt();
			int productId=0;
			switch (choice) {
			case 1:
//				productDaoImpl.addProduct();
				break;
			case 2:
				productDaoImpl.viewAllProduct();
				break;
			case 3:
				System.out.println("Enter Product ID To View");
				productId=sc1.nextInt();
				productDaoImpl.viewProduct(productId);
				break;
			case 4:
				System.out.println("Enter Product ID To Update");
				productId=sc1.nextInt();
				productDaoImpl.viewProduct(productId);
				break;
			case 5:
				System.out.println("Enter Product ID To Delete");
				productId=sc1.nextInt();
				productDaoImpl.deleteProduct(productId);
				break;
			case 7:
				System.out.println("Going Back to Main Menu!!");
				ProductClient.productApp();
			default:
				System.out.println("******** Choose between 1 to 7 *******");
			}
		}
	}
}
