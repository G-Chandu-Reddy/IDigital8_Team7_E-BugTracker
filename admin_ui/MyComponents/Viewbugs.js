import axios from 'axios';
import { toast, ToastContainer } from 'react-toastify';
import { useEffect, useState} from 'react';

const ViewBugs = () => {

  const[bugs,setBugs]=useState([]);

  //Function Call to server:
  const getAllBugs =()=>{
      axios.get(`http://localhost:9001/admin/bugReport`).then(
        (response)=>{
          //Success
          //console.log(response.data)
          toast.success('Bugs has been Loaded', {
            position: "bottom-center",
            autoClose: 2500,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            });
          setBugs(response.data);
        },
        (error)=>{
          //for Error
          console.log(error);
        }
      );
  };

  //calling Loading Bugs Fun

  useEffect(() => {
    getAllBugs();
    return () => {
    }
  }, [])



  return (

      <div className='container-fluid'>
        <table className="table table-dark table-striped">
          <thead>
            <tr>
              <th scope="col">Ticket no.</th>
              <th scope="col">Priority Level</th>
              <th scope="col">Snippet</th>
              {/* //<th scope="col">Remedy</th> */}
              <th scope="col">Assigned Department</th>
            </tr>
          </thead>
          <tbody>
          {  

             bugs.map(
              bug =>
              <tr key = {bug.ticketNo}>
                <td>{bug.ticketNo}</td>
                <td>{bug.bugPriority}</td>
                <td>{bug.snippet}</td>
                {/* <td>{bug.remedy}</td> */}
                <td>{bug.relatedDepartment}</td>
              </tr>
            )
          }
          </tbody>
        </table>
        <ToastContainer/>
      </div>

  );
}

export default ViewBugs;