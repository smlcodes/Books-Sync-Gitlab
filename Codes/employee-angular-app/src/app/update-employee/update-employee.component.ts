import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(
    private employeeService: EmployeeService,
    private route: Router,
    private activatedRoute : ActivatedRoute
  ) {}


  employee: Employee = new Employee();
  id!: number;

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data =>{
      this.employee = data;
    });
  }


  updateFormSumbit() {
    console.log(JSON.stringify(this.employee));

    //=====> 1. Calling SpringBoot Save Service method
    this.employeeService.updateEmployee(this.id,this.employee).subscribe(
      (data) => {
        console.log('Data Updated : ' + data);
      },
      (error) => {
        console.log('Updated failed  : ' + error);
      }
    );

    //=====>2. Once Save Done, Reditect to employeeList page
    this.route.navigate(['/all']);
  }
}
