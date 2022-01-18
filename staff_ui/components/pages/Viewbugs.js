import React, { useEffect, useState } from "react";
import Staffservices from "../../Services/Staffservices";

const ViewBugs = () => {
  const [assignedTicketIds, setAssignedTicketIds] = useState([]);
  const [Staff, setStaff] = useState([]);
  const [staffId, setStaffId] = useState([]);

  //Get Staff IDS for Dropdown List
  const getAllStaff = () => {
    Staffservices.getAllStaffs().then(
      (response) => {
        setStaff(response.data);
      },
      (error) => {
        //for Error
        console.log(error);
      }
    );
  };

  //Calling GetstaffIds.()
  useEffect(() => {
    getAllStaff();
    return () => {
    }
  }, [])

   //Getting Assigned ticket Ids for staff
  //Form Submit Function   
  const handleSubmit = () => {

    Staffservices.findStaffById(staffId)
      .then((response) => {
        setAssignedTicketIds(response.data.assignedTicketIds);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div>
      <div className="container-sm">
        <div className="col-md-4 col-10 mx-auto">
          <div className="mb-3">
            <br></br>
            <label><h3>Staff Id</h3></label>

            <select id="disabledSelect" className="form-select" onClick={(e) => {
              setStaffId(e.target.value)
            }}>
              {
                Staff.map(
                  staff =>
                    <option key={staff.staffId}>{staff.staffId}</option>
                )
              }

            </select>

          </div>

          <button className="btn btn-primary " onClick={handleSubmit}>
            Submit
          </button>

          <br></br>
          <br></br>

          <div className="mb-3">
            <label htmlFor="exampleFormControlTextarea1" className="form-label">
              <h4>View Assigned Bug Ticket Numbers</h4>
            </label>
            <div
              style={{
                backgroundColor: "white",
                height: "150px",
                width: "250px",
              }}
            >
              <p>{assignedTicketIds && `${assignedTicketIds}`}</p>
            </div>

          </div>
        </div>
      </div>
    </div>
  );
};

export default ViewBugs;