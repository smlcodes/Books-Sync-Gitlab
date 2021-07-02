import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class DeleteEmployeeComponent extends Component {


    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id, 
            status:''
        }; 
    }


    componentDidMount(){
        EmployeeService.deleteEmployee(this.state.id).then( (res) =>{
            this.props.history.push('/all');
        });
    } 






    render() {
        return (
            <div>
                <br />
                <br />
                <h2 className="text-center"> Deleted Success : {this.state.status} </h2>

            </div>
        );
    }
}

export default DeleteEmployeeComponent;