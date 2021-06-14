package com.shop.main;

import com.shop.dao.CartDao;

public class Main {

	public static void main(String[] args) {
	long id = 21;
		double total = CartDao.getCartTotal(id);
	System.out.print("totale:"+total);
	
	}

}
