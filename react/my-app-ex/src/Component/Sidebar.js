import React from "react";
import ListGroup from "react-bootstrap/ListGroup";

function Sidebar() {
  return (
    <ListGroup as="ul">
      <ListGroup.Item as="li" active>
        Menu 1
      </ListGroup.Item>
      <ListGroup.Item as="li">Menu 2</ListGroup.Item>
      <ListGroup.Item as="li">Menu 3</ListGroup.Item>
      <ListGroup.Item as="li">Menu 4</ListGroup.Item>
    </ListGroup>
  );
}

export default Sidebar;
