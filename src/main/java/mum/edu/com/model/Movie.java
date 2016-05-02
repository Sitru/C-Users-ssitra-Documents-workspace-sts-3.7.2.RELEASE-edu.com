package mum.edu.com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


public class Movie
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movie_id;
	private String title;
	private int year;
	@Lob
	private byte[] cover;
	private String summary;
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Gener> getGenres() {
		return genres;
	}
	public void setGenres(List<Gener> genres) {
		this.genres = genres;
	}
	public MovieRating getRating() {
		return rating;
	}
	public void setRating(MovieRating rating) {
		this.rating = rating;
	}
	@OneToMany(mappedBy="movie")
	private List<Artist> artists = new ArrayList<Artist>();
	@OneToMany(mappedBy="movie")
	private List<Comment> comments = new ArrayList<Comment>();
	@ElementCollection
	private List<Gener> genres = new ArrayList<Gener>();
	@Enumerated
	private MovieRating rating;
}
