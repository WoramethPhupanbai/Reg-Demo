package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.Section;

public interface SectionRepository extends CrudRepository<Section,Long>{
	public List<Section> findAll();
}
