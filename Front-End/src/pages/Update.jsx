import axios from "axios";
import React, { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";

const Update = () => {
  const [book, setBook] = useState({
    bookid: "",
    bookname: "",
    price: "",
    URL: "",
  });
  const [error,setError] = useState(false)

  const location = useLocation();
  const navigate = useNavigate();
  
  console.log("pathname:",location.pathname);
  const bookId = location.pathname.split("/")[2];
  console.log("bookID:",bookId);
  const handleChange = (e) => {
    setBook((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleClick = async (e) => {
    e.preventDefault();

    try {
      console.log(book)
      await axios.put(`http://localhost:8080/books/${book.bookid}`, book);
      navigate("/");
    } catch (err) {
      console.log(err);
      setError(true);
    }
  };

  return (
    <div className="form">
      <h1>Update the Book</h1>
      <input
        type="text"
        placeholder="Book ID"
        name="bookid"
        onChange={handleChange}
      />
      <textarea
        rows={5}
        type="text"
        placeholder="Book Name"
        name="bookname"
        onChange={handleChange}
      />
      <input
        type="number"
        placeholder="Book price"
        name="price"
        onChange={handleChange}
      />
      <input
        type="text"
        placeholder="Book cover URL"
        name="URL"
        onChange={handleChange}
      />
      <button onClick={handleClick}>Update</button>
      {error && "Something went wrong!"}
      <Link to="/">See all books</Link>
    </div>
  );
};

export default Update;
