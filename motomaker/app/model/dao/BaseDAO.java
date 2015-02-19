package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import model.vo.*;
import javax.persistence.Query;

import exception.PersistenceException;

public class BaseDAO<T> {
	
	private Class<T> _classType;
	
	public BaseDAO(Class<T> classType) {
		_classType = classType;
	}
	
	
	public void create(Object beanObject) throws PersistenceException {
		try {
			play.db.jpa.JPA.em().persist(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll() throws PersistenceException {
		try {
			
			 Query query = play.db.jpa.JPA.em().createQuery("SELECT e FROM Book e");
			 return  query.getResultList();
			    
			//return Ebean.find(_classType).findList();
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