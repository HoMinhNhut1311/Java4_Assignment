package api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.Users;
import Service.User_Service;
import Util.JsonUtils;
import Util.UserUtils;

@WebServlet("/api/*")
public class apiUser extends HttpServlet{
	JsonUtils jsonUtils = new JsonUtils();
	UserUtils userUtils = new UserUtils();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().write("API call at"+req.getContextPath() + "/api");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getPathInfo().substring(1);
		System.out.println("URI: "+action);
		switch (action) {
		case "login":
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			Users user = userUtils.login(username, password);
			jsonUtils.writeData(resp, user);
			break;
		default:
			break;
		}
		
	}
	
}
