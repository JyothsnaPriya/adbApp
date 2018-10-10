import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from '../model/employee';

@Pipe({
  name: 'deptCount'
})
export class DeptCountPipe implements PipeTransform {

  transform(emplyoees: Employee[], dept?:string): number {
    return emplyoees.filter((b)=>b.dept==dept).length;
  }

}
