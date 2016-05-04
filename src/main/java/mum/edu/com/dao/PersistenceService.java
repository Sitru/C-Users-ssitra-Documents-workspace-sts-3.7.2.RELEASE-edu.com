package mum.edu.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceService {

	private static EntityManagerFactory emf;
	
	
	private static EntityManager em;
	
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			try {
				emf = Persistence.createEntityManagerFactory("cs544");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		        
		}
		return emf;
	}
	
	
	public static EntityManager getEntityManager() {
		if (em == null) {
			try {
				em = getEntityManagerFactory().createEntityManager();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		        
		}
		return em;
	}
	
	public static void closeEntityManager(){
		if(em!=null){
			em.close();
		}
	}
	
	public static void closeEntityManagerFactory(){
		if(emf!=null){
			emf.close();
		}
	}

}