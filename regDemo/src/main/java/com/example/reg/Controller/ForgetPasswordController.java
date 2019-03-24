package com.example.reg.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
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
public class ForgetPasswordController {
	
	@Autowired
	StudentRepository studentRepority;
	
	@Autowired
	ProfessorRepository professorRepority;
	
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping(value = "/getInputEmail", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> getInputEmail(@RequestBody Map<String,Object> req,HttpSession session) throws MessagingException {
		Map<String, Object> res = new HashMap();
		String email = (String)req.get("email");
		this.isSendEmail(email);
		res.put(ResponseConstant.resCode, ResponseConstant.resCode_Success);
		res.put(ResponseConstant.resDesc, ResponseConstant.successMessage);
		return res;
	}
	@RequestMapping(value = "/getForgetPassword", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> getForgetPassword() throws MessagingException {
		Map<String, Object> res = new HashMap();
		return res;
	}
	@RequestMapping(value = "/doForgetPassword", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> doForgetPassword(@RequestBody Map<String,Object> req,HttpSession session) {
		Map<String, Object> res = new HashMap();
		if(req!=null) {

			String idCard = (String)req.get("iDCard");
			String stuId = (String)req.get("stuId");
			String newPassword = (String)req.get("newPassword");
			String confirmPassword = (String)req.get("confirmPassword");
			
			Student stu = new Student();
			Professor profes = new Professor();
			try {
				if(newPassword.equalsIgnoreCase(confirmPassword)) {
					if(!stuId.isEmpty()) {
						stu = studentRepority.findByIDCardStu(stu.getiDCardStu());
						if(stu.getStuId().equalsIgnoreCase(stuId)) {
							stu.setiDCardStu(idCard);
							stu.setPassWordStu(newPassword);
							stu.setFnameStu(stu.getFnameStu());
							stu.setStuId(stu.getStuId());
							stu.setLnameStu(stu.getLnameStu());
							stu.setTelStu(stu.getTelStu());
							res.put("student", studentRepority.save(stu));
							res.put(ResponseConstant.resCode, ResponseConstant.resCode_Success);
							res.put(ResponseConstant.resDesc, ResponseConstant.successMessage);
						}
					}else if(!idCard.isEmpty()) {
						profes = professorRepority.findByIDCard(profes.getiDCard());
						if(profes.getiDCard().equalsIgnoreCase(idCard)) {
							profes.setiDCard(idCard);
							profes.setPassWord(newPassword);
							profes.setFname(profes.getFname());
							profes.setLname(profes.getLname());
							profes.setTel(profes.getTel());
							profes.setCitizen(profes.getCitizen());
							res.put("professor", professorRepority.save(profes));
							res.put(ResponseConstant.resCode, ResponseConstant.resCode_Success);
							res.put(ResponseConstant.resDesc, ResponseConstant.successMessage);
						}
					}
				}
			}catch(Exception ex){
					res.put(ResponseConstant.resDesc,ResponseConstant.errorNullMessage);
					res.put(ResponseConstant.resCode, ResponseConstant.resCode_Exception);
			}
		}
		return res;
	}
	public String isSendEmail(String email) throws MessagingException{
		Student stu = new Student();
		Professor profes = new Professor();
		stu = studentRepority.findByEmailStu(email);
		profes = professorRepority.findByEmail(email);
		if(stu!=null) {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(email);
			helper.setText("Your password can be reset by "+"localhost:8082/getForgetPassword");
	 		helper.setSubject("Hey "+stu.getFnameStu());
	 		sender.send(message);
		}
		if(profes!=null) {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(email);
			helper.setText("Your password can be reset by "+"localhost:8082/getForgetPassword");
	 		helper.setSubject("Hey "+profes.getFname());
	 		sender.send(message);
		}
		
		return null;
	}
}
