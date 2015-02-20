package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import model.vo.*;

import javax.persistence.Query;
import javax.persistence.Table;

import com.impetus.client.cassandra.common.CassandraConstants;
import com.impetus.client.cassandra.thrift.ThriftClient;
import com.impetus.kundera.client.Client;

import exception.PersistenceException;

public class BaseDAO<T> {

	private Class<T> _classType;

	public BaseDAO(Class<T> classType) {
		_classType = classType;
	}

	public void create(Object beanObject) throws PersistenceException {
		try 
		{ 
			play.db.jpa.JPA.em().merge(beanObject);
			play.db.jpa.JPA.em().persist(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll() throws PersistenceException {
		try {
			
	        Map<String, Client> clientMap = (Map<String, Client>) play.db.jpa.JPA.em().getDelegate();
	        ThriftClient tc = (ThriftClient) clientMap.get("cassandra_pu");
	        tc.setCqlVersion(CassandraConstants.CQL_VERSION_3_0);
	        
			return play.db.jpa.JPA
					.em()
					.createNativeQuery(
							String.format("SELECT * FROM %s", _classType.getAnnotation(Table.class).name()), Book.class)
					.getResultList();

			// return Ebean.find(_classType).findList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public void update(Object beanObject) throws PersistenceException {
		try {
			// Ebean.update(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void delete(Object beanObject) throws PersistenceException {
		try {
			// Ebean.delete(beanObject);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}
}