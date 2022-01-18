import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Viewbugs from "./pages/Viewbugs";   
import Assigntask from "./pages/Assigntask"; 
import Remedy from "./pages/Remedy";  
import Header from "./pages/Header";  
import "./App.css";
import Footer from "./pages/Footer";
//import "./Footer.css"; 

const App = () => {
  return (
    <div className=" background">
      <Router>
        <Header />
       <Routes>
          <Route path="/viewbugs" element={<Viewbugs />} />
          <Route path="/assigntask" element={<Assigntask />} />
          <Route path="/remedy" element={<Remedy />} />
      </Routes> 
      <Footer />
      </Router>
    </div>
  );
}

export default App;

