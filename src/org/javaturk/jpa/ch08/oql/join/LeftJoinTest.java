package org.javaturk.jpa.ch08.oql.join;

import java.util.List;

import javax.persistence.EntityManager;

import org.eclipse.persistence.descriptors.SerializedObjectPolicy;
import org.javaturk.jpa.ch05.one2many.list.bidirection.*;
import org.javaturk.jpa.util.PersistenceUtil;

public class LeftJoinTest {

	public LeftJoinTest() {
		PersistenceUtil.setPersistenceUnitName("leftJoin");
	}

	public static void main(String[] args) {
		LeftJoinTest test = new LeftJoinTest();
		test.retrievePerson();
	}

	private Person retrievePerson() {
		EntityManager em = PersistenceUtil.getEntityManager();

		Person owner = em.find(Person.class, 1);
		
		List<Car> cars = owner.getCars();
		cars.size();
		System.out.println("Owner: " + owner);
		if (cars == null)
			System.out.println("Null list");
		else {
			System.out.println("Here are the cars");
			for (Car car : cars)
				System.out.println(car);
		}
		em.close();

		return owner;
	}
}
