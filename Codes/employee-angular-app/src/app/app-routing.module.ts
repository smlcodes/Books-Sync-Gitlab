import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { DeleteEmployeeComponent } from './delete-employee/delete-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';

const routes: Routes = [
  {path: '', component: EmployeeListComponent},
  {path: 'all', component: EmployeeListComponent},
  {path: 'add', component: AddEmployeeComponent},
  {path: 'view/:id', component: ViewEmployeeComponent},
  {path: 'update/:id', component: UpdateEmployeeComponent},
  {path: 'delete/:id', component: DeleteEmployeeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
