import React, { Component } from "react";

// 클래스형 컴포넌트 사용 : rcc 스니펫 사용
// 생명 주기 메서드 사용
// 매초 시계 업데이트

class Clock extends Component {
  constructor(props) {
    super(props);
    this.state = { date: new Date() };
  }

  componentDidMount() {
    this.timerID = setInterval(() => this.tick(), 1000);
  }
  componentWillUnmount() {
    clearInterval(this.timerID);
  }

  tick() {
    this.setState({
      date: new Date(),
    });
  }

  render() {
    return (
      <div>
        <h2>현재 시간 : {this.state.date.toLocaleTimeString()}</h2>
      </div>
    );
  }
}

export default Clock;
