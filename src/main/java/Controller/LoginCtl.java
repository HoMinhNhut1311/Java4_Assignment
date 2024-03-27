package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Filter.DataCache;
import Model.Genre;
import Model.Users;
import Service.Genre_Service;
import Service.User_Service;

@WebServlet("/login")
public class LoginCtl extends HttpServlet{
	private User_Service user_service = new User_Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Kiểm tra thông tin đăng nhập
	    Users user = user_service.logIn(req,req.getParameter("username"), req.getParameter("password"));
	    if (user != null) {
	        // Lưu thông tin người dùng vào session
	        HttpSession session = req.getSession();
	        session.setAttribute("user", user);
	        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	    } else {
	        req.setAttribute("error", "Tài khoản không tồn tại!Ngu");
	        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	    }
	}

}
