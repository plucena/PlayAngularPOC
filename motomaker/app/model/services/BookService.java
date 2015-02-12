package model.services;

import java.util.List;

import model.dao.BookDAO;
import model.vo.Book;
import exception.BusinessException;
import exception.PersistenceException;

public class BookService extends BaseService<Book> {
	private BookDAO _bookDAO;
	
	public BookService(BookDAO bookDAO) {
		super(Book.class);
		_bookDAO = bookDAO;
	}
	
	public List<Book> selectByReader(String reader) throws BusinessException {
		try {
			return _bookDAO.selectByReader(reader);
		} catch (PersistenceException pe) {
			throw new BusinessException(pe);
		}
	}
}