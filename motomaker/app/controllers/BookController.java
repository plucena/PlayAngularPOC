package controllers;

import java.util.LinkedList;
import java.util.List;

import model.dao.BookDAO;
import model.services.BookService;
import model.vo.Book;
import play.*;
import play.mvc.*;
import util.webservice.JsonObjectParser;
import views.html.*;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;

public class BookController extends BaseController {

	public static Result listAll() {
		try {
			BookService bookService = new BookService(new BookDAO());
			List<Book> lista = bookService.selectAll();	
			return ok(JsonObjectParser.Serialize(lista));			
		} catch (Exception e) {
			return internalServerError(e.getMessage());
		}
	}

	public static Result selectByUser(String user) {
		try {
			BookService bookService = new BookService(new BookDAO());
			List<Book> lista = bookService.selectByUser(user);
			return ok(JsonObjectParser.Serialize(lista));
		} catch (Exception e) {
			return internalServerError(e.getMessage());
		}
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() {
		try {
			BookService bookService = new BookService(new BookDAO());
			Book book = getModelFromRequest(Book.class);
			bookService.createBook(book);
			return ok("ok " + book.getAuthor());
		} catch (Exception e) {
			return internalServerError(e.getMessage());
		}
	}
}