package Filter;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import Service.User_Service;
import Util.JpaUtils;

@WebListener
public class SetUp implements ServletContextListener {
	private static JpaUtils jpaUtils = new JpaUtils();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	try {
    		// Khởi tạo các tài nguyên
        	System.out.println("------------Website được khởi chạy------------");
        	// Kết nói JPA
        	JpaUtils jpaUtils = new JpaUtils();
        	User_Service user_service = new User_Service();
        	jpaUtils.getEntityManager();	
        	//
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	try {
    		//Dọn dẹp tài nguyên
        	System.out.println("------------Website được ngắt kết nối------------");
        	
        	// Ngắt kết nối JPA
        	jpaUtils.shutdown();
        	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
}
