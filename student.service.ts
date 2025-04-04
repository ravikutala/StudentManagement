import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
private baseURL = "http://localhost:8080/students";
  constructor(private httpClient : HttpClient) { }
  getStudentList() : Observable<Student[]>{
   return this.httpClient.get<Student[]>(`${this.baseURL}`); 
  }
  createStudent(student : Student) :Observable<object>{
    return this.httpClient.post(`${this.baseURL}`,student);
  }
  getStudentById(studentId : number) :Observable<Student>{
    return this.httpClient.get<Student>(`${this.baseURL}/${studentId}`);
    
  }
  updateStudent(studentId:number,student:Student):Observable<Student>{
    return this.httpClient.put<Student>(`${this.baseURL}/${studentId}`,student);
  }
  deleteStudentById(studentId : number) :Observable<object>{
    return this.httpClient.delete<Student>(`${this.baseURL}/${studentId}`);
    
  }

}
