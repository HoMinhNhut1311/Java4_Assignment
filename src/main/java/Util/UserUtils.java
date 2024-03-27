package Util;

import Dao.User_Imp;
import Model.Users;

public class UserUtils {
	static final String JPQL_Login = "SELECT u FROM Users u Where u.username = :username AND u.password = :password";
	static final String[] paramLogin = {"username","password"};
	private User_Imp user_Imp = new User_Imp();
	
	public Users login(String username, String password) {
		return user_Imp.getObject_ByCondition(JPQL_Login,paramLogin,username,password);
	}
}
