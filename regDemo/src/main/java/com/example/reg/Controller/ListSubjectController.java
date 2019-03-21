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

import com.example.reg.entity.Student;
import com.example.reg.entity.Subject;
import com.example.reg.repository.SubjectRepository;

@Controller
public class ListSubjectController {
	@Autowired
	SubjectRepository subjectRepority;
	
	@RequestMapping(value = "/listSubject", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> getListSubject(HttpServletRequest request,HttpSession session) {
		Map<String, Object> res = new HashMap();
		Student student = new Student();
		student = (Student) session.getAttribute("student");
		Iterable<Subject> listSubject = subjectRepority.findAll();
		/*if(student.getStuId()!=null) {
			res.put("listSubject", listSubject);
		}*/
		res.put("listSubject", listSubject);
		return res;
	}
}
