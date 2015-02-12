package model.dao;

import java.util.List;

import com.avaje.ebean.Ebean;

import model.vo.Book;
import exception.PersistenceException;

public class BookDAO extends BaseDAO<Book> {
	
	public BookDAO() {
		super(Book.class);
	}

	public List<Book> selectByReader(String reader) throws PersistenceException {
		try {
			return Ebean.find(Book.class).where().like("reader", reader).findList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}