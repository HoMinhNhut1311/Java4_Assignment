package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Movie;
import Service.Movie_Service;

@WebServlet("/movie/detail")
public class DetailCtl extends HttpServlet{
	
	Movie_Service movie_Service = new Movie_Service();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Movie m = movie_Service.findById(req, id);
		if (m != null) {
			req.setAttribute("movie", m);
			req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
		}
		else {
			resp.sendError(404);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
