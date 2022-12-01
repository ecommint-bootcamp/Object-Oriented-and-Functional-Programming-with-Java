package org.javaturk.jpa.ch04.mappings.lob.book;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {
	
	@Id
	@Column(name = "ISBN", length=15)
	private String isbn;
	
	@Column(name = "TITLE", length=100)
	private String title;
	
	@Column(name = "AUTHOR", length=100)
	private String author;
	
	@Column(name = "PUBLISHER", length=100)
	private String publisher;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PUBLICATION_DATE")
	private Date publicationDate;
	
	@Column(name = "STOCK")
	private int stockCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TSTAMP")
	private Date tstamp;

	@Lob
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Lob
	@Column(name = "COVER_PICTURE")
	private  byte[] coverPicture;
	
	public Book() {
		
	}

	public Book(String isbn, String title, String author, String publisher, Date publicationDate, int stockCount, Date tstamp) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.stockCount = stockCount;
		this.tstamp = tstamp;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Date getTstamp() {
		return tstamp;
	}

	public void setTstamp(Date tstamp) {
		this.tstamp = tstamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(byte[] coverPicture) {
		this.coverPicture = coverPicture;
	}
}
