package Util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonUtils {
	private ObjectMapper mapper = new ObjectMapper();
	
	public void writeData(HttpServletResponse resp, Object data) {
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    try {
		    String json = mapper.writeValueAsString(data);
	        resp.getWriter().write(json);
	        System.out.println("Phản hồi thành công");
	    } catch (IOException e) {
	        // Xử lý ngoại lệ IO
	        e.printStackTrace(); // Hoặc ghi log
	    }
	}

	
	
}
