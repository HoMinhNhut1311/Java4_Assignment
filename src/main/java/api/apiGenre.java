package api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.GenreUtils;
import Util.JsonUtils;

@WebServlet("/api/genre/*")
public class apiGenre extends HttpServlet{
	private static GenreUtils genreUtils = new GenreUtils();
	private static JsonUtils jsonUtils = new JsonUtils();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getPathInfo().substring(1);
		System.out.println(action);
		switch (action) {
		case "getall":
			jsonUtils.writeData(resp, genreUtils.getallGenre());
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
