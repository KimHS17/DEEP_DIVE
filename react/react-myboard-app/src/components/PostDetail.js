import React, { useEffect, useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import ApiService from "../services/ApiService";

const PostDetail = () => {
  const { id } = useParams();
  const [post, setPost] = useState(null);
  const [password, setPassword] = useState("");
  const location = useLocation();

  useEffect(() => {
    fetchPostDetails(location.state.password);
  }, [id, location.state]);

  const fetchPostDetails = async (password) => {
    try {
      const response = await ApiService.fetchPostDetails(id, password);
      setPost(response.data);
    } catch (error) {
      console.error("Error fetching post details: ", error);
    }
  };

  if (!post) {
    return <div>Loading...</div>;
  }

  return (
    <div className="post-detail-container">
      <h2>{post.title}</h2>
    </div>
  );
};

export default PostDetail;
