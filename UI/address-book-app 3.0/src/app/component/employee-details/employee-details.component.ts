import { Component, OnInit } from '@angular/core';
import {Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  employee: Employee;
  ladyLogo: string;
  gentLogo: string;
  cloudIcon : string;
  itIcon : string;
  supportIcon:string;
  testIcon:string;
  constructor(private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute
  ) {
  this.ladyLogo = "/assets/images/lady.png";
    this.gentLogo = "/assets/images/gent.png";
    this.itIcon="/assets/images/it.jpg";
    this.cloudIcon="/assets/images/cloud.jpg";
    this.supportIcon="/assets/images/support.jpg";
    this.testIcon="/assets/images/testing.png";
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params) => {
        let employeeId = params['id'];
        if (employeeId) {
          this.employeeService.getEmployeeById(employeeId).subscribe(
            (data) => this.employee = data
          );
        }
      }
    );
  }

}
