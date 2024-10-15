import React, { useState } from "react";

function SelectPopup(props) {
  const [selectedDrink, setSelectedDrink] = useState("americano");
  const [showPopup, setShowPopup] = useState(false);

  const handleSelectChange = (e) => {
    setSelectedDrink(e.target.value);
  };

  const togglePopup = (e) => {
    setShowPopup(!showPopup);
  };

  return (
    <div>
      <h2>Select & Popup</h2>
      {/* Select dropdown */}
      <select value={selectedDrink} onChange={handleSelectChange}>
        <option value="americano">아메리카노</option>
        <option value="caffe latte">카페라테</option>
        <option value="cafe au lait">카페오레</option>
        <option value="espresso">에스프레소</option>
      </select>
      <h3>선택된 음료: {selectedDrink}</h3>

      {/* Popup 열기 버튼 */}
      <button onClick={togglePopup}>
        {showPopup ? "팝업 닫기" : "팝업 열기"}
      </button>

      {/* Popup */}
      {showPopup ? (
        <div className="popup">
          <div className="popup_inner">
            <h2>팝업이 열렸습니다!</h2>
            <button onClick={togglePopup}>닫기</button>
          </div>
        </div>
      ) : null}
    </div>
  );
}

export default SelectPopup;
