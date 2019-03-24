package com.example.reg.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
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

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> doRegister(@RequestBody Map<String,Object> req,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Map<String, Object> res = new HashMap();
		Student stu = new Student();
		Professor profes = new Professor();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		String encodedPassword = bCryptPasswordEncoder.encode((String)req.get("password"));
		if(req!=null) {
			
			String idCard = (String)req.get("iDCard");
			String stuId = (String)req.get("stuId");
			String email = (String)req.get("email");
			String fname = (String)req.get("fname");
			String lname = (String)req.get("lname");
			String tel = (String)req.get("tel");
			String citizen = (String)req.get("citizen");

			stu.setiDCardStu(idCard);
			stu.setStuId(stuId);
			stu.setPassWordStu(encodedPassword);
			stu.setFnameStu(fname);
			stu.setLnameStu(lname);
			stu.setTelStu(tel);
			stu.setEmailStu(email);
			
			profes.setiDCard(idCard);
			profes.setPassWord(encodedPassword);
			profes.setFname(fname);
			profes.setLname(lname);
			profes.setTel(tel);
			profes.setEmail(email);
			
			if(stu!=null&&citizen==null) {
				jdbcUserDetailsManager.createUser((UserDetails) stu);
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
