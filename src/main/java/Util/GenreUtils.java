package Util;

import Model.Genre;

import java.util.List;

import Dao.Genre_Imp;

public class GenreUtils {
	private Genre_Imp genre_imp = new Genre_Imp();
	
	public List<Genre> getallGenre() {
		return genre_imp.getAll();
	}
}
