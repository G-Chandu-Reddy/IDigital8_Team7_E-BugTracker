import { useEffect, useState } from 'react';
import { ToastContainer,toast } from 'react-toastify';
import Staffservices from '../../Services/Staffservices';
import 'react-toastify/dist/ReactToastify.css';
const SendRemedy = () => {

    //Get Staff IDS for Dropdown List
    const [ticketNo, setTicketNo] = useState([]);

    const [Bug, setBug] = useState([]);
    const getAllBugs = () => {
        Staffservices.getAllBugs().then(
            (response) => {
                setBug(response.data);
                //console.log(response.data)
            },
            (error) => {
                //for Error
                console.log(error);
            }
        );
    };

    //Calling GetAllBugs.()
    useEffect(() => {
        getAllBugs();
        return () => {
        }
    }, [])

    //Setting Remedy to Bug
    const [remedy, setRemedy] = useState([]);

    const sendRemedy = () => {
       
        Staffservices.sendRemedy(ticketNo.ticketNo,remedy).then(
            (response) => {
                console.log(response.data);
                 toast('Remedy Sent !!', {
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
                //for Error
                console.log(error);
            }
        );
    };

    //put method from form
    const handleForm = (e) => {
        sendRemedy();
        e.preventDefault();

    }

    const getData = (val) => {
        setRemedy(val.target.value);
    }


    return (
        <div className="container-sm">
            <form onSubmit={handleForm}>
                <div className="mb-3">
                    <br></br>
                    <label htmlFor="disabledSelect" className="form-label"><h3>Select Ticket Id</h3></label>

                    <select id="disabledSelect" className="form-select" onClick={(e) => {
                        setTicketNo({ ...ticketNo, ticketNo: e.target.value })
                    }}>
                      
                        {
                            Bug.map(
                                bug =>
                                    <option key={bug.ticketNo}>{bug.ticketNo}</option>
                            )
                        }

                    </select>

                </div>

                <div className="input-group mb-3">
                    <span className="input-group-text">Enter your Remedy here</span>
                    <textarea className="form-control" onChange={getData}></textarea>
                </div>

                <br></br>
                <button type="submit" className="btn btn-primary"  >Submit</button>
            </form>
            <ToastContainer />
        </div>
    );
}

export default SendRemedy;