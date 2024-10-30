import React, { useState } from "react";
import ApiService from "../services/ApiService";
import { useLocation, useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import { Box, Button, Container, TextField, Typography } from "@mui/material";

const PostCreate = () => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const navigate = useNavigate();
  // const location = useLocation();
  // const boardId = location.state;
  const boardId = useSelector((state) => state.boardState.boardId);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const postData = {
      board_id: boardId,
      user_name: userName,
      password: password,
      email: email,
      title: title,
      content: content,
    };

    try {
      const response = await ApiService.createPost(postData);
      console.log("Post created successfully: ", response.data);
      // navigate(`/board/${boardId}`);
      navigate(`/posts`);
    } catch (error) {
      console.error("Error creating post: ", error);
    }
  };

  return (
    <Container>
      <Typography variant="h4">게시글 작성</Typography>
      <Box>
        <TextField
          label="작성자 이름"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
          required
        />
      </Box>
      <Box>
        <TextField
          label="비밀번호"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </Box>
      <Box>
        <TextField
          label="이메일"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </Box>
      <Box>
        <TextField
          label="제목"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
      </Box>
      <Box>
        <TextField
          label="내용"
          value={content}
          onChange={(e) => setContent(e.target.value)}
          required
        />
      </Box>
      <Button variant="contained" color="primary" onClick={handleSubmit}>
        작성하기
      </Button>
    </Container>
  );
};

export default PostCreate;
