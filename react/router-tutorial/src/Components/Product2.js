import React from "react";
import { useParams, useSearchParams } from "react-router-dom";

const Product2 = () => {
  const { productId } = useParams();
  const [searchParams, setSearchParams] = useSearchParams();
  const keyWords = searchParams;
  const keyWord1 = searchParams.get("search");
  const keyWord2 = searchParams.get("q");

  // http://localhost:3000/product2/1?search=productName&q=demo#test

  return (
    <div>
      <h2>{productId}번 상품의 상품 페이지입니다.</h2>
      <ul>
        <li>keyWords : {keyWords}</li>
        <li>search keyWord : {keyWord1}</li>
        <li>q keyWord : {keyWord2}</li>
      </ul>
    </div>
  );
};

export default Product2;
