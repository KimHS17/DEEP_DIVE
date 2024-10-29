import React, { useState } from "react";
import ApiService from "../services/ApiService";
import { useLocation, useNavigate } from "react-router-dom";

const PostCreate = () => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const navigate = useNavigate();
  const location = useLocation();
  const boardId = location.state;

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
      navigate(`/board/${boardId}`);
    } catch (error) {
      console.error("Error creating post: ", error);
    }
  };

  return (
    <div>
      <h3>게시글 작성</h3>
      <form onSubmit={handleSubmit}>
        <div>
          <lable>작성자 이름:</lable>{" "}
          <input
            type="text"
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
            required
          />
        </div>
        <div>
          <lable>비밀번호:</lable>{" "}
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div>
          <lable>이메일:</lable>{" "}
          <input
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <lable>제목:</lable>{" "}
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <lable>내용:</lable>{" "}
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            required
          />
        </div>
        <button type="submit">작성하기</button>
      </form>
    </div>
  );
};

export default PostCreate;
