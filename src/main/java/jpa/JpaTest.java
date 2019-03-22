package jpa;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			User user = new User("person@gmail.com", "person", "id");
			manager.persist(user);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
