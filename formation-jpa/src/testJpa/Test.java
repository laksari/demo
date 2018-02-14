package testJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
        tx.commit(); // em.flush()
		
		em.close();
		
		
		
		emf.close();

	}

}
