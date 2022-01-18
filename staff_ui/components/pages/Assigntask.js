import { useEffect, useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';

import 'react-toastify/dist/ReactToastify.css';
import Staffservices from "../../Services/Staffservices";

const AssignWork = () => {

    //Get Staff IDS for Dropdown List
    const [Staff, setStaff] = useState([]);

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

    //Calling Ticket IDs for Dropdown List
    const [bugs, setBugs] = useState([]);

    const getAllBugs = () => {
        Staffservices.getAllBugs().then(
            (response) => {
                setBugs(response.data);
            },
            (error) => {
                //for Error
                console.log(error);
            }
        );
    };

    //Calling Functions for Ticket listing
    useEffect(() => {
        getAllBugs();
        return () => {
        }
    }, [])

    //Assigning respective Tickets to Staffs
    //Form Handler Function    

    const [assignWork, setAssignWork] = useState({});

    const handleForm = (e) => {
        console.log(assignWork);
        postDataServer(assignWork);
        e.preventDefault();

    }

    const postDataServer = (data) => {
        Staffservices.assignWork(assignWork).then(
            (response) => {
                console.log("Success");
                toast('Bug is assigned successfully !!', {
                    position: "top-center",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                });
            },
            (error) => {
                console.log("error");
            }

        );
    };

    return (
        <div className="container-sm">
            <form onSubmit={handleForm}>
                <div className="mb-3">
                    <br></br>
                    <label htmlFor="disabledSelect" className="form-label"><h3>Select Staff</h3></label>

                    <select id="disabledSelect" className="form-select" onClick={(e) => {
                        setAssignWork({ ...assignWork, staffId: e.target.value })
                    }} >

                        {Staff.map(
                            staff =>
                                <option key={staff.staffId} >{staff.staffId}</option>
                        )}
                    </select>

                </div>

                <div className="mb-3">
                    <label htmlFor="disabledSelect" className="form-label"><h3>Select Ticket No.</h3></label>
                    <select id="disabledSelect" className="form-select" onClick={(e) => {
                        setAssignWork({ ...assignWork, assignedTicketIds: e.target.value })
                    }}>
                        {
                            bugs.map(
                                bug =>
                                    <option key={bug.ticketNo} >{bug.ticketNo}</option>
                            )
                        }
                    </select>
                </div>
                <button type="submit" className="btn btn-primary" >Submit</button>
            </form>
            <ToastContainer />
        </div>

    );
}

export default AssignWork;