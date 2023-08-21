import axios from "axios";
import React from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Add = () => {
  const [book, setBook] = useState({
    bookid: "",
    bookname: "",
    price: "",
    URL: "",
  });

  console.log(book);
  const [error,setError] = useState(false)

  const navigate = useNavigate();

  const handleChange = (e) => {
    setBook((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleClick = async (e) => {

    e.preventDefault();
    console.log(book)
    try {
      await axios.post("http://localhost:8080/books", book);
      navigate("/");
    } catch (err) {
      console.log(err);
      setError(true)
    }
  };

  return (
    <div className="form">
      <h1>Add New Book</h1>
      <input
        type="text"
        placeholder="Book ID"
        name="bookid"
        onChange={handleChange}
      />
      <textarea
        rows={5}
        type="text"
        placeholder="Book Title"
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
      <button onClick={handleClick}>Add</button>
      {error && "Something went wrong!"}
      <Link to="/">See all books</Link>
    </div>
  );
};

export default Add;
