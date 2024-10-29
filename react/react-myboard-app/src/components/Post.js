import React, { useState } from "react";
import ApiService from "../services/ApiService";
import { useNavigate } from "react-router-dom";
import { Box, Button, Modal, TextField, Typography } from "@mui/material";

const Post = ({ post }) => {
  const [showModal, setShowModal] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

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

  const handleClick = () => {
    setShowModal(true);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async () => {
    setErrorMessage("");
    try {
      await ApiService.fetchPostDetails(post.id, password);
      navigate(`/post/${post.id}`, { state: { password } });
    } catch (error) {
      console.error("Error fetching post details: ", error);
      if (error.response && error.response.status === 400) {
        setErrorMessage("비밀번호가 잘못되었습니다. 다시시도해주세요.");
      } else {
        setErrorMessage("오류가 발생했습니다. 다시 시도해주세요.");
      }
    }
  };

  return (
    <Box>
      <Typography variant="body2" onClick={handleClick}>
        {post.title} | 작성자: {post.user_name} | 작성일:{" "}
        {new Date(post.posted_at).toLocaleDateString()}
      </Typography>

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
    </Box>
  );
};

export default Post;