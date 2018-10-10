import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees:Employee[];
  
  ladyLogo:string;
  gentLogo:string;

  constructor(
    private employeeService:EmployeeService
, private activatedRoute : ActivatedRoute  ) {
    this.ladyLogo="/assets/images/lady.png";
    this.gentLogo="/assets/images/gent.png";
   }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) =>{
        let field = params['field'];
        let srchValue = params['srchValue'];

        console.log(field +":"+srchValue);

        if(field && srchValue){
          this.employeeService.searchEmployees(field,srchValue).subscribe(
            (data) => this.employees=data,
            (err)=> this.employees=undefined
          );
        }else{
          this.employeeService.getAllEmployees().subscribe(
            (data) => this.employees=data,
            (err)=> this.employees=undefined
          );
        }
      },
      (err)=>this.employees=undefined
    );
    
  }

}
