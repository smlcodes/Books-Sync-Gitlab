import React, { Component } from 'react';

class HomeComponent extends Component {
    render() {
        return (
            <div><br/>
                <div class="card">
                    <div class="card-body">
                        <div class="d-grid gap-2 col-6 mx-auto">
                            <a class="btn btn-primary" href="/">Home</a>
                            <a class="btn btn-primary" href="/viewEmployee/101">Get Employee</a>
                            <a class="btn btn-primary" href="/addEmployee">Add Employee</a>
                            <a class="btn btn-primary" href="/editEmployee/102">Update Employee</a>
                            <a class="btn btn-primary" href="/all">All Employees</a>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default HomeComponent;