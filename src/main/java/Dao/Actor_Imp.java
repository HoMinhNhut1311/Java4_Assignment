package Dao;

import java.util.List;

import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Actor;
import Util.QueryUtil;

public class Actor_Imp implements Cinema_interFace<Actor>{
QueryUtil<Actor> queryUtil = new QueryUtil<Actor>();
	
	@Override
	public boolean add(Actor t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Actor tOld, Actor tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Actor t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Actor> getAll() throws DataBindingException {
		// TODO Auto-generated method stub
		return queryUtil.executeQueryList("Select a from Actor a");
	}

	@Override
	public Actor getObject_ByCondition(String hql, String[] paramKey, Object... attributes) throws DataBindingException {
		List<Actor> listA = queryUtil.executeQueryList(hql, attributes);
		return null;
	}

	@Override
	public List<Actor> getList_ByCondition(String hql, String[] paramKey, Object... attributes)
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
	public List<Actor> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		
	}

	



	



}
