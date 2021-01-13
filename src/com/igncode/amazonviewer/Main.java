package com.igncode.amazonviewer;
import java.text.SimpleDateFormat;
//video 51 (completar los datos para todos los metodos)
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.igncode.amazonviewer.model.Chapter;
import com.igncode.amazonviewer.model.Movie;
import com.igncode.amazonviewer.model.Serie;
import com.igncode.makereport.Report;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showMenu();

	}

	public static void showMenu() {

		boolean exit = true;
		do {
			
			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");//.err message error (red colour)
			System.out.println("Selecciona el numero de la opcion deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			
			//Leer la respuesta del usario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			switch(response){
				case 0:
				//salir
					exit = true;
				
					break;
				case 1:
					showMovies();
					break;
				case 2:
					showSeries();
					break;
				case 3:
					showBooks();
					break;
				case 4:
					showMagazines();
					break;
				case 5:
					makeReport();
					break;
				case 6:
					makeReport(new Date());
					break;
				default:
					
					break;
						
			
			}
			
			
		}while(exit != true);
	}
	static ArrayList<Movie> movies;
	public static void showMovies() {
		int exit =1;
		movies = Movie.makeMoviesList(); // creamos la lista "movies" y añadimos con el metodo makeMoviesList 
		do {
			System.out.println();
			System.out.println("::Movies::");
			System.out.println();
			
			for (int i = 0; i < movies.size(); i++) { // 1. Movie 1
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed() );
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			
			//Leer respuesta usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			
			if (response > 0) {
				Movie movieSelected = movies.get(response-1);
				movieSelected.setViewed(true);//ponemos true porque asumimos que ya fue vista
				Date dateI = movieSelected.startToSee(new Date());
				
				for (int i = 0; i < 10000; i++) {
					System.out.println("...........");
				}
				
				//Termine de verla
				movieSelected.stopToSee(dateI, new Date ());//
				System.out.println();
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");
			}
			
			
			
			
			
			
		}while(exit!=0);
	}
	
	public static void showSeries() {
		int exit = 1;
		ArrayList<Serie> series = Serie.makeSeriesList();
		do {
			System.out.println();
			System.out.println("::Series::");
			System.out.println();
			
			for (int i = 0; i < series.size(); i++) { //1. Serie 1
				System.out.println((i+1) + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al menu.");
			System.out.println();
			
			//Leer Respuesta usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			
			showChapters(series.get(response-1).getChapters());
			
		}while(exit != 0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 0;
		
		do {
			System.out.println();
			System.out.println("::Chapters::");
			System.out.println();
			
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {//1. Chapter1
				System.out.println((i+1) + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresarl al menu.");
			System.out.println();;
			
			//Leer Respuesta Usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showSeries();
			}
			
			Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());
			
			for (int i = 0; i < 10000; i++) {
				System.out.println(".............."); //asumimos ver la peli
			}
			
			//Termine de verla
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Viste: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
		}while(exit != 0);
	}
	
	public static void showBooks() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println("::Books::");
			System.out.println();
		}while(exit != 0);
	}
	
	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println("::Magazines::");
			System.out.println();
		}while(exit != 0);
	}
	
	public static void makeReport() {
		
		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
			
		}
		report.setContent(contentReport);
		report.makeReport();
		
		

	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//año mes dia
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setNameFile("reporte" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
			
		}
		report.setContent(contentReport);
		report.makeReport();
	}
	
}
