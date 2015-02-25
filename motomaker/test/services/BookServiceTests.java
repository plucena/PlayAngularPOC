package services;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.LinkedList;
import java.util.List;

import model.dao.BookDAO;
import model.services.BookService;
import model.vo.Book;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class BookServiceTests {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}
	
	@Test
	public void selectByUserValidWithMockito() throws Exception {
		BookDAO bookDAO = Mockito.mock(BookDAO.class);
		
		List<Book> bookList = new LinkedList<Book>();
		bookList.add(new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com"));
		
		Mockito.when(bookDAO.selectBy("reader", "mleonardi@ciandt.com")).thenReturn(bookList);
		
		BookService bookService = new BookService(bookDAO);
		
		List<Book> books = bookService.selectBy("reader", "mleonardi@ciandt.com");
		
		assertEquals(1, books.size());
	}
	
	@Test
	public void selectByUserValidWithDatabaseInMemory() throws Exception {
		BookDAO bookDAO = new BookDAO();
		
		Book book1 = new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
		Book book2 = new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Clash of Kings", "plucena@ciandt.com");
		Book book3 = new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Storm of Swords", "mleonardi@ciandt.com");
		bookDAO.save(book1);
		bookDAO.save(book2);
		bookDAO.save(book3);
		
		BookService bookService = new BookService(bookDAO);
		
		List<Book> books = bookService.selectBy("reader", "mleonardi@ciandt.com");
		
		assertEquals(2, books.size());
	}
}