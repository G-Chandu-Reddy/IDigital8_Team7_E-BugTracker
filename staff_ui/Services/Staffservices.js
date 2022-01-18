import axios from 'axios';

const STAFFS_REST_API_URL = "http://localhost:9003/staff";

class Staffservices {


    findStaffById(staffId) {
        return axios.get(STAFFS_REST_API_URL + "/findStaffById/" + staffId);
    }

    getAllStaffs() {
        return axios.get(STAFFS_REST_API_URL + "/findAllStaffs");
    }

    getAllBugs() {
        return axios.get(STAFFS_REST_API_URL + "/getAllBugs");
    }

    sendRemedy(ticketNo, remedy) {
        const config = { headers: { 'Content-Type': 'text/plain' } };
        return axios.put(STAFFS_REST_API_URL + "/provideBugRemedy/" + ticketNo, remedy, config);
    }

    assignWork(assignWork) {
        return axios.post(STAFFS_REST_API_URL + "/assign/" + assignWork.staffId + "/" + assignWork.assignedTicketIds);
    }
}
export default new Staffservices();