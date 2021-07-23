package com.shop.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import com.shop.dao.UserDao;
import com.shop.model.Product;
import com.shop.model.User;

public class UserDaoTest {
	UserDao tester = new UserDao();
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingApp");
     EntityManager em = emf.createEntityManager();
   	
	@BeforeEach
	public void setup() {
		tester = new UserDao();
		
		
	}

	@Test
	@DisplayName("Validation should work")
	public void testValidate() {
		em.getTransaction().begin();
		TypedQuery<User> userQuery = em.createQuery("select u from User u where u.name =:username", User.class);
		userQuery.setParameter("username", "test");
		User u = userQuery.getSingleResult();
		em.getTransaction().commit();
		User actualU =tester.validate("test", "pww");
		assertEquals(u.getCart(),actualU.getCart());
		assertEquals(u.getId(),actualU.getId());
		assertEquals(u.getPassword(),actualU.getPassword());
		assertEquals(u.getEmail(),actualU.getEmail());

	}

	@Test
	@DisplayName("Get cartId from user should work")
	public void testGetUsercartId() {
		assertEquals(23, tester.getUsercartId("test"), "Retrieving cartId from User works");

	}
}
