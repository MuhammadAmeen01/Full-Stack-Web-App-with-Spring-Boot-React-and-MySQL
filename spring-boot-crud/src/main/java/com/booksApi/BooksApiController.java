package com.booksApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.controller", "com.model", "com.service","com.config"})
public class BooksApiController {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SpringApplication.run(BooksApiController.class, args);

		}

}
