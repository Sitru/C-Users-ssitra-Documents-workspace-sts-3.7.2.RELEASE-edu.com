package mum.edu.com;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import mum.edu.com.dao.ArtistDAO;
import mum.edu.com.dao.CommentDAO;
import mum.edu.com.dao.MovieDAO;
import mum.edu.com.dao.PersistenceService;
import mum.edu.com.model.Actor;
import mum.edu.com.model.Artist;
import mum.edu.com.model.Comment;
import mum.edu.com.model.Director;
import mum.edu.com.model.Gener;
import mum.edu.com.model.Movie;
import mum.edu.com.model.MovieRating;
import mum.edu.com.model.User;




public class App {
public static void main(String[] args) {
	fillDataBase();
	MovieDAO movieDao = new MovieDAO();
	List<Movie> movies = movieDao.findAllMovies();
	for(Movie m : movies){
		System.out.println(m.getTitle()+" "+m.getYear());
	}
	PersistenceService.closeEntityManager();
	PersistenceService.closeEntityManagerFactory();
}


public static byte[] readImage(String filename) throws IOException{
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream input = classLoader.getResourceAsStream(filename);
	int contentLength = input.available();
	byte[] data = new byte[contentLength];
	input.read(data);
	input.close();
	return data;
}

public static void fillDataBase() {
	byte[] imax_cover=null;
	byte[] Angelina_pic = null;
	byte[] actor1_pic = null;
	/*try {

		imax_cover = readImage("imax.png");
		Angelina_pic = readImage("Angelina.jpg");
		 actor1_pic = readImage(" actor1.jpg");
	} catch (IOException e) {

		e.printStackTrace();*/

//}
		Movie imax = new Movie("imax", 2016, imax_cover,
				"mask of zoroo "
						+ "it is interesting....",
						MovieRating.PG_13, new ArrayList<Gener>(
						Arrays.asList(new Gener[] { Gener.ROMANCE, Gener.ADVENTURE, Gener.ANIMATION })));

		Actor Angelina= new Actor();
		Angelina.setBirth_plce("texase");
		Angelina.setPlay("play");
		Angelina.setFname("Angelina");
		Angelina.setLname("jollie");
	    Angelina.setProfile_Picture(Angelina_pic);
	
	
		Angelina.setBio(
				"An English film, television, and stage actor, who has had a distinguished career on stage and screen.");

		Director actor1 = new Director();
		
		 actor1.setFname("kebede");
		 actor1.setMovie("mask of zoro");
		 actor1.setLname("balcha");
		 //actor1.setDateof_Birth("01/01/1945");
		 actor1.setBirth_plce("Austraalia");
		 actor1.setProfile_Picture(actor1_pic);
		

		Comment c1 = new Comment(1020,"imax is a fun, action-filled", "01/01/2016", "sitra");
			
		
		
		ArtistDAO artistDao = new ArtistDAO();
		CommentDAO commentDao = new CommentDAO();
		artistDao.create(actor1);
		artistDao.create(Angelina);
		
		commentDao.create(c1);
		
		EntityManager em =null;
	
		// User(Integer user_id, String fname, String lname, String email, List<Comment> comments)
			User sitra = new User(15,"sitra", "sitru", "sitra@gmail.com");
			User hiwi = new User(12,"hiwi", "hiwi", "hiwi@gmail.com");
			User ekru = new User(16,"ekru", "ekru", "ekru@gmail.com");

			
			List<Movie> movieName2 = em.createQuery("from Movie m where m.title ='mask of zoro' ").getResultList();
			List<Movie> movieGenre  = em.createQuery("from Movie m where m.genre = 'Romance' ").getResultList();
			
			
			

}
}
