import React, { useEffect, useState } from "react";
import ApiService from "../services/ApiService";
import { Link } from "react-router-dom";

const BoardList = () => {
  const [boards, setBoards] = useState([]);

  const loadBoards = async () => {
    try {
      const response = await ApiService.fetchBoards();
      console.log(response.data);
      setBoards(response.data);
    } catch (error) {
      console.error("Error fetching boards: ", error);
    }
  };

  useEffect(() => {
    loadBoards();
  }, []);

  return (
    <div>
      <h3>게시판 목록</h3>
      {boards.map((board) => (
        <li key={board.board_id}>
          <Link to={`/posts/${board.board_id}`}>
            ID : {board.board_id} <br></br>
            게시판 이름 : {board.board_name} <br></br>
            상태 : {board.status}
          </Link>
        </li>
      ))}
      <hr />
      <Link to="/create-board">
        <button>게시글 작성</button>
      </Link>
    </div>
  );
};

export default BoardList;
