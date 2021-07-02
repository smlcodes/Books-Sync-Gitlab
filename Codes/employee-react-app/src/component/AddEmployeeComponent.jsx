import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class AddEmployeeComponent extends Component {


    constructor(props) {
        super(props);
        this.state = {
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


    saveEmployee = (e) =>{
        e.preventDefault();
        let employee = {
            name: this.state.name, 
            address: this.state.address, 
            salary: this.state.salary
        };
        console.log('employee => ' + JSON.stringify(employee));

        EmployeeService.addEmployee(employee).then(res =>{
            this.props.history.push('/all');
        });

        
    }







    render() {
        return (
            <div>
                <br />
                <h2 className="text-center">Add Employee </h2>

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
                                    <button type="button" class="btn btn-primary" onClick={this.saveEmployee.bind(this)}>Add Employee</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default AddEmployeeComponent;