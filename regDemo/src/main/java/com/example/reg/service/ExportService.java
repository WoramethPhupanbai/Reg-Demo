package com.example.reg.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.reg.entity.ClassRoom;
import com.example.reg.repository.ClassRoomRepository;

public class ExportService {

	@Autowired
	ClassRoomRepository classRoomRepository;
	
	final String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String candidateNum = "0123456789";
    
    @Autowired
    Utils appUtil;
    public Iterable<ClassRoom> FindAll(){
    Iterable<ClassRoom> listSectionStudent = IntStream.rangeClosed(1, 20)
            .mapToObj(i -> new ClassRoom(appUtil.generateRandonInteger(i)))
            .collect(Collectors.toList());
    
    return listSectionStudent;
    }

}
