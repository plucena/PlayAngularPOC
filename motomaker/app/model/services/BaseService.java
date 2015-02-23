package model.services;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

import util.StringFunctions;
import model.dao.BaseDAO;
import exception.BusinessException;
import exception.PersistenceException;

public abstract class BaseService<T> {
	
	private BaseDAO<T> _baseDAO;
	
	protected BaseService(Class<T> classType) {
		_baseDAO = new BaseDAO<T>(classType);
	}
	
	public void save(Object object) throws BusinessException {
		try {
			_baseDAO.save(object);
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}
	
	public List<T> selectAll() throws BusinessException {
		try {
			return _baseDAO.selectAll();
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}
	
	public void delete(String id) throws BusinessException {
		try {
			Object objectToDelete = selectBy("id", id);
			
			_baseDAO.delete(objectToDelete);
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}

	public Object selectBy(String field, String id) {
		return _baseDAO.selectBy(field, id);
	}
}