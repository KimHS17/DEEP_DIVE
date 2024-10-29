import React, { useEffect, useState } from "react";
import ApiService from "../services/ApiService";
import { Link, useNavigate } from "react-router-dom";
import {
  Button,
  Container,
  List,
  ListItem,
  ListItemText,
  Typography,
} from "@mui/material";
import { useDispatch } from "react-redux";
import { setBoardId } from "../store/slices/boardSlice";

const BoardList = () => {
  const [boards, setBoards] = useState([]);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const loadBoards = async () => {
    try {
      const response = await ApiService.fetchBoards();
      setBoards(response.data);
    } catch (error) {
      console.error("Error fetching boards: ", error);
    }
  };

  useEffect(() => {
    loadBoards();
  }, []);

  const handleClick = (boardId) => {
    dispatch(setBoardId(boardId));
    navigate('/board');
  };

  return (
    <Container>
      <Typography variant="h4">게시판 목록</Typography>
      <List>
        {boards.map((board) => (
          // <ListItem
          //   key={board.board_id}
          //   button
          //   component={Link}
          //   to={`/board/${board.board_id}`}
          // >
          <ListItem key={board.board_id} button onClick={handleClick}>
            <ListItemText primary={board.board_name} />
          </ListItem>
        ))}
      </List>
      <Button
        variant="contained"
        color="primary"
        component={Link}
        to="/create-board"
      >
        새 게시판 추가
      </Button>
    </Container>
  );
};

export default BoardList;
