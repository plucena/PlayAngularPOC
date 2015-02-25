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
import play.cache.Cached;
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

	@Cached(key = "listaAll", duration = 60 * 1)
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
	
	@play.db.jpa.Transactional(readOnly = true)
	public static Result getUserFromCache(final String reader) {
		return executionHandler(new Callable<Result>() {
			public Result call() throws Exception {
				
				if(null == CacheSingleton.getCacheSingletonInstance().getFromCache(reader)){
					BookService bookService = new BookService(new BookDAO());
					List<Book> book = bookService.selectBy("reader", reader);
					CacheSingleton.getCacheSingletonInstance().putOnCache(reader, book);
				}
				
				return ok(JsonObjectParser.Serialize(CacheSingleton.getCacheSingletonInstance().getFromCache(reader)));
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