package model.dao;

import java.util.List;

import com.avaje.ebean.Ebean;

import model.vo.Book;
import exception.PersistenceException;

public class BookDAO {
	public void create(Book newBook) throws PersistenceException {
		try {
			Ebean.save(newBook);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public List<Book> selectAll() throws PersistenceException {
		try {
			return Ebean.find(Book.class).findList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public List<Book> selectByUser(String user) throws PersistenceException {
		try {
			return Ebean.find(Book.class).where().like("user", user).findList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}