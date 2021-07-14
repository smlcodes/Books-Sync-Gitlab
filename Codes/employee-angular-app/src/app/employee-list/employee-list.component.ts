import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

//1.Imported EmployeeService
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  //List of emplyee objects created, initilaized to EMpty.
  employeeList!: Employee[];

  //2. Created EmployeeService Object to call methods
  constructor(private employeeService: EmployeeService) {}

  //3.at the time of initilaizing calling getEmployees
  ngOnInit(): void {
    this.getEmployees();
  }

  //4.Finally, employeeList object contains all empdata coming from SpringBoot
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe((data) => {
      this.employeeList = data;
    });
  }
}
