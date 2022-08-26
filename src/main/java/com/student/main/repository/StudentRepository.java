package com.student.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.main.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
