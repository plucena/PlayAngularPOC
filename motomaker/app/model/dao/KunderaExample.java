package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.vo.Book;

public class KunderaExample
{
    public static void main(String[] args) throws Exception
    {
        Book book = new Book();
        book.setId(3);
        book.setOther("");
        book.setReader("plucena@gmail.com");
        book.setTitle("Brave New World");
        book.setAuthor("Aldus Huxley"); 

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra_pu");
        EntityManager em = emf.createEntityManager();

        em.persist(book);
        em.close();    
        emf.close();    
    }
}