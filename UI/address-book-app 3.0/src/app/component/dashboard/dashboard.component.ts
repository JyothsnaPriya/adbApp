import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  title: string;
  logoUrl: string;
  ladyLogo: string;
  gentLogo: string;
  birthLogo:string;
  employees: Employee[];
  msg : string;
  cloudIcon : string;
  itIcon : string;
  supportIcon:string;
  testIcon:string;
  constructor(private employeeService:EmployeeService,
    private activatedRoute:ActivatedRoute) {
    this.title = "Employee Portal 3.0";
    this.logoUrl = "/assets/images/adbLogo.png"; 
    this.ladyLogo = "/assets/images/lady.png";
    this.gentLogo = "/assets/images/gent.png";
    this.birthLogo = "/assets/images/birthday.png";
    this.itIcon="/assets/images/it.jpg";
    this.cloudIcon="/assets/images/cloud.jpg";
    this.supportIcon="/assets/images/support.jpg";
    this.testIcon="/assets/images/testing.png";
  }

  ngOnInit() {
    this.employeeService.getAllEmployees().subscribe(
      (data) => this.employees = data
    );
    this.activatedRoute.queryParams.subscribe(
      (params)=>{
        let empId=params['id'];
        let operation=params['opt'];
        if(empId && operation){
          this.msg = "Employee # "+empId + " is successfully "+
          (operation=='d'?'Deleted':(operation=='a'?'added':'updated'));
          
        }else{
          this.msg=undefined;
        }
      }
    );
  }
}
