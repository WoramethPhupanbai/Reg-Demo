package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.SubjectGrade;

public interface SubjectGradeRepository extends CrudRepository<SubjectGrade,Long>{
	public List<SubjectGrade> findAll();

}
