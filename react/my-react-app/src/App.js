import React from "react";
import Welcome from "./Components/Welcome";
import Clock from "./Components/Clock";
import Counter from "./Components/Counter";
import RandomNumber from "./Components/RandomNumber";

function App() {
  return (
    <div>
      {/* <h1>React 기본 예제</h1>
      <Welcome name="Sara" />
      <Welcome name="홍길동" />
      <hr></hr>
      <Clock />
      <hr></hr>
      <Counter /> */}
      <RandomNumber />
    </div>
  );
}

export default App;
