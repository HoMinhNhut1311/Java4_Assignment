package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MovieI_Imp;
import Filter.DataCache;
import Model.Actor;
import Model.Genre;
import Model.Movie;
import Service.Movie_Service;
import Util.JpaUtils;
import Util.MovieUtils;

@WebServlet("/addMovie")
public class addMovie extends HttpServlet{
	private Movie_Service movie_Service = new Movie_Service();
	private MovieI_Imp movieI_Imp = new MovieI_Imp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Movie m = new Movie();
		m.setId(Integer.parseInt(id));
		movieI_Imp.delete(m);
	    DataCache.getListM().removeIf(movie -> movie.getId() == Integer.parseInt(id));
		req.getRequestDispatcher("/views/").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    resp.setCharacterEncoding("UTF-8");

	    String title = new String(req.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
	    System.out.println("Title: "+title);
		Genre genre = JpaUtils.getEntityManager().find(Genre.class, Long.parseLong(req.getParameter("genre")));
		String director = new String(req.getParameter("director").getBytes("ISO-8859-1"), "UTF-8");
		String des = new String(req.getParameter("des").getBytes("ISO-8859-1"), "UTF-8");
		String srcImg = req.getParameter("srcImg");
		List<Actor> actors = new ArrayList<Actor>();
		String[] selectedActors = req.getParameterValues("actors");
		if (selectedActors != null) {
		for (String idActor : selectedActors) {
			Actor actor = JpaUtils.getEntityManager().find(Actor.class, Long.parseLong(idActor));
			actors.add(actor);
			System.out.println(actor.getName());
		}
		}
		double rating = Double.parseDouble(req.getParameter("rating"));	
		
		String releaseStr = req.getParameter("release");
		// Định dạng cho chuỗi ngày
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// Chuyển đổi chuỗi thành LocalDate
		LocalDate localDate = LocalDate.parse(releaseStr, formatter);

		// Chuyển LocalDate thành java.util.Date
		Date release = Date.valueOf(localDate);
		
		String sourceTrailer = req.getParameter("sourceTrailer");
		String sourceWatch = req.getParameter("sourceWatch");
		Movie movie = new Movie(title, genre, director, des, srcImg, actors, 0, release, rating, sourceTrailer, sourceWatch);
		System.out.println("Movie: "+movie);
		req.setAttribute("movie", movie);
		movie_Service.addMovie(req, movie);
		
		DataCache.getListM().add(movie);
		req.getRequestDispatcher("/views/").forward(req, resp);
	}
	
	
	
}
