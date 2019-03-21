package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Professor;
import com.example.reg.entity.Student;

public interface ProfessorRepository extends CrudRepository<Professor,Long>{

	public List<Professor> findAll();
	public Professor findByIDCard (String IDCard);
	public Professor findByEmail (String email);
}
