package mum.edu.com.model;

import javax.persistence.Entity;

@Entity
public class Actor extends Artist{
	private String play;

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

	
	

}
