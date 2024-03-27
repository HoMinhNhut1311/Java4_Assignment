package Dao;

import java.util.List;

import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Review;

public class Review_Imp implements Cinema_interFace<Review>{

	@Override
	public boolean add(Review t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Review tOld, Review tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Review t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Review> getAll() throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getObject_ByCondition(String hql, String[] paramKey, Object... attributes) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getList_ByCondition(String hql, String[] paramKey, Object... attributes)
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
	public List<Review> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		
	}

	



	

	

}
