package controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import com.avaje.ebeaninternal.server.core.DefaultServer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.vo.Book;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.MySqlPlatform;
import com.avaje.ebeaninternal.server.core.DefaultServer;
import com.avaje.ebeaninternal.server.ddl.DdlGenerator;

public class BookControllerTest {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}
	
    @Test
    public void createBook() throws Exception {
		Book book = new Book("0", "Jake Delta", "wish", "", "Play Framework 2 For Java", "mleonardi@ciandt.com");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(book);
		JsonNode jsonNode = mapper.readTree(json);        
        
    	Result result = callAction(controllers.routes.ref.BookController.save(), fakeRequest().withJsonBody(jsonNode));
    	
    	assertThat(status(result)).isEqualTo(OK);
    }
	
    @Test
    public void createBookInvalidJson() throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree("{\"author\": \"Jake Delta\", \"collection\": \"wish\", \"id\": 188, \"other\": \"\", \"title\": \"Play Framework 2 For Java\", \"loguser\": \"plucena@gmail.com\"}");        
        
    	Result result = callAction(controllers.routes.ref.BookController.save(), fakeRequest().withJsonBody(jsonNode));
    	
    	assertThat(status(result)).isEqualTo(INTERNAL_SERVER_ERROR);
    }
}