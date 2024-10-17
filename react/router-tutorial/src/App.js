import React from "react";
import { Link, Route, Routes } from "react-router-dom";
import Home from "./Components/Home";
import About from "./Components/About";
import PageNotFound from "./Components/PageNotFound";
import Product from "./Components/Product";
import Product2 from "./Components/Product2";
import Product3 from "./Components/Product3";

const App = () => {
  return (
    <div>
      <nav>
        <Link to="/">Home</Link> <Link to="about">About</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="about" element={<About />} />
        <Route path="/product/:productId" element={<Product />} />
        <Route path="/product2/:productId" element={<Product2 />} />
        <Route path="/product3/:productId" element={<Product3 />} />
        {/* 상단에 위치하는 라우트들의 규칮을 모두 확인, 일치하는 라우트가 없는 경우 처리 */}
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </div>
  );
};

export default App;
