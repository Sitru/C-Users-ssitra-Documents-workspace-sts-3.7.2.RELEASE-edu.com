package mum.edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import mum.edu.com.model.Movie;
import mum.edu.com.model.User;



public class UserDAO {
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

	public void create(User user) {
		try {
			tx.begin();
			em.persist(user);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 

	}

	public void delete(User user) {

		try {
			tx.begin();
			em.remove(user);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findAllUsers() {
		return em.createQuery("FROM user").getResultList();
	}
	
}
