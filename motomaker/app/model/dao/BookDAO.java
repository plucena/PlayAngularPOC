package model.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Table;

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
			Map<String, Client> clientMap = (Map<String, Client>) play.db.jpa.JPA.em().getDelegate();
	        ThriftClient tc = (ThriftClient) clientMap.get("cassandra_pu");
	        tc.setCqlVersion(CassandraConstants.CQL_VERSION_3_0);
	        
			return play.db.jpa.JPA
					.em()
					.createNativeQuery(
							String.format("SELECT * FROM Book WHERE reader like '%s'", reader), Book.class)
					.getResultList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}