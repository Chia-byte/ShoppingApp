package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.CartDao;
import com.shop.dao.ProductDao;
import com.shop.model.Product;

@WebServlet("/ServletDashboard")
public class ServletDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDashboard() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("tipo"));
		if (i > 0) {
			request.setAttribute("lista", ProductDao.getThisTypeofProducts(i));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("lista", ProductDao.getAllProducts());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		String[] namesofproducts = request.getParameterValues("product");
		List <Product> list = CartDao.getlistaProdotti(namesofproducts);
		long idcarrello = (long) request.getSession().getAttribute("cartid");
		CartDao.addToCart(list, idcarrello );
		List <Product> listacarrello = CartDao.getWhatInsideCart(idcarrello);
		request.setAttribute("listadelcarrello", listacarrello);
		request.setAttribute("lista", ProductDao.getAllProducts());
        request.setAttribute("totale", CartDao.getCartTotal(idcarrello));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
		dispatcher.forward(request, response);
	
	}
}
