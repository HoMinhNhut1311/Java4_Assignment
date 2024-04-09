package Util;

import java.util.List;

import Dao.MovieI_Imp;
import Model.Movie;

public class MovieUtils {
	private MovieI_Imp movieI_Imp = new MovieI_Imp();
	static final String getTopMovie_JPQL = "SELECT m FROM Movie m ORDER BY m.visit DESC";
	static final String getMoviebyID = "Select m FROM Movie m where m.id = :id";

	public Movie addMovie(Movie movie) {
		movieI_Imp.add(movie);
		return movie;
	}
	
	public List<Movie> getallMovie() {
		return movieI_Imp.getAll();
	}
	
	public Movie getTopMovie() {
		return movieI_Imp.getObject_ByCondition(getTopMovie_JPQL, null, null);
	}
	
	public Movie findById(String id) {
		return movieI_Imp.getObject_ByCondition(getMoviebyID, new String[] {
				"id"
		}, Integer.valueOf(id));
	}
}
