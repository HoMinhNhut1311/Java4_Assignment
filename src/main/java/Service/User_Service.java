package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.User_Imp;
import Model.Users;
import Util.AsmUtils;
import Util.JsonUtils;



public class User_Service{
	
//Service để truy cập đến APi
	private Gson gson = new Gson();
	AsmUtils<Users> asmUtils = new AsmUtils<Users>();
	// CRUD
	public boolean addUser(Users user) {
		return false;
	}
	public boolean removeUser(Users user) {
			return false;
	}
	public boolean updateUser(Users uOld, Users uNew) {
		return false;
	}
	
	
	
	// Các Service khác
	public Users logIn(HttpServletRequest req,String userName,String password) {
		String urlApi ="http://localhost:8080/" +req.getContextPath()+"/api/login?username="+userName + "&password="+password;
		return asmUtils.callAPI_Obj(urlApi, Users.class,"POST");
	}
	
	public static void main(String[] args) {
		
	}
}
