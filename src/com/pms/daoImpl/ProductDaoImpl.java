package com.pms.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.pms.dao.ProductDAO;
import com.pms.pojo.Product;

import javafx.application.Application;

public class ProductDaoImpl implements ProductDAO{
	
	Scanner sc = new Scanner(System.in);
	List<Product> addProducts=new ArrayList<Product>();


	@Override
	public void addProduct(int productID1, String productName1, int productQuantity1, int productPrice1) {
		// TODO Auto-generated method stub
//		System.out.println("How Many Products Do You Want to Add");
//		int size=sc.nextInt();
//		ProductInfo=new Product[size];//initializing array with size
//		for(int i=1;i<=size;i++) {
		Product pro= new Product(productID1,productName1,productQuantity1,productPrice1);
		addProducts.add(pro);
//		}//end of loop
		
	}

	@Override
	public List<Product> viewAllProduct() {
		// TODO Auto-generated method stub	
		return addProducts;
	}

	@Override
	public Product viewProduct(int pid) {
		// TODO Auto-generated method stub
		for(Product p:addProducts) {
			if(pid==p.getPid()) {
				System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPrice()+"\t"+p.getQty());
				return p;
			}
		}
		return null;
	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		for(Product p:addProducts) {
			if(pid==p.getPid()) {
				System.out.println("Deleted Record !!!! "+p.getPid()+"\t"+p.getPname()+"\t"+p.getPrice()+"\t"+p.getQty());
				addProducts.remove(p);
			}
		}	
	}

	@Override
	public void updateProduct(int pid) {
		// TODO Auto-generated method stub
		for(Product p:addProducts) {
			if(pid==p.getPid()) {
				System.out.println("Enter Product Name");
				String name=sc.next();
				System.out.println("Enter Product Quantity");
				int qty=sc.nextInt();
				System.out.println("Enter Product Price");
				int price=sc.nextInt();
				p.setPname(name);
				p.setPrice(price);
				p.setQty(qty);
				System.out.println("Updated Records !!!! "+p.getPid()+"\t"+p.getPname()+"\t"+p.getPrice()+"\t"+p.getQty());
			}
		}	
	}

	@Override
	public void buyProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		
	}

}
