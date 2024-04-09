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
	}
	



}
