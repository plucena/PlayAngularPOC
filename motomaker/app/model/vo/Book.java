package model.vo;

import play.db.ebean.Model;
import javax.persistence.*;

@Entity
public class Book extends Model {
	
	@Id @GeneratedValue
	private int id;
	private String author;
	private String collection;
	private String other;
	private String title;
	private String reader;
	
	
	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

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
	
	
	public Book(){};
	
	public Book(String author, String collection, String other,
			String title, String reader) {
		super();
		this.id = id;
		this.author = author;
		this.collection = collection;
		this.other = other;
		this.title = title;
		this.reader = reader;
	}
	
	
	
}
