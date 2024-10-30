import React, { useEffect, useState } from "react";
import ApiService from "../services/ApiService";
import Post from "./Post";
import { useNavigate, useParams } from "react-router-dom";
import { Button, Container, List, ListItem, Typography } from "@mui/material";
import { useSelector } from "react-redux";

const PostList = () => {
  // const { boardId } = useParams();
  const boardId = useSelector((state) => state.boardState.boardId);
  const [posts, setPosts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const loadPosts = async () => {
      try {
        const response = await ApiService.fetchPostsByBoardId(boardId);
        setPosts(response.data);
      } catch (error) {
        console.error("Error fetching posts: ", error);
      }
    };

    loadPosts();
  }, [boardId]);

  const handleCreatePost = (boardId) => () => {
    // navigate(`/create-post`, { state: boardId });
    navigate(`/create-post`);
  };

  return (
    <Container>
      <Typography variant="h4">게시글 목록</Typography>
      <List>
        {posts.map((post) => (
          <ListItem key={post.post_id}>
            <Post post={post} />
          </ListItem>
        ))}
      </List>
      <Button
        variant="contained"
        color="primary"
        onClick={() => {handleCreatePost(boardId)}}
        sx={{ mb: 2 }}
      >
        게시글 작성
      </Button>
    </Container>
  );
};

export default PostList;
