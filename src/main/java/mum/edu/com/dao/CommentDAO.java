package mum.edu.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import mum.edu.com.model.Comment;




public class CommentDAO {
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

	public void create(Comment comment) {
		try {
			tx.begin();
			em.persist(comment);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 

	}

	public void delete(Comment comment) {

		try {
			tx.begin();
			em.remove(comment);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 
	}
	
}
