package com.shop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.shop.model.User;

public class UserDao {

	public static EntityManagerFactory emf;
	public static EntityManager em = getEntityManager();

	private static EntityManager getEntityManager() {
		if (null == emf) {
			emf = Persistence.createEntityManagerFactory("ShoppingApp");
		}
		return emf.createEntityManager();
	}

	public User validate(String username, String password) {

		em.getTransaction().begin();
		TypedQuery<User> userQuery = em
				.createQuery("select u from User u where u.name = :username and u.password = :password", User.class);
		userQuery.setParameter("username", username);
		userQuery.setParameter("password", password);
		User u = userQuery.getSingleResult();
		em.getTransaction().commit();
		if (null != u) {
			return u;
		} else {
			return null;
		}

	}

	public long getUsercartId(String username) {

		em.getTransaction().begin();
		long cartid = (long) em.createQuery("Select u.cart.id FROM User u WHERE u.name = :username")
				.setParameter("username", username).getSingleResult();
		em.getTransaction().commit();
		return cartid;

	}
}
