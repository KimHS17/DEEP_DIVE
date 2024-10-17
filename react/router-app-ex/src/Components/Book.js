import React from "react";
import { useParams } from "react-router-dom";

const Book = () => {
  const { title } = useParams();

  const books = [
    {
      title: "자바 정복",
      author: "홍길동",
      publisher: "출판사1",
      published: "2021-01-01",
      price: "30000",
    },
    {
      title: "리액트 마스터",
      author: "김영희",
      publisher: "출판사2",
      published: "2022-02-02",
      price: "25000",
    },
    {
      title: "자바스트립트 교과서",
      author: "박철수",
      publisher: "출판사3",
      published: "2023-03-03",
      price: "18000",
    },
  ];

  const book = books.find((book) => book.title === title);

  return (
    <div>
      <h2>도서 정보</h2>
      {book ? (
        <ul>
          <li>도서명 : {book.title}</li>
          <li>저자 : {book.author}</li>
          <li>출판사 : {book.publisher}</li>
          <li>출판일 : {book.published}</li>
          <li>가격 : {book.price}</li>
        </ul>
      ) : (
        <p>도서를 찾을 수 없습니다.</p>
      )}
    </div>
  );
};

export default Book;
