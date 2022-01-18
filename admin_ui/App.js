import Header from './MyComponents/Header';
import Footer from './MyComponents/Footer';

import './App.css';
import Viewbugs from './MyComponents/Viewbugs';
import Viewstaff from './MyComponents/Viewstaff';
import Send_message_customer from './MyComponents/Send_message_customer';
import Assignwork from './MyComponents/Assignwork';
import {
  Routes,
  Route
} from "react-router-dom";

function App() {
  return (
    <div className="App">
     
        <Header />
      <br></br>
     <Routes>
      <Route path="viewBugs" element={<Viewbugs />} />
      <Route path="assignWork" element={<Assignwork />} />
      <Route path="Send_message_customer" element={<Send_message_customer />} />
      <Route path="viewStaff" element={<Viewstaff />} />
    </Routes>

    <br></br>
    <Footer/>
    </div>
  );
}

export default App;
