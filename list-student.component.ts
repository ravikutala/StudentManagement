import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrl: './list-student.component.css'
})
export class ListStudentComponent implements OnInit{
  students : Student[] = [];
  constructor(private studentService : StudentService, private router : Router){}
  ngOnInit(): void {
  this.getStudents();
  }
private getStudents(){
  this.studentService.getStudentList().subscribe(data => {this.students = data;});
}
updateStudent(studentId : number)
{
  this.router.navigate(['update-student',studentId]);
}
deleteStudent(studentId : number) {
  this.studentService.deleteStudentById(studentId).subscribe(data => {
    this.getStudents();
  })
}
}
