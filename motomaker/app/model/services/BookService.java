package model.services;

import model.dao.BookDAO;
import model.vo.Book;
import exception.BusinessException;
import exception.PersistenceException;

public class BookService {
	private BookDAO _bookDAO;
	
	public BookService(BookDAO bookDAO) {
		_bookDAO = bookDAO;
	}
	
	public void createBook(Book bookToBeCreated) throws BusinessException {
		try {
			_bookDAO.create(bookToBeCreated);
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}
}