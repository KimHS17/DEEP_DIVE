import React, { useEffect, useState } from "react";
import PostList from "./components/PostList";
import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import PostDetail from "./components/PostDetail";
import PostCreate from "./components/PostCreate";
import BoardList from "./components/BoardList";
import BoardCreate from "./components/BoardCreate";
import PostEdit from "./components/PostEdit";
import Cookies from "js-cookie";
import { darkTheme, lightTheme } from "./theme";
import { Box, Button, ThemeProvider } from "@mui/material";
import Login from "./components/Login";

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(!!Cookies.get("isLoggedIn"));
  const [theme, setTheme] = useState(isLoggedIn ? lightTheme : darkTheme);
  const navigate = useNavigate();

  useEffect(() => {
    setTheme(isLoggedIn ? lightTheme : darkTheme);
  }, [isLoggedIn]);

  const handleLogout = () => {
    Cookies.remove("isLoggined");
    setIsLoggedIn(false);
    navigate("/login");
  };

  return (
    <ThemeProvider theme={theme} key={isLoggedIn ? "light" : "dark"}>
      <Box
        sx={{
          backgroundColor: theme.palette.background.default,
          minHeight: "100vh",
        }}
      >
        <h1>게시판</h1>
        {isLoggedIn && (
          <Button variant="outlined" onClick={handleLogout}>
            로그아웃
          </Button>
        )}
        <Routes>
          <Route
            path="/"
            element={
              isLoggedIn ? <Navigate to="/boards" /> : <Navigate to="/login" />
            }
          />
          <Route
            path="/login"
            element={<Login setIsLoggedIn={setIsLoggedIn} />}
          />

          {/* <Route path="/" element={<BoardList />} /> */}
          <Route path="/boards" element={<BoardList />} />

          <Route path="/create-board" element={<BoardCreate />} />

          {/* <Route path="/board/:boardId" element={<PostList />} /> */}
          <Route path="/posts" element={<PostList />} />

          <Route path="/post/:id" element={<PostDetail />} />

          <Route path="/create-post" element={<PostCreate />} />

          <Route path="/edit-post/:id" element={<PostEdit />} />
        </Routes>
      </Box>
    </ThemeProvider>
  );
};

export default App;
