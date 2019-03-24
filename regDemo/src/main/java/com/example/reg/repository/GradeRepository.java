package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade,Long>{

	public List<Grade> findAll();

}
