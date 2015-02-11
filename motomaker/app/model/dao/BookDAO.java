package model.dao;

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
}