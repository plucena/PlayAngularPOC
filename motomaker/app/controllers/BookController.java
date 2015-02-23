package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

import model.dao.BookDAO;
import model.services.BookService;
import model.vo.Book;
import play.*;
import play.mvc.*;
import util.StringFunctions;
import util.webservice.JsonObjectParser;
import views.html.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;

public class BookController extends BaseController {

	@play.db.jpa.Transactional(readOnly = true)
	public static Result listAll() {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				List<Book> lista = bookService.selectAll();
				bookService.close();
				return ok(JsonObjectParser.Serialize(lista));
			}
		});
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result selectByUser(final String reader) {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				List<Book> lista = bookService.selectBy("reader", reader);
				bookService.close();
				return ok(JsonObjectParser.Serialize(lista));
			}
		});
	}

	@BodyParser.Of(BodyParser.Json.class)
	@play.db.jpa.Transactional
	public static Result save() {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				Book book = getModelFromRequest(Book.class);
				bookService.save(book);
				bookService.close();
				return ok("saved");
			}
		});
	}

	@BodyParser.Of(BodyParser.Json.class)
	@play.db.jpa.Transactional
	public static Result delete(final String id) {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				BookService bookService = new BookService(new BookDAO());
				bookService.delete(id);
				bookService.close();
				return ok("deleted");
			}
		});
	}
}