package controllers;


import java.util.LinkedList;
import java.util.List;

import models.Book;
import play.*;
import play.mvc.*;
import views.html.*;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Books  extends Controller {
	
	  public static Result index() {
		  JsonNode jsonNode = null;
		  
		  try {
			  // get book list from database
			  List<Book> lista =  Ebean.createQuery(Book.class).findList();

			  ObjectMapper mapper = new ObjectMapper(); 
			  String json = mapper.writeValueAsString(lista);
			   jsonNode = mapper.readTree(json);
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		 
		  Result jsonResult = ok(jsonNode);
	      return jsonResult;
	    }


}
