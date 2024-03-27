package Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Model.Movie;
import Util.AsmUtils;

public class Movie_Service {
	AsmUtils<Movie> asmUtils = new AsmUtils<Movie>();
	static String source = "https://www.youtube.com/embed/cfbKqpbdrYg";
	
	public List<Movie> getallMovie(HttpServletRequest request) {
		String urlApi = "http://localhost:8080/"+contextPath.getContextpath()+"/api/movie/getall";
		return asmUtils.callAPI_List(urlApi, Movie.class, "get");
	}
	
	public Movie getTopView(HttpServletRequest request) {
		String urlApi = "http://localhost:8080/"+contextPath.getContextpath()+"/api/movie/topView";
		return asmUtils.callAPI_Obj(urlApi, Movie.class, "get");
	}
	
	public Movie findById(HttpServletRequest request,String id) {
		String urlApi = "http://localhost:8080/Java4_Assignment/api/movie/findByID?id="+id;
		return asmUtils.callAPI_Obj(urlApi, Movie.class, "get");
	}
	
	public static void setSource(String source) {
		Movie_Service.source = source;
	}
	
	public static String getSource() {
		return source;
	}
	
	
}
