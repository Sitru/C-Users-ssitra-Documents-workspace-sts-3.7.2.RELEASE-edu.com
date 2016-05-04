package mum.edu.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Comment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;
	private String user_comment;
	private Date comment_date;
	private User user;
	
	@ManyToOne
	private Movie movie;
	public int getComment_id() {
		return comment_id;
	}
//	
//	public Comment(int comment_id, String user_comment, String string, String string2) {
//		super();
//		this.comment_id = comment_id;
//		this.user_comment = user_comment;
//		this.comment_date = string;
//		this.user = string2;
//	}

	public Comment(int comment_id2, String user_comment2, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
