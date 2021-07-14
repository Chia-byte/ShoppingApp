package com.shop.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.shop.model.Product;

public class ProductDao {
	
	public static EntityManagerFactory emf;
	public static EntityManager em = getEntityManager(); 

	private static EntityManager getEntityManager() {
		if (null == emf) {
			emf = Persistence.createEntityManagerFactory("ShoppingApp");
		}
		return emf.createEntityManager();
	}

	public static List<Product> getAllProducts() {

		em.getTransaction().begin();
		List<Product> listap = (List<Product>) em.createQuery("SELECT p FROM Product p").getResultList();
		em.getTransaction().commit();
		return listap;
	}

	public static List<Product> getThisTypeofProducts(int i) {

		em.getTransaction().begin();
		TypedQuery<Product> queryProdotti = em.createQuery("select p from Product p WHERE p.type.idType = :tipo", Product.class);
		queryProdotti.setParameter("tipo", i);
		List<Product> listaProdotti = queryProdotti.getResultList();

		em.getTransaction().commit();
		return listaProdotti;
	}
}