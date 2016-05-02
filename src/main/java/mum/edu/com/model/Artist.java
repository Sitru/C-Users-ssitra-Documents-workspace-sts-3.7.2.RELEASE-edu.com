package mum.edu.com.model;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer artist_id;

	private String Fname;
	private String Lname;

	private Date dateof_Birth;
	public Integer getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(Integer artist_id) {
		this.artist_id = artist_id;
	}
	
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public Date getDateof_Birth() {
		return dateof_Birth;
	}
	public void setDateof_Birth(Date dateof_Birth) {
		this.dateof_Birth = dateof_Birth;
	}
	public String getBirth_plce() {
		return Birth_plce;
	}
	public void setBirth_plce(String birth_plce) {
		Birth_plce = birth_plce;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public byte[] getProfile_Picture() {
		return profile_Picture;
	}
	public void setProfile_Picture(byte[] profile_Picture) {
		this.profile_Picture = profile_Picture;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	private String Birth_plce;
	private String bio;
	
	private byte[] profile_Picture;
	@ManyToOne
	private Movie movie;
	
	
	

}
