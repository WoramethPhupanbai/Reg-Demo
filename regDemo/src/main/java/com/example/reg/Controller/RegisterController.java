package com.example.reg.Controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.Professor;
import com.example.reg.entity.Student;
import com.example.reg.repository.ProfessorRepository;
import com.example.reg.repository.StudentRepository;

@Controller
public class RegisterController {
	@Autowired
	StudentRepository studentRepority;
	
	@Autowired
	ProfessorRepository professorRepority;
	
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> doRegister(@RequestBody Map<String,Object> req,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Map<String, Object> res = new HashMap();
		if(req!=null) {
			
			String idCard = (String)req.get("iDCard");
			String stuId = (String)req.get("stuId");
			String password = (String)req.get("password");
			String email = (String)req.get("email");
			String fname = (String)req.get("fname");
			String lname = (String)req.get("lname");
			String tel = (String)req.get("tel");
			String citizen = (String)req.get("citizen");
			
			Student stu = new Student();
			Professor profes = new Professor();
			
			stu.setiDCard(idCard);
			stu.setStuId(stuId);
			stu.setPassWord(password);
			stu.setFname(fname);
			stu.setLname(lname);
			stu.setTel(tel);
			stu.setEmail(email);
			
			profes.setiDCard(idCard);
			profes.setPassWord(password);
			profes.setFname(fname);
			profes.setLname(lname);
			profes.setTel(tel);
			profes.setEmail(email);
			
			if(stu!=null&&citizen==null) {
				res.put("student", studentRepority.save(stu));
			}
			if(citizen != null) {
				profes.setCitizen(citizen);
				res.put("professor", professorRepority.save(profes));
			}
		}
		return res;
	}
}
