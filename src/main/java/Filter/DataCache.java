package Filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Model.Genre;
import Model.Movie;
import Service.Genre_Service;
import Service.Movie_Service;

public class DataCache {
	static Genre_Service genre_Service;
	static List<Genre> listGenre;
	static Movie_Service ms;
	static List<Movie> listM;
	static Movie topView;
	
	public DataCache(HttpServletRequest request) {
		genre_Service = new Genre_Service();
		listGenre = genre_Service.getallMovie(request);
	    ms = new Movie_Service();
	    listM =  ms.getallMovie(request); 
	    topView = ms.getTopView(request);
	    System.out.println("Data cần thiết đã được khởi tạo");
	}
	
	public static Genre_Service getGenre_Service() {
		return genre_Service;
	}
	public static List<Genre> getListGenre() {
		return listGenre;
	}
	public static List<Movie> getListM() {
		return listM;
	}
	public static Movie_Service getMs() {
		return ms;
	}
	public static Movie getTopView() {
		return topView;
	}
	
}
