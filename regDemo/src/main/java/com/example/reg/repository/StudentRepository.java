package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Professor;
import com.example.reg.entity.Student;


public interface StudentRepository extends CrudRepository<Student,Long>{

	public List<Student> findAll();
	
	public Student findByIDCard (String IDCard);
	
	public Student findByEmail (String email);
}
