import React from "react";
import { useNavigate, useParams } from "react-router-dom";

const Product3 = () => {
  const { productId } = useParams();
  const navigate = useNavigate();

  // http://localhost:3000/product3/1

  return (
    <div>
      <h2>{productId}번 상품의 상품 페이지입니다.</h2>
      <ul>
        <li>
          <button onClick={() => navigate(-2)}>Go 2 pages back</button>
        </li>
        <li>
          <button onClick={() => navigate(-1)}>Go back</button>
        </li>
        <li>
          <button onClick={() => navigate(1)}>Go forward</button>
        </li>
        <li>
          <button onClick={() => navigate(2)}>Go 2 pages forward</button>
        </li>
        <li>
          <button onClick={() => navigate("/")}>Go Home</button>
        </li>
        <li>
          <button onClick={() => navigate("/", { replace: true })}>
            Go Home (History X)
          </button>
        </li>
        <li>
          <button onClick={() => navigate("/product3/10")}>
            10번 상품 페이지로 이동
          </button>
        </li>
      </ul>
    </div>
  );
};

export default Product3;
