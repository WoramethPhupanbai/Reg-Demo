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

import com.example.reg.entity.Grade;
import com.example.reg.entity.Professor;
import com.example.reg.entity.Section;
import com.example.reg.entity.Student;
import com.example.reg.entity.Subject;
import com.example.reg.entity.SubjectGrade;
import com.example.reg.repository.ClassRoomRepository;
import com.example.reg.repository.GradeRepository;
import com.example.reg.repository.ProfessorRepository;
import com.example.reg.repository.StudentRepository;
import com.example.reg.repository.SubjectGradeRepository;
import com.example.reg.repository.SubjectRepository;

import scala.annotation.meta.setter;

@Controller
public class EditGradeController {
	@Autowired
	ClassRoomRepository classRoomRepository;
	
	@Autowired
	SubjectGradeRepository subjectGradeRepository;
	
	@Autowired
	StudentRepository studentRepority;
	
	@Autowired
	ProfessorRepository professorRepority;
	
	@Autowired
	SubjectRepository subjectRepority;
	
	@Autowired
	GradeRepository gradeRepority;
	
	@RequestMapping(value = "/getEditGrade")
	public  @ResponseBody Map<String, Object> getEditGrade(@RequestParam String iDCard) {
		Map<String, Object> res = new HashMap();
			Student stu = new Student();
			
			stu.setiDCardStu(iDCard);
			
			stu = studentRepority.findByIDCardStu(stu.getiDCardStu());
			
			res.put("stu", stu);
		
		return res;
	}
	
	@RequestMapping(value = "/doEditGrade", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> doEditGrade(@RequestBody Map<String,Object> req,HttpServletRequest request,HttpSession session) {
		Map<String, Object> res = new HashMap();
		if(req!=null) {
			
			String idCard = (String)req.get("iDCard");
			String SubjectId = (String)req.get("SubjectId");
			int gradeId = (int)req.get("gradeId");
			Student stu = new Student();
			Subject sub = new Subject();
			Grade grade = new Grade();
			
			stu.setiDCardStu(idCard);
			sub.setSubjectId(SubjectId);
			grade.setIdGrade(gradeId);
			
			SubjectGrade subGrade = new SubjectGrade();
			subGrade.getGadeSubject().setIdGrade(gradeId);
			subGrade.getSubjectGrade().setSubjectId(SubjectId);
			res.put("student", subjectGradeRepository.save(subGrade));
			
		}
		
		return res;
	}
}
