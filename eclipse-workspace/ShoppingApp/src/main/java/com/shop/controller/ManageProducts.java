package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.CartDao;
import com.shop.dao.ProductDao;
import com.shop.model.Product;

@WebServlet("/ManageServlet")
public class ManageProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageProducts() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Product> lista = ProductDao.getAllProducts();
		request.setAttribute("listaa", lista);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
