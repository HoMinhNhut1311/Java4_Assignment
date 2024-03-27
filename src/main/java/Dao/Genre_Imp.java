package Dao;

import java.util.List;

import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Genre;
import Model.Users;
import Util.QueryUtil;

public class Genre_Imp implements Cinema_interFace<Genre>{
	QueryUtil<Genre> queryUtil = new QueryUtil<Genre>();
	
	@Override
	public boolean add(Genre t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Genre tOld, Genre tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Genre t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Genre> getAll() throws DataBindingException {
		List<Genre> listGenre = queryUtil.executeQueryList("SELECT g FROM Genre g");
		return listGenre;
	}

	@Override
	public Genre getObject_ByCondition(String hql, String[] paramKey, Object... attributes) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> getList_ByCondition(String hql, String[] paramKey, Object... attributes)
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
	public List<Genre> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		
	}




	

	
	

}
