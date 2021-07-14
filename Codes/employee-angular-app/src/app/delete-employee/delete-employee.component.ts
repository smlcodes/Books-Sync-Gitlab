import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

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


  deleteFormSumbit() {
    console.log(JSON.stringify(this.employee));

    //=====> 1. Calling SpringBoot Save Service method
    this.employeeService.deleteEmployee(this.id).subscribe(
      (data) => {
        console.log('Data Deleted : ' + data);
      },
      (error) => {
        console.log('Deletion failed  : ' + error);
      }
    );

    //=====>2. Once Save Done, Reditect to employeeList page
    this.route.navigate(['/all']);
  }
}
