package com.example.reg.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.ClassRoom;
import com.example.reg.entity.Student;
import com.example.reg.repository.ClassRoomRepository;
import com.example.reg.service.ExportService;

@Controller
public class ExportController {

	@Autowired
	ClassRoomRepository classRoomRepository;
	
	@Autowired
    ExportService exportService;
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> download(Model model,HttpSession session) {
		/*Resource responseFile = fooService.export();*/
		Student student = new Student();
		student = (Student) session.getAttribute("student");
		Map<String, Object> res = new HashMap();
		Iterable<ClassRoom> listSectionStudent = classRoomRepository.findAll();
		for(ClassRoom classRoom:listSectionStudent) {
			if(student.getStuId().equalsIgnoreCase(classRoom.getClassRoomStudent().getStuId())) {
				res.put("ClassRoom", classRoom);
			}
		}
	    return res;
	}
	
}
