package com.student.main.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.main.entity.Student;
import com.student.main.service.StudentService;



@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student  student){
		
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED); 
		
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") Integer  studentId){
		Optional<Student> loadStudent =studentService.getStudent(studentId);
		Student std=null;
		if(loadStudent.isPresent()) {
			std=loadStudent.get();
			return new ResponseEntity<Student>(std,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND); 
		}
		
		
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>>  getAllStudents(){
		List<Student>   students=studentService.getAllStudents();
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK); 
		
	}

}
