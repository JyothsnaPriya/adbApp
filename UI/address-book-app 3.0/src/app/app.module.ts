import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule,Routes} from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { DashboardComponent } from './component/dashboard/dashboard.component';
import { GenderCountPipe } from './pipe/gender-count.pipe';
import { FullNamePipe } from './pipe/full-name.pipe';
import { AdjustLengthPipe } from './pipe/adjust-length.pipe';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { EmployeeDetailsComponent } from './component/employee-details/employee-details.component';

import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { DeleteEmployeeComponent } from './component/delete-employee/delete-employee.component'
import { EmployeeFormComponent } from './component/employee-form/employee-form.component';
import { DeptCountPipe } from './pipe/dept-count.pipe';


const paths : Routes =[
  {path:'',component:DashboardComponent},
  {path:'listEmployees',component:EmployeeListComponent},
  {path:'addEmployee',component:EmployeeFormComponent},
  {path:'editEmployee/:id',component:EmployeeFormComponent},
  {path:'viewEmployee/:id',component:EmployeeDetailsComponent},
  {path:'delEmployee/:id',component:DeleteEmployeeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    GenderCountPipe,
    FullNamePipe,
    AdjustLengthPipe,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    DeleteEmployeeComponent,
    EmployeeFormComponent,
    DeptCountPipe,
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
