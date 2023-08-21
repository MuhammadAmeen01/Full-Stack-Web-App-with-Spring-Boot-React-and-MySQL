package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Books;
import com.service.BookService;
@RestController
public class BookController {

	@Autowired
	private BookService topicservice;
	
	
	@RequestMapping("/hello")
	public String sayhello() {
		return "hello";
	}
	@RequestMapping("/books")
	public List<Books> books()
 	{
		System.out.print("hehehhee"+topicservice.getallbooks());
		return topicservice.getallbooks();
 	}
	
	
	@RequestMapping("/books/{id}")
	public Books gettopic(@PathVariable String id)
 	{
		System.out.print("heeheeheeh");
		return topicservice.getbook(id);
 	}
	
	@RequestMapping(method=RequestMethod.POST,value="/books")
	public void addTopic(@RequestBody Books t) {
		System.out.print(t.getBookid());
		topicservice.addbook(t);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/books/{id}")
	public void updateTopic(@RequestBody Books t,@PathVariable String id) {
		System.out.print(t.getBookid());
		topicservice.updatebook(t,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/books/{id}")
	public void Deletetopic(@PathVariable String id)
 	{
		System.out.print(id);
		topicservice.deletebook(id);
 	}
}
