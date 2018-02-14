package test;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.*;


//import formation.jpa.exo.Personne;
//import formation.jpa.exo.Singleton;
import model.*;

public class test {

	public static void main(String[] args) {
		Test8();
		//test3();
	}
	
	static void Test8(){
		
		Employe emp1 = new Employe();
		emp1.setId(1);
		emp1.setNom("toto1");
		emp1.setPrenom("titi1");
		
		Employe emp2 = new Employe();
		emp2.setId(2);
		emp2.setNom("toto2");
		emp2.setPrenom("toto2");
		
		Projet pj1 = new Projet();
		pj1.setId(1);
		pj1.setNom("Projet1");
		
		Projet pj2 = new Projet();
		pj2.setId(2);
		pj2.setNom("Projet2");
		
		Collection<Employe> lstEmp= new ArrayList<Employe>();
		lstEmp.add(emp1);
		lstEmp.add(emp2);
		
		pj1.setListeEmp(lstEmp);
		pj2.setListeEmp(lstEmp);
		
		Collection<Projet> lstProjet = new ArrayList<Projet>();
		lstProjet.add(pj1);
		lstProjet.add(pj2);
		
		emp1.setListePj(lstProjet);
		emp2.setListePj(lstProjet);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(emp1);
		em.persist(emp2);
		em.persist(pj1);
		em.persist(pj2);
	
		
		tx.commit();
		em.close();
		emf.close();
		
		
	}
	
	static void Test6(){
		
		Departement dp = new Departement();
		dp.setId(94);
		dp.setNom("Val de marne");
		
		Personne p1 =new Personne();
		p1.setId(10);
		p1.setNom("toto1");
		p1.setPrenom("titi1");
		p1.setDepartement(dp);
		
		Personne p2 =new Personne();
		p2.setId(20);
		p2.setNom("toto2");
		p2.setPrenom("titi2");
		p2.setDepartement(dp);
		
		ArrayList<Personne> lstp = new ArrayList<Personne>();
		lstp.add(p1);
		lstp.add(p2);
		dp.setListePersonne(lstp);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		em.persist(p1);
		em.persist(p2);
		em.persist(dp);
		
		tx.commit();
		em.close();
		emf.close();
	}
	static void Test7(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em = emf.createEntityManager();
		
		
		Departement dep = em.find(Departement.class, 94);
		
		
		em.close();
		emf.close();
		
		System.out.println(dep.toString());
		
		
	}
	
	static void test1(){
		Personne p1=new Personne();
		p1.setId(1);
		p1.setPrenom("toto");
		p1.setNom("titi");
		p1.setAge(10);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(p1);
		tx.commit();
		em.close();
		emf.close();
	}
	
	static void Test2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em = emf.createEntityManager();

		Computer pc = em.find(Computer.class, 1);
		em.close();
		emf.close();
		
		if (pc != null)
			System.out.println(pc.toString());
		else
			System.out.println("Desolé");

	}
	
	static void Test3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Personne p = em.find(Personne.class, 1);
		p.setNom("tonton");
		tx.commit();
		em.close();
		emf.close();
	}
	
	static void Test4() {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em = emf.createEntityManager();

		Personne p = em.find(Personne.class, 1);
		
		//p.setNom("tonton");

		em.close();
		emf.close();*/

		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em2 = emf2.createEntityManager();
		EntityTransaction tx = em2.getTransaction();
		tx.begin();
		
		
		Personne p1 = new Personne();
		p1.setNom("abbb");
		p1.setId(1);
		//p.setNom("ABCD");
		em2.merge(p1);
		
		tx.commit();
		em2.close();
		emf2.close();
	}
	
	static void Test5() {
		Computer pc = new Computer();
		pc.setSN("xxx");
		pc.setModel("Terra");
		
		Personne p = new Personne();
		p.setId(2);
		p.setNom("toto");
		p.setPrenom("titi");
		pc.setPersonne(p);
		p.setComputer(pc);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		em.persist(pc);
		em.persist(p);
		
		tx.commit();
		em.close();
		emf.close();
	}
	
	static void test3() {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		Personne p = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.find(Personne.class, 1);

		em.remove(p);
		//em.remove(p.getPc());
		tx.commit();
		em.close();*/
	}

	
	static void testmerge4() {
		/*Personne p1 = new Personne();
		Personne p2;
		p1.setId(13);
		p1.setNom("a");
		p1.setPrenom("b");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(p1);
		p1.setNom("x");
		tx.commit();
		em.close();
		// New extended persistence context
		 emf = Persistence.createEntityManagerFactory("pdb1");
		 em = emf.createEntityManager();
		 tx = em.getTransaction();
		tx.begin();

		p1=em.merge(p1);
		p1.setNom("y");
		tx.commit();
		em.close();*/
	}
	static void test12()
	
	{
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		
		Personne p=em.find(Personne.class, 1);
		
		em.close();
		System.out.println(p);
		System.out.println(p.getPc());*/
		
	}
	//static void test11()
	//{
		/*Computer pc=new Computer();
		pc.setModel("Terra");
		pc.setSN("789458");
		
		Personne p1=new Personne();
		p1.setId(1);
		p1.setPrenom("Eren");
		p1.setNom("Jäger");
		pc.setPersonne(p1);
		p1.setPc(pc);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pc);
		em.persist(p1);
		tx.commit();
		em.close();*/
		
		
		
	//}
	static void test10(){
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		
		Departement d=em.find(Departement.class, 75009);
		//System.out.println(d.getListe());
		//System.out.println(d);
		em.close();
		//System.out.println(d);
		System.out.println(d.getListe());*/
	}
	
	static void test9(){
		/*Departement d1=new Departement();
		d1.setId(75009);
		d1.setNom("Paris");

		Personne p1=new Personne();
		p1.setId(178);
		p1.setPrenom("Jacky");
		p1.setNom("Melloul");
		p1.setDepartement(d1);
		
		Personne p2=new Personne();
		p2.setId(4578);
		p2.setPrenom("CC");
		p2.setNom("DD");
		p2.setDepartement(d1);
		
	
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d1);
		em.persist(p1);
		em.persist(p2);
		tx.commit();
		em.close();*/
		
		
	}
	
	static void test8(){
		/*PersonneDAO d = new PersonneDAOHib();
		List<Personne> list =d.findByName("Melloul");
		for(Personne p : list)
		{
			System.out.println(p);
		}
		*/
	}
	static void test7()
	{
		/*DAO<Personne, Integer> d = new PersonneDAOHib();
		List<Personne> list =d.findAll();
		for(Personne p : list)
		{
			System.out.println(p);
		}*/
	}
	
	static void test6()
	{
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pdb1");
		Personne p = new Personne();
		p.setId(12);
		p.setNom("JAcky");
		p.setPrenom("TITI");
		p.setVersion(5);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Personne p1 = em.merge(p);
		tx.commit();
		em.close();*/
	}
	static void test5()
	{
		/*DAO<Personne, Integer> d = new PersonneDAOHib();
		Personne p=new Personne();
		p.setNom("Jacky");
		p.setPrenom("Melloul");
		p.setId(2);
		d.update(p);*/
	}
	static void test4()
	{
		/*DAO<Personne, Integer> d = new PersonneDAOHib();
		Personne p1 = new Personne();
		p1.setId(2);
		p1.setNom("a");
		p1.setPrenom("b");
		d.create(p1);*/
	}
	
	static void test2() {

		/*DAO<Personne, Integer> d = new PersonneDAOHib();
		Personne p = d.findById(13);
		System.out.println(p);*/
	}

	//static void test1() {
		/*Personne p1 = new Personne();
		p1.setId(1);
		p1.setNom("a");
		p1.setPrenom("b");*/
	//}

}
