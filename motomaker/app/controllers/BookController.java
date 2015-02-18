package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

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
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				List<Book> lista = bookService.selectAll();
				return ok(JsonObjectParser.Serialize(lista));
			}
		});
	}

	public static Result selectByUser(final String reader) {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				List<Book> lista = bookService.selectByReader(reader);
				return ok(JsonObjectParser.Serialize(lista));
			}
		});
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				//Book book = getModelFromRequest(Book.class);
				//bookService.create(book);
				//return ok("ok " + book.getAuthor());
			}
		});
	}
}