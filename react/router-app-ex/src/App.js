import React from "react";
import Home from "./Components/Home";
import Content from "./Components/Content";
import Book from "./Components/Book";
import { Link, Route, Routes } from "react-router-dom";

const App = () => {
  return (
    <div>
      <nav>
        <Link to="/">Home</Link> <Link to="/content">Content</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/content" element={<Content />} />
        <Route path="/book/:title" element={<Book />} />
      </Routes>
    </div>
  );
};

export default App;
