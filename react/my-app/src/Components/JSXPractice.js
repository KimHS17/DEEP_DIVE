import React from "react";

function JSXPractice() {
  const name = "React Learner";
  const isLoggedIn = true;
  const numbers = [1, 2, 3, 4, 5];

  function handleClick() {
    alert("버튼이 클릭!");
  }

  // 사용자 환영 메시지를 반환하는 함수
  function getGreeting(user) {
    if (user) {
      return <h2>Hello, {user}!</h2>;
    }
    return <h2>Hello, Stranger.</h2>;
  }

  return (
    <div>
      <h1>JSX 실습</h1>
      <p>Welcome, {name}!</p>

      {isLoggedIn ? <p>로그인 되었습니다.</p> : <p>로그인이 필요합니다.</p>}

      <ul>
        {numbers.map((number) => (
          <li key={number}>{number}</li>
        ))}
      </ul>

      <button onClick={handleClick}>Click me</button>

      {getGreeting("JSX Learner")}
      {getGreeting()}

      <h1>{<script>alert("Hacked!")</script>}</h1>
    </div>
  );
}

export default JSXPractice;
