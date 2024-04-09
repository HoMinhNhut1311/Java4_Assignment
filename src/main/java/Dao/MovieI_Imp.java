package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Actor;
import Model.Genre;
import Model.Movie;
import Util.JpaUtils;
import Util.QueryUtil;

public class MovieI_Imp implements Cinema_interFace<Movie>{

		QueryUtil<Movie> queryUtil = new QueryUtil<Movie>();
		@Override
		public boolean add(Movie t) throws DataBindingException {
			EntityManager entityManager = JpaUtils.getEntityManager();
			entityManager.getTransaction().begin();
			Movie moviePersits = new Movie();
			List<Actor> actors = new ArrayList<Actor>();
			for (Actor actor : t.getActors()) {
				actor = entityManager.find(Actor.class, actor.getId());
				actors.add(actor);
			}
			Genre genre = entityManager.find(Genre.class, t.getGenre().getGenre_id());	
			moviePersits.setTitle(t.getTitle());
			moviePersits.setActors(actors);
			moviePersits.setGenre(genre);
			moviePersits.setDes(t.getDes());
			moviePersits.setDirector(t.getDirector());
			moviePersits.setDuration(t.getDuration());
			moviePersits.setRating(t.getRating());
			moviePersits.setReleaseYear(t.getReleaseYear());
			moviePersits.setSourceTrailer(t.getSourceTrailer());
			moviePersits.setSourceWatch(t.getSourceWatch());
			moviePersits.setSrcImg(t.getSrcImg());
			entityManager.persist(moviePersits);
			entityManager.getTransaction().commit();
			return true;
		}



	@Override
	public boolean update(Movie tOld, Movie tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Movie t) throws DataBindingException {
	    EntityManager entityManager = JpaUtils.getEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    try {
	        transaction.begin();

	        // Kiểm tra xem đối tượng có được quản lý bởi EntityManager hay không
	        if (!entityManager.contains(t)) {
	            // Nếu không, tìm đối tượng trong cơ sở dữ liệu và đính kèm vào session
	            t = entityManager.merge(t);
	        }

	        entityManager.remove(t);
	        entityManager.flush();

	        transaction.commit();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        return false;
	    } finally {
	        if (entityManager != null && entityManager.isOpen()) {
	            entityManager.close();
	        }
	    }
	}
	


	@Override
	public List<Movie> getAll() throws DataBindingException {
		return queryUtil.executeQueryList("SELECT m FROM Movie m");
	}

	@Override
	public Movie getObject_ByCondition(String hql, String[] paramKey, Object... attributes) throws DataBindingException {
		Movie m = queryUtil.executeQuerySingle(hql, paramKey, attributes);
		return m;
	}

	@Override
	public List<Movie> getList_ByCondition(String hql, String[] paramKey, Object... attributes)
			throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beginTransaction() throws DataBindingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commitTransaction() throws DataBindingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollbackTransaction() throws DataBindingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movie> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		
	}

	



	

	

}
