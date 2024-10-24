import React, { useState } from "react";
import ApiService from "../services/ApiService";
import { useNavigate } from "react-router-dom";

const BoardCreate = () => {
  const [boardName, setBoardName] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    try {
      await ApiService.createBoard(boardName);
      navigate("boards");
    } catch (error) {
      console.log("Error creating board: ", error);
    }
  };

  return (
    <div>
      <h3>게시판 생성</h3>
      <form onSubmit={handleSubmit}>
        <label>게시판 이름</label>
        <input
          type="text"
          value={boardName}
          onChange={(e) => setBoardName(e.target.value)}
        />
        <button type="submit">게시판 생성</button>
      </form>
    </div>
  );
};

export default BoardCreate;
