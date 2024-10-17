import React from "react";
import { useLocation, useParams } from "react-router-dom";

const Product = () => {
  const { productId } = useParams();
  const location = useLocation();

  // http://localhost:3000/product/1?search=productName&q=demo#test

  return (
    <div>
      <h2>{productId}번 상품의 상품 페이지입니다.</h2>
      <ul>
        <li>pathname: {location.pathname}</li>
        <li>search: {location.search}</li>
        <li>hash: {location.hash}</li>
        <li>state: {location.state}</li>
        <li>key: {location.key}</li>
      </ul>
    </div>
  );
};

export default Product;
