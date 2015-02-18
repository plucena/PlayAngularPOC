package model.vo;

import play.db.ebean.Model;
import util.StringFunctions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.MaxLength;
import exception.ExceptionMessages;
import exception.VOException;

@Entity
public class Book extends Model {
	@Id
	@GeneratedValue
	private int id;
	
    @Column(name="author")
	private String author;
	
    @Column(name="collection")
	private String collection;
	
    @Column(name="other")
	private String other;
	
    @Column(name="title")
	private String title;
	
    @Column(name="reader")
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
	
	public void setAuthor(String author) throws VOException {
		if (StringFunctions.isNullOrEmptyOrWhiteSpace(author)) {
			throw new VOException("Author", ExceptionMessages.FIELD_IS_REQUIRED);
		}
		
		if (author.length() > 255) {
			throw new VOException("Author", ExceptionMessages.maxLength(255));
		}
		
		this.author = author;
	}
	
	public String getCollection() {
		return collection;
	}
	
	public void setCollection(String collection) throws VOException {
		if (StringFunctions.isNullOrEmptyOrWhiteSpace(collection)) {
			throw new VOException("Collection", ExceptionMessages.FIELD_IS_REQUIRED);
		}
		
		if (collection.length() > 255) {
			throw new VOException("Collection", ExceptionMessages.maxLength(255));
		}
		
		this.collection = collection;
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) throws VOException {
		if (other.length() > 255) {
			throw new VOException("Other", ExceptionMessages.maxLength(255));
		}
		
		this.other = other;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) throws VOException {
		if (StringFunctions.isNullOrEmptyOrWhiteSpace(title)) {
			throw new VOException("Title", ExceptionMessages.FIELD_IS_REQUIRED);
		}
		
		if (title.length() > 255) {
			throw new VOException("Title", ExceptionMessages.maxLength(255));
		}
		
		this.title = title;
	}
	
	public String getReader() {
		return reader;
	}

	public void setReader(String reader) throws VOException {
		if (StringFunctions.isNullOrEmptyOrWhiteSpace(reader)) {
			throw new VOException("Reader", ExceptionMessages.FIELD_IS_REQUIRED);
		}
		
		if (reader.length() > 255) {
			throw new VOException("Reader", ExceptionMessages.maxLength(255));
		}
		
		this.reader = reader;
	}
	
	public Book(){};
	
	public Book(String author, String collection, String other,
			String title, String reader) throws VOException {
		super();
		setAuthor(author);
		setCollection(collection);
		setOther(other);
		setTitle(title);
		setReader(reader);
	}
}
