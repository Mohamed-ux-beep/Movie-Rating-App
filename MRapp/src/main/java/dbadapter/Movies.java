package dbadapter;

import java.sql.Date;
import java.time.LocalDate;


public class Movies {
	
	private int id;
	private String title;
	private String director;
	private String originalpublishingDate;
	private String actors;
	
	//cons.
	public Movies(int id,String title, String director, String originalpublishingDate2, String actors) {
		this.id=id;
		this.title = title;
		this.director = director;
		this.originalpublishingDate = originalpublishingDate2;
		this.actors = actors;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	//getter and setter
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getOriginalpublishingDate() {
		return originalpublishingDate;
	}
	public void setOriginalpublishingDate(String originalpublishingDate) {
		this.originalpublishingDate = originalpublishingDate;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	
	

}