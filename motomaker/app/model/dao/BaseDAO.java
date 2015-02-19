package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.avaje.ebean.Ebean;

import exception.PersistenceException;

public class BaseDAO<T> {
	
	private Class<T> _classType;
	
	public BaseDAO(Class<T> classType) {
		_classType = classType;
	}
	
	
	public void create(Object beanObject) throws PersistenceException {
		try {
			//Ebean.save(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public List<T> selectAll() throws PersistenceException {
		try {
			return Ebean.find(_classType).findList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
	
	public void update(Object beanObject) throws PersistenceException {
		try {
			//Ebean.update(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	public void delete(Object beanObject) throws PersistenceException {
		try {
			//Ebean.delete(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}
}