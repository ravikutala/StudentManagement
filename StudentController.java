package com.student.management.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.exceptions.StudentNotFoundException;
import com.student.management.repositories.StudentRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StudentController {
@Autowired
private StudentRepository studentRepository;
@GetMapping("/students")
public List<Student> getAllStudents() {
	return  studentRepository.findAll();
}
@PostMapping("/students")
public Student createStudent(@RequestBody Student student) {
	return studentRepository.save(student);

}
@GetMapping("/students/{studentId}")
public ResponseEntity<Student> getStudentById(@PathVariable int studentId){
	Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student with Student Id "+studentId+" does not exist"));
return ResponseEntity.ok(student);
}
@PutMapping("/students/{studentId}")
public ResponseEntity<Student>updateStudent(@PathVariable int studentId,@RequestBody Student studentDetails){
	Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student with Student Id "+studentId+" does not exist"));
student.setStudentName(studentDetails.getStudentName());
student.setStudentClass(studentDetails.getStudentClass());
student.setStudentSection(studentDetails.getStudentSection());
student.setYearFee(studentDetails.getYearFee());
student.setFeePaid(studentDetails.getFeePaid());
student.setBalanceFee(studentDetails.getBalanceFee());
studentRepository.save(student);
return ResponseEntity.ok(student);
}
@DeleteMapping("/students/{studentId}")
public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable int studentId){
	Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student with Student Id "+studentId+" does not exist"));
  studentRepository.delete(student);
	Map<String,Boolean> response = new HashMap<String,Boolean>();
	response.put("Deleted",Boolean.TRUE);
	return ResponseEntity.ok(response);
}
}
