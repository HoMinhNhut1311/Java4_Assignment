package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Model.Users;
import Util.JpaUtils;
import Util.QueryUtil;

public class User_Imp implements Cinema_interFace<Users>{
	QueryUtil<Users> queryUtil = new QueryUtil<Users>();
	
	@Override
	public boolean add(Users t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Users tOld, Users tNew) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Users t) throws DataBindingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Users> getAll() throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getObject_ByCondition(String hql,String[] paramKey,Object... attributes) throws DataBindingException {
		Users users = queryUtil.executeQuerySingle(hql,paramKey, attributes);
		return users;
	}
	
	public static void main(String[] args) {
	}

	@Override
	public List<Users> getList_ByCondition(String hql,String[] paramKey ,Object... attributes)
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
	public List<Users> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		
	}

	

	

}
