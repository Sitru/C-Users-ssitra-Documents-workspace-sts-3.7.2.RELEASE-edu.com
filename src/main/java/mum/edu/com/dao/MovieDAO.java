package mum.edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import mum.edu.com.model.Gener;
import mum.edu.com.model.Movie;
import mum.edu.com.model.MovieRating;



public class MovieDAO {

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

	public void create(Movie movie) {
		try {
			tx.begin();
			em.persist(movie);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 

	}

	public void delete(Movie movie) {

		try {
			tx.begin();
			em.remove(movie);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {

				tx.rollback();
			}
		} 
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findAllMovies() {
		return em.createQuery("FROM Movie").getResultList();
	}
	
	public Movie findMoviesbyTitle(String title){
		return (Movie)em.createQuery("FROM Movie m WHERE title= :title")
				.setParameter("title", title).getSingleResult();
		
	}
	@SuppressWarnings("unchecked")
	public List<Movie> findMoviesbyGenre(Gener genre){
		return em.createQuery("FROM Movie m WHERE genre= :genre")
				.setParameter("genre", genre).getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> findMoviesbyYear(int year){
		return em.createQuery("FROM Movie m WHERE year= :year")
				.setParameter("year", year).getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> findbyMoviesRating(MovieRating rating){
		return em.createQuery("FROM Movie m WHERE rating= :rating")
				.setParameter("rating", rating).getResultList();
		
	}
	@SuppressWarnings("unchecked")
	public List<Movie> findMoviesbyCharacter(String role){
		return em.createQuery("SELECT DISTINCT m FROM Actor a JOIN a.movie WHERE a.role= :role")
				.setParameter("role", role).getResultList();
		
	}
	@SuppressWarnings("unchecked")
	public List<Movie> findMoviesbyDirector(String directorName){
		return em.createQuery("SELECT DISTINCT m FROM Director d JOIN d.movie WHERE d.name= :director")
				.setParameter("name", directorName).getResultList();
		
	}
	

}
