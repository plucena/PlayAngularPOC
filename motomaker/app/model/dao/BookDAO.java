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
}