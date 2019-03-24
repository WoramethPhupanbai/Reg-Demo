package com.example.reg.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.Professor;
import com.example.reg.entity.Student;
import com.example.reg.repository.ProfessorRepository;
import com.example.reg.repository.StudentRepository;
import com.example.reg.response.ResponseConstant;

@Controller
public class LoginController {
	
	@Autowired
	StudentRepository studentRepority;
	
	@Autowired
	ProfessorRepository professorRepority;
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> doLogin(@RequestBody Map<String,Object> req,HttpServletRequest request,HttpSession session) {
		Map<String, Object> res = new HashMap();

		if(req!=null) {
				
			Professor profes = new Professor();
			Student stu = new Student();
			
			String stuId = (String)req.get("stuId");
			String idCard = (String)req.get("iDCard");
			String password = (String)req.get("password");
			
			stu.setStuId(stuId);
			stu.setPassWordStu(password);
			
			if(idCard!=null) {
				profes.setiDCard(idCard);
			}
			
			profes.setPassWord(password);
			
			Iterable<Student> listStudent = studentRepority.findAll();
			Iterable<Professor> listProfessor = professorRepority.findAll();

			if(listStudent!=null&&!stu.getStuId().isEmpty()&&!stu.getPassWordStu().isEmpty()) {
				for(Student student : listStudent) {
					if(student.getStuId().equalsIgnoreCase(stu.getStuId())&&student.getPassWordStu().equalsIgnoreCase(stu.getPassWordStu())) {
						res.put("student", student);
						res.put(ResponseConstant.resCode, ResponseConstant.resCode_Success);
						res.put(ResponseConstant.resDesc, ResponseConstant.successMessage);
						session.setAttribute("student", student);
					}
				}
			}
			else if(listProfessor!=null&&!profes.getiDCard().isEmpty()&&!profes.getPassWord().isEmpty()) {
				for(Professor professor : listProfessor) {
					if(professor.getiDCard().equalsIgnoreCase(profes.getiDCard())&&professor.getPassWord().equalsIgnoreCase(profes.getPassWord())) {
						res.put("professor", professor);
						res.put(ResponseConstant.resCode, ResponseConstant.resCode_Success);
						res.put(ResponseConstant.resDesc, ResponseConstant.successMessage);
						session.setAttribute("professor", professor);
					}
				}
			}else {
				res.put(ResponseConstant.resDesc,ResponseConstant.errorNullMessage);
				res.put(ResponseConstant.resCode, ResponseConstant.resCode_Exception);
			}
		}
		
		return res;
	}
	
	@RequestMapping(value = "/doLogout")
	public  @ResponseBody Map<String, Object> do_logout(HttpSession session) throws Exception {
		Map<String, Object> res = new HashMap();
		session.removeAttribute("iDCard");
		session.removeAttribute("password");
		return res;
		
	}
}
