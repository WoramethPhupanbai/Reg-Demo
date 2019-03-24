package com.example.reg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reg.entity.ClassRoom;

public interface ClassRoomRepository extends CrudRepository<ClassRoom,Long>{
	public List<ClassRoom> findAll();
}
