import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class ListAllEmployeesComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
                employees: []
        }
       
    }


    componentDidMount(){
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data});
        });
    }


    render() {
        return (
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                                {
                                    this.state.employees.map(
                                        employee => 
                                        <tr key = {employee.id}>
                                            
                                             <td> {employee.name} </td>   
                                             <td> {employee.address}</td>
                                             <td> {employee.salary}</td>
                                             <td>
                                                 Action
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                </table>
            </div>
        );
    }
}

export default ListAllEmployeesComponent;