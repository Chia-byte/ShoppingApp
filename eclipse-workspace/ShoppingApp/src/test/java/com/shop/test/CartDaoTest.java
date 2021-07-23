 package com.shop.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.shop.dao.CartDao;
import com.shop.model.Cart;
import com.shop.model.Product;

public class CartDaoTest {
	CartDao tester = new CartDao();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingApp");
	EntityManager em = emf.createEntityManager();

	@BeforeEach
	public void setup() {
		tester = new CartDao();
	
	}

	@Test
	@DisplayName("Get total from cart should work")
	public void testGetCartTotal() {
		assertEquals(3600, tester.getCartTotal(23), "Cart amount calculator should work");
	}

	@Test
	@DisplayName("Adding product to cart should work")
	public void testAddToCart() {
		Product p1 = new Product(997, null, "Karl Lagerfeld Ring", 950 , 4);
		List <Product> li =new ArrayList();
		li.add(p1);
		tester.addToCart(li, 23);
		TypedQuery <Product> ctrlIfExists = em.createQuery("SELECT p from product p where p.id =:id" , Product.class);
		ctrlIfExists.setParameter("id", 997);
		assertNotNull(ctrlIfExists.getSingleResult());
	
	}
}