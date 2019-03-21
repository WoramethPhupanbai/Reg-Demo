package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Sectionstudent;

public interface SectionStudentRepository extends CrudRepository<Sectionstudent,Long>{
	public List<Sectionstudent> findAll();
}
