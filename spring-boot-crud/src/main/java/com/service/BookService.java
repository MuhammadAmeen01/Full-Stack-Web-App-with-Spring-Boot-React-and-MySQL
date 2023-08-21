package com.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.database.BookDao;
import com.model.Books;

@Service
public class BookService {
	
	public BookDao Database=new BookDao();
	private List<Books>topic=Database.getAllBooks();	//new ArrayList<>(Arrays.asList(new Books("1","Mrs. Entwhistle Minds Her Own Business Kindle Edition"," Doris Reidy","$12","https://m.media-amazon.com/images/I/51wL4XnGtIL.jpg"),new Books("2","The List","Patricia Forde","$15","https://m.media-amazon.com/images/I/51n4r8N-UvL._SX330_BO1,204,203,200_.jpg")));
	public List<Books>getallbooks(){
		System.out.print("hehehehehehehhe");
		return topic;
	}
	
	public List<Books>getbooks(){
		return Database.getAllBooks();
	}
	public Books getbook(String ID) {
		
		return topic.stream().filter(t->t.getBookid().equals(ID)).findFirst().get();
	}
	public void addbook(Books t) {
		// TODO Auto-generated method stub
		topic.add(t);
		Database.insertBook(t);
	}
	public void updatebook(Books t, String id) {
		// TODO Auto-generated method stub
		
		for (int i=0; i<topic.size(); i++)
		{
			Books t1=topic.get(i);
			if(t1.getBookid().equals(id)) {
				topic.set(i, t);
				Database.updateBook(t);
				return;
			}
		}
	}
	public void deletebook(String id) {
		// TODO Auto-generated method stub
		topic.removeIf(t->t.getBookid().equals(id));
		Database.deleteBook(id);
	}
}
