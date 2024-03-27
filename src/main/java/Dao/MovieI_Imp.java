package Dao;

import java.util.List;

import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Movie;
import Util.QueryUtil;

public class MovieI_Imp implements Cinema_interFace<Movie>{

		QueryUtil<Movie> queryUtil = new QueryUtil<Movie>();
	
	@Override
	public boolean add(Movie t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Movie tOld, Movie tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Movie t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
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
