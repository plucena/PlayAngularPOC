package model.vo;

import play.db.ebean.Model;
import util.StringFunctions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.MaxLength;
import exception.VOException;

@Entity
public class Book extends Model {
	
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@MaxLength(255)
	private String author;
	@NotNull
	@MaxLength(255)
	private String collection;
	@MaxLength(255)
	private String other;
	@NotNull
	@MaxLength(255)
	private String title;
	@NotNull
	@MaxLength(255)
	private String reader;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCollection() {
		return collection;
	}
	
	public void setCollection(String collection) {
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
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}
	
	public Book(){};
	
	public Book(String author, String collection, String other,
			String title, String reader) {
		super();
		setAuthor(author);
		setCollection(collection);
		setOther(other);
		setTitle(title);
		setReader(reader);
	}
}
