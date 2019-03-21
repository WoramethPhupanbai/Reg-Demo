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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.reg.entity.Professor;
import com.example.reg.entity.Section;
import com.example.reg.entity.Student;
import com.example.reg.entity.Subject;
import com.example.reg.repository.ProfessorRepository;
import com.example.reg.repository.StudentRepository;

@Controller
public class EditGradeController {
	@Autowired
	StudentRepository studentRepority;
	
	@Autowired
	ProfessorRepository professorRepority;
	
	@RequestMapping(value = "/getEditGrade")
	public  @ResponseBody Map<String, Object> getEditGrade(@RequestParam String iDCard) {
		Map<String, Object> res = new HashMap();
			Student stu = new Student();
			
			stu.setiDCard(iDCard);
			
			stu = studentRepority.findByIDCard(stu.getiDCard());
			
			res.put("stu", stu);
		
		return res;
	}
	
	@RequestMapping(value = "/doEditGrade", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> doEditGrade(@RequestBody Map<String,Object> req,HttpServletRequest request,HttpSession session) {
		Map<String, Object> res = new HashMap();
		if(req!=null) {
			
			String idCard = (String)req.get("iDCard");
			Student stu = new Student();
			Subject subject = new Subject();
			Section section = new Section();
			
			stu.setiDCard(idCard);
			
			if(stu!=null) {
				res.put("student", studentRepority.save(stu));
			}
		}
		
		return res;
	}
}
