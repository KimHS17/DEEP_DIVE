import React from "react";
import PostList from "./components/PostList";
import { Route, Routes } from "react-router-dom";
import PostDetail from "./components/PostDetail";
import PostCreate from "./components/PostCreate";
import "./App.css";

const App = () => {
  return (
    <div>
      <h1>익명 질문 게시판</h1>
      <Routes>
        <Route path="/" element={<PostList />} />
        <Route path="/posts" element={<PostList />} />

        <Route path="/post/:id" element={<PostDetail />} />

        <Route path="/create-post" element={<PostCreate />} />
      </Routes>
    </div>
  );
};

export default App;
