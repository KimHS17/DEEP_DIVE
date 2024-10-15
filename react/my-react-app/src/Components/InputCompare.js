import React, { useState } from "react";

const InputCompare = () => {
  const [form, setForm] = useState({
    text1: "",
    text2: "",
  });

  const { text1, text2 } = form;

  const onChange = (e) => {
    const nextForm = {
      ...form,
      [e.target.name]: e.target.value,
    };
    setForm(nextForm);
  };

  const onClick = () => {
    const message = text1 == text2 ? "일치합니다." : "일치하지 않습니다.";
    alert(message);
    setForm({
      text1: "",
      text2: "",
    });
  };

  const onKeyPress = (e) => {
    if (e.key === "Enter") {
      onClick();
    }
  };

  return (
    <div>
      <input
        type="text"
        name="text1"
        placeholder="text1"
        value={text1}
        onChange={onChange}
        onKeyUp={onKeyPress}
      />
      <input
        type="text"
        name="text2"
        placeholder="text2"
        value={text2}
        onChange={onChange}
        onKeyUp={onKeyPress}
      />
      <br />
      <button onClick={onClick}>확인</button>
    </div>
  );
};

export default InputCompare;
