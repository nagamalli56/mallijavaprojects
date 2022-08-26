package com.student.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.student.main.entity.Student;
import com.student.main.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	
	public Student saveStudent(Student student){
		return studentRepository.save(student);
	}
	
	public Optional<Student> getStudent(Integer studentId){
		return studentRepository.findById(studentId);
	}
	public List<Student>  getAllStudents(){
		return (List<Student>) studentRepository.findAll();
		
	}

}
