package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject,Long>{
	public List<Subject> findAll();
}
