import React, { useEffect, useState } from "react";
import ApiService from "../services/ApiService";
import Post from "./Post";
import { Link } from "react-router-dom";

const PostList = () => {
  const [posts, setPosts] = useState([]);

  const loadPosts = async () => {
    try {
      const response = await ApiService.fetchPosts();
      setPosts(response.data);
    } catch (error) {
      console.error("Error fetching posts: ", error);
    }
  };

  useEffect(() => {
    loadPosts();
  }, []);

  return (
    <div>
      <h3>게시글 목록</h3>
      {posts.map((post) => (
        <Post post={post} />
      ))}
      <hr />
      <Link to="/create-post">
        <button>게시글 작성</button>
      </Link>
    </div>
  );
};

export default PostList;
