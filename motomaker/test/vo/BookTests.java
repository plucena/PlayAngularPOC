package vo;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import javassist.bytecode.SignatureAttribute.ClassType;
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
	
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}
	
	@Test
	public void BookAuthorIsRequired() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Author is required");
		
		new Book("0", "", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookCollectionIsRequired() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Collection is required");
		
		new Book("0", "George R. R. Martin", "", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookTitleIsRequired() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Title is required");
		
		new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookUserIsRequired() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Reader is required");
		
		new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "");
	}
	
	@Test
	public void BookAuthorMaxLength() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Author have limit of 255 characters");
		
		new Book("0", "George R. R. Martin Agatha Cristie Monteiro Lobato Tia Anastácia Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon da Silva Souza Sales Oliveira da Silva Della", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookCollectionMaxLength() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Collection have limit of 255 characters");
		
		new Book("0", "George R. R. Martin", "Collection of The Best Books of the Entire World George R. R. Martin Agatha Cristie Monteiro Lobato Tia Anastácia Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bou", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookOtherMaxLength() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Other have limit of 255 characters");
		
		new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "Other Agatha Cristie Monteiro Lobato Tia Anastácia Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon da Silva Souza Sales Oliveira da Silva Dellacour from Tooo", "A Game of Thrones", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookTitleMaxLength() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Title have limit of 255 characters");
		
		new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones Agatha Cristie Monteiro Lobato Tia Anastácia Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon da Silva Souza Sales Oliveira da Silva Dellaco", "mleonardi@ciandt.com");
	}
	
	@Test
	public void BookReaderMaxLength() throws VOException {
		thrown.expect(VOException.class);
		thrown.expectMessage("Reader have limit of 255 characters");
		
		new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com Agatha Cristie Monteiro Lobato Tia Anastácia Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon da Silva Souza Sales Oliveira da Silva Dell");
	}
	
	@Test
	public void BookIsValid() throws VOException {
		new Book("0", "George R. R. Martin", "As Crônicas de Gelo e Fogo", "", "A Game of Thrones", "mleonardi@ciandt.com");
	}
}