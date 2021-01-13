package com.igncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable{
	
	private int id;
	private int timeviewed;
	

	//Se hereda el metodo constructor "padre" de Films (añadimos el atributo year)
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	//Metodo 1
	public void showData() {
		//System.out.println("Title:" + this.title);
		//System.out.println("Genre:" + this.genre);
		//System.out.println("Year:" + this.year);
	}
	
	//Getter (obtener, devuelve un dato)	
	public int getId() {
		return id;
	}

	//Setter (setear, asigna un dato)		
/*	public void setId(int id) {
		this.id = id;
	}	CANCELAMOS EL SET PORQUE HAREMOS QUE SE GENERE AUTOMATICAMENTE(IDEAL)
*/

	
	public int getTimeViewed() {
		return timeviewed;
	}


	public void setTimeViewed(int timeviewed) {
		this.timeviewed = timeviewed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" +
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() + 
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
		if(dateF.getTime() > dateI.getTime()) {
				setTimeViewed((int)(dateF.getTime() - dateI.getTime())); 
		}else {
			setTimeViewed(0);
		}
		
	}
	
	public static ArrayList<Movie> makeMoviesList(){
		ArrayList<Movie> movies = new ArrayList();
		
		
		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie("Movie " +i, "Genero " +i, "Creador " +i, 120+i, (short)(2017+i)));			
		}
		
		return movies;
	}
	
	
}
