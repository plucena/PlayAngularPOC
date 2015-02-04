package controllers;


import java.util.LinkedList;

import models.Book;
import play.*;
import play.mvc.*;
import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Books  extends Controller {
	
	  public static Result index() {
		  JsonNode jsonNode = null;
		  
		  try {
			  LinkedList<Book> lista = new LinkedList<Book>(); 
			  lista.add(new Book(1, "Douglas Adams", "fiction", "", "hitchhiker's guide to the galaxy",  "plucena@gmail.com" ));  
			  lista.add(new Book(1, "George Orwell", "fiction", "", "1984",  "plucena@gmail.com" ));  
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
