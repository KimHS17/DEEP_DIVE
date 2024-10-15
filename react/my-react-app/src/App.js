import React from "react";
import Welcome from "./Components/Welcome";
import Clock from "./Components/Clock";
import Counter from "./Components/Counter";
import RandomNumber from "./Components/RandomNumber";
import Toggle from "./Components/Toggle";
import EventPractice from "./Components/EventPractice";
import EventPractice2 from "./Components/EventPractice2";
import SelectPopup from "./Components/SelectPopup";
import InputCompare from "./Components/InputCompare";

function App() {
  return (
    <div>
      <h1>React 기본 예제</h1>
      {/* <EventPractice /> */}
      <EventPractice2 />
      <hr></hr>
      <SelectPopup />
      <hr></hr>
      <Toggle />
      <hr></hr>
      <Welcome name="Sara" />
      <Welcome name="홍길동" />
      <hr></hr>
      <Clock />
      <hr></hr>
      <Counter />
      {/* <RandomNumber /> */}
      {/* <InputCompare /> */}
    </div>
  );
}

export default App;
