import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class ListAllEmployeesComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            employees: []
        }

        
        this.editEmployee = this.editEmployee.bind(this); 

    }


    componentDidMount() {
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data });
        });
    }


        
    viewEmployee(id){
        this.props.history.push(`/viewEmployee/${id}`);
    }

    editEmployee(id){
        this.props.history.push(`/editEmployee/${id}`);
    }

    deleteEmployee(id){
        this.props.history.push(`/deleteEmployee/${id}`);
    }



  

    render() {
        return (
            <div>
                <br />
                <h2 className="text-center">Employees List</h2>

                <br></br>
                <div className="row">
                    <table id="example" className="table table-striped table-bordered" style={{ 'width': '100%' }}>
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
                                        <tr key={employee.id}>
                                            <td> {employee.id} </td>
                                            <td> {employee.name} </td>
                                            <td> {employee.address}</td>
                                            <td> {employee.salary}</td>
                                            <td>
                                                <button class="btn btn-primary" onClick={() => this.viewEmployee(employee.id)}  ><i class="fas fa-eye" ></i> </button> <span>&nbsp;</span>
                                                <button class="btn btn-warning" onClick={() => this.editEmployee(employee.id)}  ><i class="fas fa-edit" ></i> </button> <span>&nbsp;</span>
                                                <button class="btn btn-danger" onClick={() => this.deleteEmployee(employee.id)} ><i class="fas fa-trash-alt"></i> </button> 
                                                
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>

        );
    }
}

export default ListAllEmployeesComponent;