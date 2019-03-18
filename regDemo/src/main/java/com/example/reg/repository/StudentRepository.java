package com.example.reg.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{

}
