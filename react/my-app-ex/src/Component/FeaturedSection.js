import React from "react";
import Card from "react-bootstrap/Card";

function FeaturedSection() {
  return (
    <Card style={{ width: "25rem" }}>
      <Card.Body>
        <Card.Title>Lorem Ipsum</Card.Title>
        <Card.Subtitle className="mb-2 text-muted">
          What is Lorem Ipsum?
        </Card.Subtitle>
        <Card.Text>
          Lorem Ipsum is simply dummy text of the printing and typesetting
          industry. Lorem Ipsum has been the industry's standard dummy text ever
          since the 1500s, when an unknown printer took a galley of type and
          scrambled it to make a type specimen book.
        </Card.Text>
      </Card.Body>
    </Card>
  );
}

export default FeaturedSection;
