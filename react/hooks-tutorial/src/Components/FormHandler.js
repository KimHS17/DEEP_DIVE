import React, { useReducer, useEffect } from "react";

function reducer(state, action) {
  return {
    ...state,
    [action.name]: action.value,
  };
}

const FormHandler = () => {
  // 여기에 useReducer와 useEffect 코드를 작성하세요
  const [state, dispatch] = useReducer(reducer, { name: "", email: "" });

  useEffect(() => {
    setTimeout(() => {
      console.log("데이터 로딩 완료");
    }, 2000);
  }, []);

  useEffect(() => {
    console.log("name: ", state.name, ", email: ", state.email);
  });

  const onChange = (e) => {
    dispatch(e.target);
  };

  const onClick = () => {
    dispatch({ name: "name", value: "" });
    dispatch({ name: "email", value: "" });
    alert("초기화 되었습니다.");
  };

  return (
    <div>
      <input
        name="name"
        placeholder="이름"
        onChange={onChange}
        value={state.name}
      />
      <input
        name="email"
        placeholder="이메일"
        onChange={onChange}
        value={state.email}
      />
      <button onClick={onClick}>초기화</button>
    </div>
  );
};

export default FormHandler;
