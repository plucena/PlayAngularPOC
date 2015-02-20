package model.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import play.db.jpa.JPA;

import com.avaje.ebean.Ebean;
import com.impetus.client.cassandra.common.CassandraConstants;
import com.impetus.client.cassandra.thrift.ThriftClient;
import com.impetus.kundera.client.Client;

import model.vo.Book;
import exception.PersistenceException;

public class BookDAO extends BaseDAO<Book> {
	
	public BookDAO() {
		super(Book.class);
	}

	public List<Book> selectByReader(String reader) throws PersistenceException {
		try {
			return _entityManager
					.createQuery(
							String.format("SELECT b FROM Book b WHERE b.reader = %s", reader),
							Book.class)
					.getResultList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}