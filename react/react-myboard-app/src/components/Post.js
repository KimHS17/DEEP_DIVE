import React, { useState } from "react";
import ApiService from "../services/ApiService";
import { useNavigate } from "react-router-dom";

const Post = ({ post }) => {
  const [showModal, setshowModal] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleClick = () => {
    setshowModal(true);
  };

  const handlePassword = (e) => {
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
    <div>
      <div onClick={handleClick}>
        <span>{post.title}</span> | 작성자: {post.user_name} | 작성일:{" "}
        {new Date(post.posted_at).toLocaleDateString()}
      </div>
      {showModal && (
        <div className="modal">
          <div className="modal_content">
            <h4>비밀번호를 입력하세요</h4>
            <input
              type="password"
              value={password}
              onChange={handlePassword}
              placeholder="비밀번호"
            />
            {errorMessage && <p>{errorMessage}</p>}
            <button onClick={handleSubmit}>확인</button>
            <button onClick={() => setshowModal(false)}>취소</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default Post;
