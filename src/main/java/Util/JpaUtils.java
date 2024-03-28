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
		 
		
		 listActor.add(entityManager.find(Actor.class, 24l));
		 listActor.add(entityManager.find(Actor.class, 25l));
		 listActor.add(entityManager.find(Actor.class, 24l));
		 listActor.add(entityManager.find(Actor.class, 36l));
		 listActor.add(entityManager.find(Actor.class, 37l));
		 listActor.add(entityManager.find(Actor.class, 26l));
		 listActor.add(entityManager.find(Actor.class, 27l));

		 Genre g6 =entityManager.find(Genre.class, 3l);
		 
		 Movie m6 =new Movie();
		 m6.setTitle("Em Là Bà Nội Của Anh");
		 m6.setDes("Em là bà nội của anh (tựa tiếng Anh: Sweet 20) là một bộ phim điện ảnh hài tâm lý xã hội của Việt Nam được khởi chiếu vào tháng 12 năm 2015. Đây là phim điện ảnh đầu tay do nhà phê bình Phan Gia Nhật Linh (Phan Xi Nê) làm đạo diễn.[3]");
		 m6.setDirector("Phan Gia Nhật Linh");
		 m6.setDuration(127);
		 m6.setGenre(g6);
		 m6.setRating(9.0);
		 m6.setActors(listActor);
		 m6.setReleaseYear(Date.valueOf("2015-12-11"));
		 m6.setSourceTrailer("https://youtu.be/vuD-fNWwIyQ?si=oflAng3fPhxBqMDm");
		 m6.setSourceWatch("https://www.youtube.com/embed/UTv0spMLnus?si=RhKu0oYDVpj4t4aL");
		 m6.setSrcImg("https://upload.wikimedia.org/wikipedia/vi/7/72/Poster-ELBNCA.jpg");
		 m6.setVisit(0);
		 entityManager.persist(m6);

		entityTransaction.commit();
	}

}
