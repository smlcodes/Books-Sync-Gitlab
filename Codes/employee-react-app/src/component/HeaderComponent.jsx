import React, { Component } from 'react';

class HeaderComponent extends Component {
    render() {
        return (
            <div>
                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="/"><h3>EmployeeServices™</h3> </a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/addEmployee">Add Employee</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/all">All Employees</a>
                                </li> 
                            </ul>
                        </div>
                    </div>
                </nav>

            </div>
        );
    }
}

export default HeaderComponent;