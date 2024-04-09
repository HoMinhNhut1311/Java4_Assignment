package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Genre;
import Model.Movie;
import Model.Users;

public class AsmUtils<T> {

    ObjectMapper mapper = new ObjectMapper();
    
    public List<T> callAPI_List(String urlApi, Class<T> valueType,String method) {
    	method = method.toUpperCase();
        try {
            URL url = new URL(urlApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập phương thức yêu cầu là GET
            connection.setRequestMethod(method);

            // Đọc phản hồi từ API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            in.close();
            // Đóng kết nối
            connection.disconnect();

            // Trả về danh sách đối tượng từ chuỗi JSON nhận được từ API
            String data = responseBuilder.toString();
            return mapper.readValue(data, mapper.getTypeFactory().constructCollectionType(List.class, valueType));
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
            return null;
        }
    }
    
    public boolean callCrud(HttpServletRequest request, String apiUrl, String method) {
        method = method.toUpperCase();
        try {
            // Tạo URL object
            URL url = new URL(apiUrl);

            // Mở kết nối HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập phương thức của request là POST hoặc PUT
            connection.setRequestMethod(method);
            // Thiết lập kiểu dữ liệu của request là JSON và mã hóa UTF-8
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            // Cho phép ghi dữ liệu vào body của request
            connection.setDoOutput(true);

            // Lấy đối tượng Movie từ attribute của request
            Movie movie = (Movie) request.getAttribute("movie");

            // Chuyển đối tượng Movie thành chuỗi JSON
            ObjectMapper mapper = new ObjectMapper();
            String jsonInput = mapper.writeValueAsString(movie);

            // Ghi dữ liệu JSON vào body của request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInput.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            // Lấy mã phản hồi từ servlet
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Đóng kết nối
            connection.disconnect();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }




    
    public T callAPI_Obj(String urlApi, Class<T> valueType,String method) {
    	method = method.toUpperCase();
        try {
            URL url = new URL(urlApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập phương thức yêu cầu là GET
            connection.setRequestMethod(method);

            // Đọc phản hồi từ API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            in.close();
            // Đóng kết nối
            connection.disconnect();

            // Trả về danh sách đối tượng từ chuỗi JSON nhận được từ API
            String data = responseBuilder.toString();
            return mapper.readValue(data, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
            return null;
        }
    }
    
    public static void main(String[] args) {
		AsmUtils<Movie> asmUtils = new AsmUtils<Movie>();
		String urlApi = "http://localhost:8080/Java4_Assignment/api/movie/getall";
		List<Movie> list = asmUtils.callAPI_List(urlApi, Movie.class, "get");
	}
}
