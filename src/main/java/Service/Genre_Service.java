package Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Model.Genre;
import Util.AsmUtils;

public class Genre_Service {

	JsonObject jsonObject = new JsonObject();
	AsmUtils<Genre> asmUtils = new AsmUtils<Genre>();
	// Các Service khác
	public List<Genre> getallGenre(HttpServletRequest req) {
		String urlApi = "http://localhost:8080/"+contextPath.getContextpath()+"/api/genre/getall";
		System.out.println(asmUtils.callAPI_List(urlApi, Genre.class,"get"));
		return asmUtils.callAPI_List(urlApi, Genre.class,"get");
	}
}
