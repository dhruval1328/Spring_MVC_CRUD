package com.cjc.springmvccrudapp.controller;



import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.springmvccrudapp.model.Student;
import com.cjc.springmvccrudapp.servicei.StudentServiceI;

@Controller
public class HomeController {
	
	@Autowired
	StudentServiceI ssi;
	
	
	
@RequestMapping("/") 
public String preLogin() { 
    System.out.println("open first page"); 
    return "Login"; 
} 
@RequestMapping("/reg") 
public String preRegister() { 
    System.out.println("open register page"); 
    return "Register"; 
}
@RequestMapping("/register") 
public String saveStudent(@ModelAttribute Student s) { 
     System.out.println("in controller"); 
      ssi.saveStudent(s); 
    System.out.println("out controller"); 
    return "Login"; 
} 
@RequestMapping("/log")
public String saveLog(@RequestParam("username") String u,@RequestParam("password") String p, Model m) {
	System.out.println("in log");
	List<Student> l =ssi.login(u, p);
	if(!l.isEmpty()) 
	{
		m.addAttribute("data", l);
		return "success";
	}else {
		return "Login";
	}
}
@RequestMapping("/delete")
public String deleteStudent(@RequestParam("rollno") int rollno,Model m) {
	List<Student> l = ssi.deleteStudent(rollno);
	m.addAttribute("data", l);
	return "success";
}
@RequestMapping("/editdata")
public String updateStudent(@RequestParam("rollno") int rollno,Model m) {
	Student s = ssi.updateStudent(rollno);
	m.addAttribute("stu", s);
	return "Update";
}
@RequestMapping("/update")
public String UpdateS(@ModelAttribute Student s, Model m) {
	List<Student> l = ssi.UpdateS(s);
	m.addAttribute("data", l);
	return "success";
}

@RequestMapping("/logout")
public String logout() {
	return "Login";
}
}