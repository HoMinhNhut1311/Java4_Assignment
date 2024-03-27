package Dao;

import java.util.List;

import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Episode;

public class Episode_Imp implements Cinema_interFace<Episode>{

	@Override
	public boolean add(Episode t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Episode tOld, Episode tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Episode t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Episode> getAll() throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getObject_ByCondition(String hql, String[] paramKey, Object... attributes)
			throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Episode> getList_ByCondition(String hql, String[] paramKey, Object... attributes)
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
	public List<Episode> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		
	}

	

	


	

}
