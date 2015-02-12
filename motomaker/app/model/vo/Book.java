package model.vo;

import play.db.ebean.Model;
import util.StringFunctions;

import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import exception.VOException;

@Entity
public class Book extends Model {
	
	@Id
	@GeneratedValue
	private int id;
	@Constraints.Required
	@Constraints.MaxLength(255)
	private String author;
	@Constraints.Required
	@Constraints.MaxLength(255)
	private String collection;
	@Constraints.MaxLength(255)
	private String other;
	@Constraints.Required
	@Constraints.MaxLength(255)
	private String title;
	@Constraints.Required
	@Constraints.MaxLength(255)
	private String user;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) throws VOException {
		this.author = author;
	}
	
	public String getCollection() {
		return collection;
	}
	
	public void setCollection(String collection) throws VOException {
		this.collection = collection;
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) {
		this.other = other;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) throws VOException {
		this.title = title;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) throws VOException {
		this.user = user;
	}
	
	public Book(){};
	
	public Book(String author, String collection, String other,
			String title, String user) throws VOException {
		super();
		setAuthor(author);
		setCollection(collection);
		setOther(other);
		setTitle(title);
		setUser(user);
	}
}