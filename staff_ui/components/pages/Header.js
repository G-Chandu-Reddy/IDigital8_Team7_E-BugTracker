import React from "react";
import { NavLink } from "react-router-dom";
const Header = () => {
  return (

    <nav className="navbar navbar-expand-lg navbar-dark bg-dark w-100">
      <div className="container-fluid">
        <NavLink className="navbar-brand" to="#">Staff Portal</NavLink>

        <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent" style={{
          display: "flex",
          justifyContent: "right",
          alignItems: "right",
        }}>

          <ul className="navbar-nav ml-auto mb-12 mb-lg-0">

            <li className="nav-item">
              <NavLink activeClassName='menu_active' className="nav-link" to="/viewbugs">View Bugs</NavLink>
            </li>
            <li className="nav-item">
              <NavLink activeClassName='menu_active' className="nav-link" to="/assigntask">Assign Task</NavLink>
            </li>
            <li className="nav-item">
              <NavLink activeClassName='menu_active' className="nav-link" to="/remedy">Send Remedy</NavLink>
            </li>
            <form className="d-flex">

              <button className="btn btn-outline-success" type="submit">Log out</button>
            </form>
          </ul>


        </div>
      </div>
    </nav>
    /* </nav>  */

  );
};

export default Header;