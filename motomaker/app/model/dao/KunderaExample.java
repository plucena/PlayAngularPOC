package model.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;

import model.vo.Book;

public class KunderaExample
{
    public static void main(String[] args) throws Exception
    {
    	
    	Map map = new HashMap();
    	map.put("kundera.nodes", "localhost");
    	map.put("kundera.port", "9160");
    	map.put("kundera.keyspace", "KunderaExamples");
    	map.put("sessionless", "false");
    	map.put("kundera.client", "com.impetus.kundera.client.PelopsClient");
    	map.put("sessionless", "false");
    	
        Book book = new Book();
        //book.setId("3");
        book.setOther("");
        book.setReader("plucena@gmail.com");
        book.setTitle("Brave New World");
        book.setAuthor("Aldus Huxley"); 

       // EntityManagerFactory emf = new EntityManagerFactoryImpl("test", map);
       // EntityManager em  = emf.createEntityManager();

        
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra_pu");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra_pu", map); 

        EntityManager em = emf.createEntityManager();
        
        em.persist(book);
        em.close();    
        emf.close();    
    }
}