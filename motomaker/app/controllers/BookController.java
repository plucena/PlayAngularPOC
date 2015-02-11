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

		try {
			// get book list from database
			List<Book> lista = Ebean.createQuery(Book.class).findList();

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

		try {
			// get book list from database
			List<Book> lista = Ebean.find(Book.class).where()
					.like("user", user).findList();

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
			Book b = mapper.readValue(jp, Book.class);
			bookService.createBook(b);
			return ok("ok " + b.getAuthor());

		} catch (Exception e) {
			return internalServerError(e.getMessage());
		}

	}

}
