package vo;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import model.dao.BookDAO;
import model.vo.Book;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exception.PersistenceException;
import exception.VOException;

public class BookTests {
	
	@Rule public ExpectedException thrown = ExpectedException.none();

	private BookDAO _bookDAO;
	
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
		
		_bookDAO = new BookDAO();
	}
	
	@Test
	public void BookAuthorIsInvalid() throws PersistenceException {
		thrown.expect(PersistenceException.class);
		
		Book book = new Book("", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
		
		_bookDAO.create(book);
	}
	
	@Test
	public void BookCollectionIsInvalid() throws PersistenceException {
		thrown.expect(PersistenceException.class);
		
		Book book = new Book("George R. R. Martin", "", "", "A Game of Thrones", "mleonardi@ciandt.com");
		
		_bookDAO.create(book);
	}
	
	@Test
	public void BookTitleIsInvalid() throws PersistenceException {
		thrown.expect(PersistenceException.class);
		
		Book book = new Book("George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "", "mleonardi@ciandt.com");
		
		_bookDAO.create(book);
	}
	
	@Test
	public void BookUserIsInvalid() throws PersistenceException {
		thrown.expect(PersistenceException.class);
		
		Book book = new Book("George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "");
		
		_bookDAO.create(book);
	}
	
	@Test
	public void BookIsValid() throws PersistenceException {
		Book book = new Book("George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
		
		_bookDAO.create(book);
	}
}