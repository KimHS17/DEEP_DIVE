import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api";

const ApiService = {
  fetchPosts() {
    return axios.get(`${API_BASE_URL}/post/all`);
  },

  createPost(postData) {
    return axios.post(`${API_BASE_URL}/post`, postData);
  },

  fetchPostDetails(postId, password) {
    return axios.post(`${API_BASE_URL}/post/view`, {
      post_id: postId,
      password: password,
    });
  },
};

export default ApiService;
