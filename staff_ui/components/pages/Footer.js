
import React from "react";
import { NavbarText } from "reactstrap";

const Footer = () => {
    return (
        <div style={{ position: "relative" }}>
            <nav className="navbar navbar-expand-sm fixed-bottom navbar-dark">

                <div className="container-fluid justify-content-center ">
                    <NavbarText className="text-dark fw-bold fs-0">

                        © 2022 EBugTracker | All Rights Reserved | Terms and Conditions apply

                    </NavbarText>
                </div>
            </nav>
        </div>
    );
};

export default Footer;




