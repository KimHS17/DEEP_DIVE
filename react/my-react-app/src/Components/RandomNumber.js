import React, { useState } from "react";

const random = {
  width: "20%",
  height: "300px",
  margin: "0 auto",
  marginTop: "200px",
  padding: "20px",
  border: "3px solid lightgray",
  backgroundColor: "lightyellow",
  borderRadius: "20px",
  textAlign: "center",
};

const btn = {
  width: "200px",
  height: "50px",
  backgroundColor: "lightblue",
  borderRadius: "10px",
  fontSize: "20px",
};

function RandomNumber(props) {
  const [num, setNum] = useState(0);
  return (
    <div style={random}>
      <h1>랜덤 숫자 생성</h1>
      <h5>1 ~ 10 사이의 숫자 생성</h5>
      <br></br>
      <h3>생성된 랜덤 숫자 : {num}</h3>
      <button
        style={btn}
        onClick={() => setNum(Math.floor(Math.random() * 10 + 1))}
      >
        랜덤 숫자 생성
      </button>
    </div>
  );
}

export default RandomNumber;
