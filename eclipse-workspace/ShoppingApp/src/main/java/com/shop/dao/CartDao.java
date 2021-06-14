package com.shop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.shop.model.Cart;
import com.shop.model.Product;

public class CartDao {

	public static EntityManagerFactory emf;
	public static EntityManager em = getEntityManager();

	public static List<Product> getWhatInsideCart(long l) {

		em.getTransaction().begin();
		TypedQuery<Cart> queryCarrello = em.createQuery("select c from Cart c WHERE c.id = :id", Cart.class);
		queryCarrello.setParameter("id", l);
		Cart c = queryCarrello.getSingleResult();
		List<Product> list = c.getProducts();
		em.getTransaction().commit();
		return list;
	}

	private static EntityManager getEntityManager() {
		if (null == emf) {
			emf = Persistence.createEntityManagerFactory("ShoppingApp");
		}
		return emf.createEntityManager();
	}

	public static List getlistaProdotti(String[] array) {

		em.getTransaction().begin();
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < array.length; i++) {
			String name = array[i];
			TypedQuery<Product> queryProdottiCarrello = em.createQuery("select p from Product p WHERE p.name = :name",
					Product.class);
			queryProdottiCarrello.setParameter("name", name);
			list.add(queryProdottiCarrello.getSingleResult());
		}
		em.getTransaction().commit();
		return list;

	}

	public static double getCartTotal(long cartid) {
		em.getTransaction().begin();
		double totale;
		totale = (double) em.createQuery("SELECT SUM(price) FROM Product p where p.cart.id = :cartid")
				.setParameter("cartid", cartid).getSingleResult();
		em.getTransaction().commit();
		return totale;
	}

	public static void addToCart(List<Product> lis, long cartid) {

		em.getTransaction().begin();

		TypedQuery<Cart> querySelezionaCarrello = em.createQuery("Select c from Cart c WHERE c.id = :id", Cart.class);
		querySelezionaCarrello.setParameter("id", cartid);
		Cart c = querySelezionaCarrello.getSingleResult();
		lis.forEach(p -> p.setCart(c));
		c.getProducts().addAll(lis);
		em.merge(c);
		em.getTransaction().commit();
	}

}