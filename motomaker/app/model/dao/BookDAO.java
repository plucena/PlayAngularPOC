package model.dao;

import java.util.List;

import javax.persistence.Table;

import com.avaje.ebean.Ebean;

import model.vo.Book;
import exception.PersistenceException;

public class BookDAO extends BaseDAO<Book> {
	
	public BookDAO() {
		super(Book.class);
	}

	public List<Book> selectByReader(String reader) throws PersistenceException {
		try {
			return play.db.jpa.JPA
					.em()
					.createNativeQuery(
							String.format("SELECT * FROM Book WHERE reader like '%s'", reader))
					.getResultList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}