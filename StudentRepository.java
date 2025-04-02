package com.student.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{


}
