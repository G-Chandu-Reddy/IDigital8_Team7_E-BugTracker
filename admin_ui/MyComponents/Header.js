import {Link} from "react-router-dom";

const header=()=>{
    return(
      <div>
        <nav className="navbar navbar-dark bg-dark">
  <div className="container-fluid">
    <a className="navbar-brand" href="#"><h2>Admin Portal</h2></a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
        <Link className="nav-link active" to ="/Viewbugs">View Bugs</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" to ="/Assignwork">Assign Work</Link>
        </li>
        
        <li className="nav-item">
        <Link className="nav-link active" to ="/Send_message_customer">Send Message</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" to ="/viewStaff">View Staff</Link>
        </li>
        <li className="nav-item">
        <button className="btn btn-outline-danger" type="submit">Log Out</button>
        </li>
      </ul>
      
      <form className="d-flex">1
        
      
      </form>
    </div>
  </div>
</nav>
</div>

    );
}

export default header;