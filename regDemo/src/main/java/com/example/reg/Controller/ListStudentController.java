package com.example.reg.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.Student;
import com.example.reg.repository.StudentRepository;

@Controller
public class ListStudentController {
	@Autowired
	StudentRepository studentRepority;
	
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> getListStudent(HttpServletRequest request) {
		Map<String, Object> res = new HashMap();
		Iterable<Student> listStudent = studentRepority.findAll();
		res.put("listStudent", listStudent);
		return res;
	}
}
