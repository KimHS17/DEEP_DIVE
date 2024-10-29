import React, { useEffect, useState } from "react";
import { Navigate, useLocation, useParams } from "react-router-dom";
import ApiService from "../services/ApiService";
import {
  Box,
  Button,
  Container,
  Grid2,
  Modal,
  TextField,
  Typography,
} from "@mui/material";

const PostDetail = () => {
  const { id } = useParams();
  const [post, setPost] = useState(null);
  const [password, setPassword] = useState("");
  const [showModal, setShowModal] = useState(false);
  const [actionType, setActionType] = useState(""); // edit 또는 delete
  const [errorMessage, setErrorMessage] = useState("");
  const location = useLocation();
  const navigate = Navigate;

  const modalStyle = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 400,
    bgcolor: "background.paper",
    borderRadius: 2,
    boxShadow: 24,
    p: 4,
  };

  useEffect(() => {
    fetchPostDetails(location.state.password);
  }, [id, location.state]);

  const fetchPostDetails = async (password) => {
    try {
      const response = await ApiService.fetchPostDetails(id, password);
      setPost(response.data);
    } catch (error) {
      console.error("Error fetching post details: ", error);
    }
  };

  const handleActionClick = (type) => {
    setActionType(type);
    setShowModal(true);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async () => {
    setErrorMessage("");
    try {
      //삭제
      if (actionType === "delete") {
        await ApiService.deletePost(id, password);
        navigate(`/board/${post.board_id}`);
      }
      //수정
      else if (actionType === "edit") {
        console.log("test");
        console.log(post);
      }
    } catch (error) {
      console.error("Error fetching post details: ", error);
      if (error.response && error.response.status === 400) {
        setErrorMessage("비밀번호가 잘못되었습니다. 다시시도해주세요.");
      } else {
        setErrorMessage("오류가 발생했습니다. 다시 시도해주세요.");
      }
    }
  };

  if (!post) {
    return <div>Loading...</div>;
  }

  return (
    <Container>
      <Typography variant="h4" gutterBottom>
        {post.title}
      </Typography>
      <Typography variant="body1">작성자: {post.user_name}</Typography>
      <Typography variant="body1">
        작성일: {new Date(post.posted_at).toLocaleDateString}
      </Typography>
      <Typography variant="body1">{post.content}</Typography>

      <Grid2 container spacing={2}>
        <Grid2 item>
          <Button
            onClick={() => {
              handleActionClick("edit");
            }}
          >
            수정하기
          </Button>
        </Grid2>
        <Grid2 item>
          <Button
            onClick={() => {
              handleActionClick("delete");
            }}
          >
            삭제하기
          </Button>
        </Grid2>
        <Grid2 item>
          <Button
            onClick={() => {
              navigate(`/board/${post.board_id}`);
            }}
          >
            목록으로 가기
          </Button>
        </Grid2>
      </Grid2>
      <Modal open={showModal} onclose={() => setShowModal(false)}>
        <Box sx={modalStyle}>
          <Typography variant="h6" gutterBottom>
            비밀번호를 입력하세요
          </Typography>
          <TextField
            type="password"
            label="비밀번호"
            fullWidth
            value={password}
            onChange={handlePasswordChange}
            error={!!errorMessage}
            helperText={errorMessage}
          />
          <Box sx={{ mt: 2, display: "flex", justifyContent: "space-between" }}>
            <Button variant="contained" color="primary" onClick={handleSubmit}>
              확인
            </Button>
            <Button
              variant="contained"
              color="primary"
              onClick={() => setShowModal(false)}
            >
              취소
            </Button>
          </Box>
        </Box>
      </Modal>
    </Container>
  );
};

export default PostDetail;
