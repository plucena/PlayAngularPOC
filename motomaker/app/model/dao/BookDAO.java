package model.dao;

import java.util.List;

import com.avaje.ebean.Ebean;

import model.vo.Book;
import exception.PersistenceException;

public class BookDAO extends BaseDAO<Book> {
	
	public BookDAO() {
		super(Book.class);
	}

	public List<Book> selectByUser(String user) throws PersistenceException {
		try {
			return Ebean.find(Book.class).where().like("user", user).findList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}