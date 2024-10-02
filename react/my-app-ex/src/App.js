import "./App.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./Component/Header";
import Sidebar from "./Component/Sidebar";
import FeaturedSection from "./Component/FeaturedSection";
import Footer from "./Component/Footer";

function App() {
  return (
    <>
      <div><Header /></div>
      <div style={{ width: "10%" }}><Sidebar /></div>
      <br></br>
      <div><FeaturedSection /></div>
      <div style={{ height: "450px"}}></div>
      <div><Footer /></div>
    </>
  );
}

export default App;
