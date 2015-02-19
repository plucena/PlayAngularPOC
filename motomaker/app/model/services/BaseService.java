package model.services;

import java.awt.print.Book;
import java.util.List;

import model.dao.BaseDAO;
import exception.BusinessException;
import exception.PersistenceException;

public abstract class BaseService<T> {
	
	private BaseDAO<T> _baseDAO;
	
	protected BaseService(Class<T> classType) {
		_baseDAO = new BaseDAO<T>(classType);
	}
	
	public void create(Object beanObject) throws BusinessException {
		try {
			_baseDAO.create(beanObject);
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
	
	public void update(Object beanObject) throws BusinessException {
		try {
			_baseDAO.update(beanObject);
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}
	
	public void delete(Object beanObject) throws BusinessException {
		try {
			_baseDAO.delete(beanObject);
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}
}