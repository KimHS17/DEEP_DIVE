import axios from "axios";
import React, { useEffect, useState } from "react";

const BoardList = () => {
  const [boards, setBoards] = useState([]);

  const loadBoards = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/board/all");
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
      <ul>
        <li>
          {boards.map((board) => (
            <li key={board.board_id}>
              ID : {board.board_id} <br></br>
              게시판 이름 : {board.board_name} <br></br>
              상태 : {board.status}
            </li>
          ))}
        </li>
      </ul>
    </div>
  );
};

export default BoardList;
