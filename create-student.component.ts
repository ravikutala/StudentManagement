import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class CreateStudentComponent {
  student : Student = new Student();
  constructor(private studentService : StudentService, private route : Router){}

onSubmit(){
  this.insertStudent();
}
insertStudent(){
  this.studentService.createStudent(this.student).subscribe(data => {
    this.goToStudentList();
  })
}
  goToStudentList() {
  this.route.navigate(['students']);
  }
}
