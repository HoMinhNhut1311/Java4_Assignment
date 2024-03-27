package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Filter.DataCache;
import Model.Users;

@WebServlet("")
public class HomeCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users users = (Users) req.getSession().getAttribute("user");
		DataCache cache = new DataCache(req);
		if (users != null) {
			req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}
}
