package vo;

import model.vo.Book;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exception.VOException;

public class BookTests {
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void BookAuthorIsInvalid() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Author is required");
		
		Book book = new Book("", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookCollectionIsInvalid() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Collection is required");
		
		Book book = new Book("George R. R. Martin", "", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookTitleIsInvalid() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Title is required");
		
		Book book = new Book("George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookUserIsInvalid() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("User is required");
		
		Book book = new Book("George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "");
	}
	
	@Test
	public void BookIsValid() throws VOException {
		Book book = new Book("George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
}