import React from "react";
import PostList from "./components/PostList";
import { Route, Routes } from "react-router-dom";
import PostDetail from "./components/PostDetail";
import PostCreate from "./components/PostCreate";
import BoardList from "./components/BoardList";
import BoardCreate from "./components/BoardCreate";
import PostEdit from "./components/PostEdit";

const App = () => {
  return (
    <div>
      <h1>게시판</h1>
      <Routes>
        <Route path="/" element={<BoardList />} />
        <Route path="/boards" element={<BoardList />} />

        <Route path="/create-board" element={<BoardCreate />} />

        {/* <Route path="/board/:boardId" element={<PostList />} /> */}
        <Route path="/board" element={<PostList />} />

        <Route path="/post/:id" element={<PostDetail />} />

        <Route path="/create-post" element={<PostCreate />} />

        <Route path="/edit-post/:id" element={PostEdit} />
      </Routes>
    </div>
  );
};

export default App;
