package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Books;

public class BookDao {

    private static final String URL = "jdbc:mysql://localhost:3308/bookstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void insertBook(Books book) {
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "INSERT INTO books (bookid, bookname, price, URL) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, book.getBookid());
            preparedStatement.setString(2, book.getBookname());
            preparedStatement.setString(3, book.getPrice());
            preparedStatement.setString(4, book.getURL());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Books> getAllBooks() {
        List<Books> booksList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM books");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Books book = new Books();
                book.setBookid(resultSet.getString("bookid"));
                book.setBookname(resultSet.getString("bookname"));
                book.setPrice(resultSet.getString("price"));
                book.setURL(resultSet.getString("URL"));
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    public void updateBook(Books book) {
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "UPDATE books SET bookname = ?, price = ?, URL = ? WHERE bookid = ?")) {
            preparedStatement.setString(1, book.getBookname());
            preparedStatement.setString(2, book.getPrice());
            preparedStatement.setString(3, book.getURL());
            preparedStatement.setString(4, book.getBookid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String bookid) {
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "DELETE FROM books WHERE bookid = ?")) {
            preparedStatement.setString(1, bookid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
