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
		Product pro= new Product(productID1,productName1,productQuantity1,productPrice1);
		addProducts.add(pro);		
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
				addProducts.remove(p);
			}
			break;
		}	
	}

	@Override
	public Product updateProduct(int pid, String name, int qty, int price) {
		// TODO Auto-generated method stub
		for(Product p:addProducts) {
			if(pid==p.getPid()) {
				p.setPname(name);
				p.setPrice(price);
				p.setQty(qty);
				return p;
			}
		}	
		return null;
	}

	@Override
	public void buyProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product updateProduct(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
