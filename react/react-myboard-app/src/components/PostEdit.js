import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import { Box, Button, Container, TextField, Typography } from "@mui/material";
import { updatePost } from "../store/slices/postSlice";

const PostEdit = () => {
  const { id } = useParams();
  const post = useSelector((state) => state.postState.post);
  const boardId = useSelector((state) => state.boardState.boardId);
  const [userName, setUserName] = useState("");
  const [email, setEmail] = useState("");
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const location = useLocation(); // 비밀번호 상태 가져오기
  const password = location.state.password;

  useEffect(() => {
    setUserName(post.user_name);
    setEmail(post.email);
    setTitle(post.title);
    setContent(post.content);
  }, [post]);

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
      dispatch(updatePost({ postId: id, postData }));
      navigate("/posts");
    } catch (error) {
      console.error("Error editing post: ", error);
    }
  };

  return (
    <Container>
      <Typography variant="h4">게시글 수정</Typography>
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
        수정하기
      </Button>
    </Container>
  );
};

export default PostEdit;
