package Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Users;
import Model.Actor;
import Model.Genre;
import Model.Movie;
import Model.UserRole;

public class JpaUtils {
	private static EntityManagerFactory factory;

	static public EntityManager getEntityManager() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("MinhNhut");
		}
		return factory.createEntityManager();
	}

	static public void shutdown() {
		if (factory != null && factory.isOpen()) {
			factory.close();
			System.out.println("Ngắt Kết nối JPA");
		}
		factory = null;
	}
	
	public static void main(String[] args) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
	
         
         List<Actor> listActor = new ArrayList<Actor>();
		
		 listActor.add(entityManager.find(Actor.class, 16l));
		 listActor.add(entityManager.find(Actor.class, 17l));
		 listActor.add(entityManager.find(Actor.class, 18l));
		 listActor.add(entityManager.find(Actor.class, 11l));
		 listActor.add(entityManager.find(Actor.class, 8l));
	 
		Genre g2 = entityManager.find(Genre.class, 10l);
          
	   Movie m2 = new Movie();
	   m2.setTitle("Exhuma - Quật Mộ Trùng Ma"); // Ten Phim
	   m2.setDes("Hai pháp sư, một thầy phong thuỷ và một chuyên gia khâm liệm cùng hợp lực khai quật ngôi mộ bị nguyền rủa của một gia đình giàu có ở Mỹ đang bị nguyền rủa, nhằm cứu lấy sinh mạng hậu duệ cuối cùng trong dòng tộc. Giây phút ngôi mộ bị khai quật cũng là lúc những bí mật hắc ám của tổ tiên được đánh thức. Nhiều hiện tượng kỳ bí, kinh dị đã xảy đến trong hành trình của 4 nhân vật.");
	   // Mo Ta Phim,
	   
	   m2.setDirector("Jang Jae-hyun"); // Dao Dien . Vi du: movie1.setDirector("James Gunn");
	   m2.setDuration(182); // Thoi Luong Phim Vi du : movie1.setDuration(149);
	   m2.setGenre(g2); // The loai phim
	   m2.setRating(9.7); // So Sao danh gia . Vi du : movie1.setRating(9.3);
	   m2.setActors(listActor); // Danh Sach Dien Vien
	   m2.setReleaseYear(Date.valueOf("2024-03-15")); // Ngay Thang Nam ra mat phim. Vi du: movie1.setReleaseYear(Date.valueOf("2023-05-03"));
	   m2.setSourceTrailer("https://www.youtube.com/embed/5-oRO4rYNQ4"); // Set Duong` Dan Phim vi du https://www.youtube.com/embed/cfbKqpbdrYg
	   m2.setSrcImg("https://upload.wikimedia.org/wikipedia/vi/thumb/1/13/Exhuma_film_poster.jpg/330px-Exhuma_film_poster.jpg"); // Set Duong` Dan Anh? 
	   m2.setVisit(0); // Luot Xem , mac dinh cho la` 0
	   entityManager.persist(m2);
		entityTransaction.commit();
	}
	
	
}
