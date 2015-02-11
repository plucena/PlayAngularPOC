package controllers;

import java.util.LinkedList;
import java.util.List;

import model.dao.BookDAO;
import model.services.BookService;
import model.vo.Book;
import play.*;
import play.mvc.*;
import views.html.*;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;

public class BookController extends Controller {

	public static Result listAll() {
		JsonNode jsonNode = null;
		BookService bookService = new BookService(new BookDAO());

		try {
			// get book list from database
			List<Book> lista = bookService.selectAll();

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(lista);
			jsonNode = mapper.readTree(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Result jsonResult = ok(jsonNode);
		return jsonResult;
	}

	public static Result selectByUser(String user) {
		JsonNode jsonNode = null;
		BookService bookService = new BookService(new BookDAO());

		try {
			// get book list from database
			List<Book> lista = bookService.selectByUser(user);

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(lista);
			jsonNode = mapper.readTree(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Result jsonResult = ok(jsonNode);
		return jsonResult;
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() {
		BookService bookService = new BookService(new BookDAO());

		try {
			System.out.println("Creating...");
			JsonNode json = request().body().asJson();
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = new JsonFactory();
			JsonParser jp = factory.createJsonParser(json.toString());
			Book book = mapper.readValue(jp, Book.class);
			bookService.createBook(book);
			return ok("ok " + book.getAuthor());
		} catch (Exception e) {
			return internalServerError(e.getMessage());
		}

	}

}
