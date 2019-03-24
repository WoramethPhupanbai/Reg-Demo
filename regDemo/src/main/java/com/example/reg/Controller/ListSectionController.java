package com.example.reg.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.Professor;
import com.example.reg.entity.Section;
import com.example.reg.entity.ClassRoom;
import com.example.reg.entity.Student;
import com.example.reg.repository.ProfessorRepository;
import com.example.reg.repository.SectionRepository;
import com.example.reg.repository.ClassRoomRepository;
import com.example.reg.repository.StudentRepository;

@Controller
public class ListSectionController {
	@Autowired
	ClassRoomRepository classRoomRepository;
	
	@Autowired
	StudentRepository studentRepority;
	
	@Autowired
	ProfessorRepository professorRepority;
	
	@RequestMapping(value = "/listSection", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> getListSection(HttpServletRequest request,HttpSession session) {
		Map<String, Object> res = new HashMap();
		Professor profes = new Professor();
		profes = (Professor) session.getAttribute("professor");
		Iterable<ClassRoom> listSectionStudent = classRoomRepository.findAll();
		profes = professorRepority.findByIDCard(profes.getiDCard());
		for(ClassRoom classRoom:listSectionStudent) {
			if(profes.getiDCard().equals(classRoom.getClassRoomStudent().getiDCardStu())) {
				res.put("listSectionStudent", listSectionStudent);
			}
		}
		return res;
	}
}
