import { useEffect, useState } from 'react';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';

const AssignWork = () => {

    //Step 1.1-  Get Staff IDS for Dropdown List
    const [Staff, setStaff] = useState([]);
    
    const getAllStaff = () => {
        axios.get(`http://localhost:9001/admin/findAllStaff`).then(
            (response) => {
                setStaff(response.data);
                //console.log(response.data)
            },
            (error) => {
                //for Error
                console.log(error);
            }
        );
    };

    // Step 1.2- Calling GetstaffIds.()
    useEffect(() => {
        getAllStaff();
        return () => {
        }
    }, [])

    //Step 2.1 - Calling Ticket IDs for Dropdown List
    const [bugs, setBugs] = useState([]);

    const getAllBugs = () => {
        axios.get(`http://localhost:9001/admin/bugReport`).then(
            (response) => {
                setBugs(response.data);
            },
            (error) => {
                //for Error
                console.log(error);
            }
        );
    };

    //Step 2.2- Calling Functions for Ticket listing
    useEffect(() => {
        getAllBugs();
        return () => {
        }
    }, [])

    // Step 3 - Assigning respective Tickets to Bugs
    //Form Handler Function    

    const [assignWork, setAssignWork] = useState({});

    const handleForm = (e) => {
        console.log(assignWork);
        postDataServer(assignWork);
        e.preventDefault();
        
    }

    const postDataServer = (data) =>{
       axios.post(`http://localhost:9001/admin/assign/${assignWork.staffId}/${assignWork.assignedTicketIds}`).then(
           (response) => {
               console.log("Success");
               toast.success('Bug is assigned successfully !!', {
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
            <ToastContainer/>
        </div>

    );
}

export default AssignWork;