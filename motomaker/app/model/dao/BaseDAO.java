package model.dao;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.vo.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

import play.db.jpa.JPA;
import util.StringFunctions;

import com.impetus.client.cassandra.common.CassandraConstants;
import com.impetus.client.cassandra.thrift.ThriftClient;
import com.impetus.kundera.client.Client;

import exception.PersistenceException;

public class BaseDAO<T> {
	
	private Class<T> _classType;
	protected EntityManager _entityManager;

	public BaseDAO(Class<T> classType) {
		_classType = classType;
		_entityManager = Persistence.createEntityManagerFactory("cassandra_pu").createEntityManager();
		
		Map<String, Client> clientMap = (Map<String, Client>) play.db.jpa.JPA.em().getDelegate();
        ThriftClient tc = (ThriftClient) clientMap.get("cassandra_pu");
        tc.setCqlVersion(CassandraConstants.CQL_VERSION_3_0);
	}
	
	public void close() throws PersistenceException {
		try {			
			_entityManager.close();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void save(Object object) throws PersistenceException {
		try {			
			if (StringFunctions.isNullOrEmptyOrWhiteSpace(object.getClass().getMethod("getId").invoke(object).toString())) {
				Class[] params = new Class[1];
				params[0] = String.class;
				
				object.getClass().getMethod("setId", params).invoke(object, UUID.randomUUID().toString());
			}
			
			_entityManager.persist(object);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public Object selectById(String id) {
		return _entityManager.find(_classType, id);
	}

	public List<T> selectBy(String field, String value) {
		return _entityManager
				.createQuery(
						String.format(
								"SELECT e FROM %s e WHERE e.%s = %s",
								_classType.getAnnotation(Table.class).name(),
								field,
								value),
							_classType)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll() throws PersistenceException {
		try {
			return _entityManager
					.createQuery(
							String.format("SELECT e FROM %s e", _classType.getAnnotation(Table.class).name()),
							_classType)
					.getResultList();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public void delete(String id) throws PersistenceException {
		try {
			Object objectToDelete = selectById(id);
			
			_entityManager.remove(objectToDelete);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}
}