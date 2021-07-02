	
import axios from 'axios';
const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/";
class EmployeeService {
    getEmployees() {
        return axios.get(EMPLOYEE_API_BASE_URL+'all');
    }

    addEmployee(employee) {
        return axios.post(EMPLOYEE_API_BASE_URL+'addEmployee', employee);
    }

    updateEmployee(employee, id){
        console.log("EmployeeService :: updateEmployee :: "+JSON.stringify(employee));
        let emp =  axios.put(EMPLOYEE_API_BASE_URL + 'updateEmployee/' + id, employee);
        console.log("updateEmployee :: RESPONCSE :: "+JSON.stringify(emp));
        return emp;
    }

    getEmployeeById(id) {
        return axios.get(EMPLOYEE_API_BASE_URL+'getEmployee/' + id);
    }

    deleteEmployee(id){
        console.log("EmployeeService :: deleteEmployee :: "+id);
        let emp =  axios.delete(EMPLOYEE_API_BASE_URL + 'deleteEmployee/' + id);
        console.log("Deleted  :: RESPONCSE :: "+emp);
        return emp;
    }


}
export default new EmployeeService()