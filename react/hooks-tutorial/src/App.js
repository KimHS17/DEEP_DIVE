import React from "react";
import Counter from "./Components/Counter";
import Info from "./Components/Info";
import Average from "./Components/Average";

const App = () => {
  return (
    <div>
      <Average />
      <hr></hr>
      <Counter />
      <hr></hr>
      <Info />
    </div>
  );
};

export default App;
