import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

  emplyoee: Employee;
  ladyLogo: string;
  gentLogo: string;
  constructor(private emplyoeeService: EmployeeService,
    private activatedRoute: ActivatedRoute,
    private router : Router
  ) {
  this.ladyLogo = "/assets/images/fem.jpg";
    this.gentLogo = "/assets/images/male.png";
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params) => {
        let emplyoeeId = params['id'];
        if (emplyoeeId) {
          this.emplyoeeService.getEmployeeById(emplyoeeId).subscribe(
            (data) => this.emplyoee = data
          );
        }
      }
    );
  }

  doDelete(isConfirmed:boolean){
    if(isConfirmed){
      this.emplyoeeService.deleteEmployeeById(this.emplyoee.empId).subscribe(
        (resp) =>{
          if(resp.ok){
            this.router.navigateByUrl("/?opt=d&id="+this.emplyoee.empId);
          }
        }
      );
    }else{
      this.router.navigateByUrl("/");
    }
  }
}
