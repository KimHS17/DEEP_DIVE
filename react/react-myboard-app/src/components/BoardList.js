import React, { useEffect, useState } from "react";
import ApiService from "../services/ApiService";
import { Link } from "react-router-dom";
import {
  Button,
  Container,
  List,
  ListItem,
  ListItemText,
  Typography,
} from "@mui/material";

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
    <Container>
      <Typography variant="h4">게시판 목록</Typography>
      <List>
        {boards.map((board) => (
          <ListItem
            key={board.board_id}
            button
            component={Link}
            to={`/board/${board.board_id}`}
          >
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
