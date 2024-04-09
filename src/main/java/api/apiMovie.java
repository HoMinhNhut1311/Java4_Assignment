package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Movie;
import Util.JsonUtils;
import Util.MovieUtils;

@WebServlet("/api/movie/*")
public class apiMovie extends HttpServlet{
	private MovieUtils movieUtils = new MovieUtils();
	JsonUtils jsonUtils = new JsonUtils();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getPathInfo().substring(1);
		System.out.println("movie/"+action);
		
		switch (action) {
		case "getall":
			System.out.println(movieUtils.getallMovie());
			jsonUtils.writeData(resp, movieUtils.getallMovie());
			break;
		case "topView":
			jsonUtils.writeData(resp, movieUtils.getTopMovie());
			System.out.println("Get topview");
			break;
		case "findByID":
			String id = req.getParameter("id");
			jsonUtils.writeData(resp, movieUtils.findById(id));
			break;
		default:
			break;
		}
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getPathInfo().substring(1);
		System.out.println("post/"+action);
		switch (action) {
		case "add":
			 // Kiểm tra yêu cầu có chứa dữ liệu JSON không
		    String contentType = req.getContentType();
		    if (contentType != null && contentType.contains("application/json")) {
		        // Đọc dữ liệu JSON từ body của yêu cầu
		        ObjectMapper mapper = new ObjectMapper();
		        Movie movie = mapper.readValue(req.getInputStream(), Movie.class);
		        // Thực hiện các thao tác cần thiết với đối tượng Movie
		        // Ví dụ: Thêm đối tượng Movie vào cơ sở dữ liệu
		        movieUtils.addMovie(movie);

		        // Trả về phản hồi cho client
		        resp.setStatus(HttpServletResponse.SC_CREATED); // Hoặc mã phản hồi khác tùy vào kết quả xử lý
		    } else {
		        // Trả về phản hồi lỗi nếu yêu cầu không chứa dữ liệu JSON
		        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		    }
		    break;
		case "delete":
			
			break;

		default:
			break;
		}
	}
	
}
