package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.DataBindingException;

import org.hibernate.Session;

import Util.JpaUtils;

public interface Cinema_interFace<T> {
	
	// Create
	boolean add(T t) throws DataBindingException;
	// Update
	boolean update(T tOld, T tNew) throws DataBindingException;
	// Delete
	boolean delete(T t)  throws DataBindingException;
	
	// Read
	List<T> getAll()  throws DataBindingException; // Lấy tất cả
	T getObject_ByCondition(String hql,String[] paramKey ,Object... attributes)  throws DataBindingException; // Lấy 1 T theo điều kiện (Dùng hql)
	List<T> getList_ByCondition(String hql,String[] paramKey ,Object... attributes)  throws DataBindingException; // Lấy List theo điều kiện
	
	// Manager Transistion (Quản lí phiên giao dịch)
	void beginTransaction() throws DataBindingException;
	void commitTransaction() throws DataBindingException;
	void rollbackTransaction() throws DataBindingException;
	
	// Phân trang
	List<T> getListWithPagnation(int pageNumber, int pageSize) throws DataBindingException;
	
	void log(String message);


	
}
