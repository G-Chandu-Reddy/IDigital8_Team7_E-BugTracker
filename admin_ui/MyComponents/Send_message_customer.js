import { useEffect, useState } from 'react';
import axios from 'axios';
import { ToastContainer,toast } from 'react-toastify';

const SendMessage = () => {


    //Step 1.1-  Get Staff IDS for Dropdown List
    const [customerId, setCustomerId] = useState([]);

    const [Customer, setCustomer] = useState([]);
    const getAllCustomer = () => {
        axios.get(`http://localhost:9001/admin/findAllCustomer`).then(
            (response) => {
                setCustomer(response.data);
                //console.log(response.data)
            },
            (error) => {
                //for Error
                console.log(error);
            }
        );
    };

    // Step 1.2- Calling GetCustomer.()
    useEffect(() => {
        getAllCustomer();
        return () => {
        }
    }, [])

    //Step 2.1 Sending Message to Customer
    const [message, setMessage] = useState([]);

    const sendMessage = () => {
        const config = { headers: {'Content-Type': 'text/plain'} };
        axios.put(`http://localhost:9001/admin/sendMessage/${customerId.customerId}`,message,config).then(
            (response) => {
                console.log(response.data);
                toast.success('Message Sent !!', {
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

    //Step 2.2- put method from form
    const handleForm = (e) => {
        //console.log(Customer);
        sendMessage();
        e.preventDefault();

    }

    const getData = (val) => {
        setMessage(val.target.value);
    }


    return (
        <div className="container-sm">
            <form onSubmit={handleForm}>
                <div className="mb-3">
                    <label htmlFor="disabledSelect" className="form-label"><h3>Select Customer</h3></label>

                    <select id="disabledSelect" className="form-select" onClick={(e) => {
                        setCustomerId({ ...customerId, customerId: e.target.value })
                    }}>
                        {
                            Customer.map(
                                cust =>
                                    <option key={cust.customerId}>{cust.customerId}</option>
                            )
                        }

                    </select>

                </div>

                <div className="input-group mb-3">
                    <span className="input-group-text">Enter your text here</span>
                    <textarea className="form-control" onChange={getData}></textarea>
                </div>

                <br></br>
                <button type="submit" className="btn btn-primary"  >Submit</button>
            </form>
            <ToastContainer />
        </div>
    );
}

export default SendMessage;