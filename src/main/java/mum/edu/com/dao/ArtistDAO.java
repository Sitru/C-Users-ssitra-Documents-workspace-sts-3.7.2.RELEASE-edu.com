package mum.edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import mum.edu.com.model.Artist;



public class ArtistDAO {
	private static EntityManagerFactory emf;
	private static EntityManager em = null;
	private static EntityTransaction tx = null;

	static {
		try {
			
			em = PersistenceService.getEntityManager();
			tx = em.getTransaction();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public void create(Artist artist) {
		try {
			tx.begin();
			em.persist(artist);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 

	}

	public void delete(Artist artist) {

		try {
			tx.begin();
			em.remove(artist);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 
	}

	@SuppressWarnings("unchecked")
	public List<Artist> findAllArtists() {
		return em.createQuery("FROM Artist").getResultList();
	}
	
	

}
