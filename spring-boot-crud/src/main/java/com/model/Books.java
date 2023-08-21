package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Books  
{    
	private String bookid;  

	private String bookname;  

//	private String author;  

	private String price;
	
	private String URL;
	
	public Books() {
		
	}
	
	public Books(String bid, String bname, String auth, String pr, String url) {
		
		this.bookid=bid;
		this.bookname=bname;
//		this.author=auth;
		this.price=pr;
		this.URL=url;
	}
	 @JsonProperty("bookid")
	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	 @JsonProperty("bookname")
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
//	 @JsonProperty("author")
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
	 @JsonProperty("price")
	public String getPrice() {
		return price;
	}
	 @JsonProperty("URL")
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void setPrice(String price) {
		this.price = price;
	}  
	
	
	
}  