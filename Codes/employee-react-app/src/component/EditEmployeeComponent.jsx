import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class EditEmployeeComponent extends Component {


    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            name: '',
            address: '',
            salary: 0
        };

        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.changeSalaryHandler = this.changeSalaryHandler.bind(this);
    }


    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeAddressHandler= (event) => {
        this.setState({address: event.target.value});
    }

    changeSalaryHandler= (event) => {
        this.setState({salary: event.target.value});
    }


    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
            let employee = res.data;
            console.log("employee ::: "+employee);
            this.setState({
                name: employee.name,
                salary: employee.salary,
                address : employee.address
            });
        });
    }

    updateEmployee = (e) =>{
        e.preventDefault();
        let employee = {
            name: this.state.name, 
            address: this.state.address, 
            salary: this.state.salary
        };
        console.log('employee => ' + JSON.stringify(employee));
        console.log('id => ' + JSON.stringify(this.state.id));

        EmployeeService.updateEmployee(employee, this.state.id).then(res =>{
            this.props.history.push('/all');
        });

        
    }







    render() {
        return (
            <div>
                <br />
                <h2 className="text-center">Edit Employee </h2>

                <br></br>
                <div className="row">
                    <div className="col-md-3"></div>
                    <div className="col-md-6">
                        <form>

                            <div class="row mb-3">
                                <label for="name" class="col-sm-2 col-form-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="name" value={this.state.name} onChange={this.changeNameHandler}/>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label for="address" class="col-sm-2 col-form-label">Address</label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" name="address" value={this.state.address} onChange={this.changeAddressHandler}/>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label for="salary" class="col-sm-2 col-form-label">Salary</label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" name="salary" value={this.state.salary} onChange={this.changeSalaryHandler}/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="salary" class="col-sm-2 col-form-label"></label>
                                <div class="col-sm-8">
                                    <button type="button" class="btn btn-primary" onClick={this.updateEmployee.bind(this)}>Update Employee</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default EditEmployeeComponent;