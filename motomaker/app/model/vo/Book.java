package model.vo;

import java.util.Random;
import java.util.UUID;

import javax.persistence.*;

import util.StringFunctions;
import exception.ExceptionMessages;
import exception.VOException;
import play.db.jpa.*;

@Entity
@Table(name = "Book", schema = "KunderaExamples@cassandra_pu")
public class Book {
	@Id
	private String id;

	@Column(name = "author")
	public String author;

	@Column(name = "collection")
	public String collection;

	@Column(name = "other")
	public String other;

	@Column(name = "title")
	public String title;

	@Column(name = "reader")
	public String reader;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
			throw new VOException("Collection",
					ExceptionMessages.FIELD_IS_REQUIRED);
		}

		if (collection.length() > 255) {
			throw new VOException("Collection",
					ExceptionMessages.maxLength(255));
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

	public Book() {
	};

	public Book(String id, String author, String collection, String other,
			String title, String reader) throws VOException {
		super();
		setId(id);
		setAuthor(author);
		setCollection(collection);
		setOther(other);
		setTitle(title);
		setReader(reader);
	}
}
