package com.shop.test;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shop.dao.CartDao;
import com.shop.dao.ProductDao;
import com.shop.model.Product;
import com.shop.model.User;

public class ProductDaoTest {

	ProductDao tester = new ProductDao();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoppingApp");
	EntityManager em = emf.createEntityManager();

	@BeforeEach
	public void setup() {
		tester = new ProductDao();
	
	}
	@Test
	@DisplayName("Getting a certain type of product should work")
	public void testGetThisTypeOfProducts() {
	List <Product> li = tester.getThisTypeofProducts(3);
	List <Product> expectedLi = new ArrayList();
	em.getTransaction().begin();
	TypedQuery<Product> proQuery = em.createQuery("select p from Product p where p.id =:id", Product.class);
	proQuery.setParameter("id", 991);
	Product p = proQuery.getSingleResult();
	
	expectedLi.add(p);
	
			
			}
	}
