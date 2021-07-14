import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css'],
})
export class AddEmployeeComponent implements OnInit {
  constructor(
    private employeeService: EmployeeService,
    private route: Router
  ) {}

  employee: Employee = new Employee();

  ngOnInit(): void {}

  addFormSumbit() {
    console.log(JSON.stringify(this.employee));

    //=====> 1. Calling SpringBoot Save Service method
    this.employeeService.createEmployee(this.employee).subscribe(
      (data) => {
        console.log('Data Saved : ' + data);
      },
      (error) => {
        console.log('Save failed  : ' + error);
      }
    );

    //=====>2. Once Save Done, Reditect to employeeList page
    this.route.navigate(['/all']);
  }
}
