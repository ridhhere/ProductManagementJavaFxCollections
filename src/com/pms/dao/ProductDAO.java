package com.pms.dao;

import java.util.List;

import com.pms.pojo.Product;

public interface ProductDAO {
	void addProduct(int id,String name,int qty,int price);
	List<Product> viewAllProduct();
	Product viewProduct(int pid);
	void deleteProduct(int pid);
	Product updateProduct(int pid);
	void buyProduct();
	void addProduct();
	Product updateProduct(int pid, String name, int qty, int price);
	}
