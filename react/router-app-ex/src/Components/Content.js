import React from "react";
import { Link } from "react-router-dom";

const Content = () => {
  return (
    <div>
      <h2>도서 목록</h2>
      <ul>
        <li>
          <Link to={`/book/자바 정복`}>자바 정복</Link>
        </li>
        <li>
          <Link to={`/book/리액트 마스터`}>리액트 마스터</Link>
        </li>
        <li>
          <Link to={`/book/자바스트립트 교과서`}>자바스트립트 교과서</Link>
        </li>
      </ul>
    </div>
  );
};

export default Content;
