import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class ViewEmployeeComponent extends Component {


    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            name: '',
            address: '',
            salary: 0
        };
    }




    componentDidMount() {
        EmployeeService.getEmployeeById(this.state.id).then((res) => {
            let employee = res.data;
            console.log("employee ::: " + employee);
            this.setState({
                name: employee.name,
                salary: employee.salary,
                address: employee.address
            });
        });
    }


    render() {
        return (
            <div>
                <br />
                <h2 className="text-center">View Employee ::</h2>

                <br></br>
                <div class="card">
                    <div class="card-body">
                    <div class="shadow-lg p-3 mb-5 bg-body rounded">
                        Id : {this.state.id}         <br/>
                        Name : {this.state.name}     <br/>
                        Address : {this.state.address}   <br/>
                        Salary : {this.state.salary}     <br/>
                    </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default ViewEmployeeComponent;