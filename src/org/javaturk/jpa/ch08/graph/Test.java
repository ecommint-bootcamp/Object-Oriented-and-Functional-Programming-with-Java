package org.javaturk.jpa.ch08.graph;

import java.util.*;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {
	public Test() {

		PersistenceUtil.setPersistenceUnitName("graph");
	}

	public static void main(String[] args) {

		Test test = new Test();
//		test.createOrders();

		test.retrieveOrder();

	}

	private void createOrders() {

		Product p1 = new Product("iPhone");
		Product p2 = new Product("Headphone");
		Product p3 = new Product("Charger");
		Product p4 = new Product("Smart Watch");
		Product p5 = new Product("Lightining Cable");

		OrderItem oi1 = new OrderItem(p1, 10);
		OrderItem oi2 = new OrderItem(p2, 1);
		OrderItem oi3 = new OrderItem(p3, 5);
		OrderItem oi4 = new OrderItem(p4, 100);
		OrderItem oi5 = new OrderItem(p5, 7);

		Order order1 = new Order("111");
		order1.addItem(oi1);
		order1.addItem(oi2);
		order1.addItem(oi3);

		Order order2 = new Order("222");
		order2.addItem(oi4);
		order2.addItem(oi5);

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(order1);
		em.persist(order2);

		tx.commit();
		em.close();
	}

	private void retrieveOrder() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		EntityGraph graph = em.getEntityGraph("graph.Order.items");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", graph);

		Order order = em.find(Order.class, 8L, hints);
		System.out.println(order);
	}
}
