package com.cjc.springmvccrudapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.springmvccrudapp.daoi.StudentDaoI;
import com.cjc.springmvccrudapp.model.Student;
import com.cjc.springmvccrudapp.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI{
	  @Autowired 
	    StudentDaoI sdi; // create StudentDaoI reference and 
	// declar @Autowired annotation on it 
	 
	    public void saveStudent(Student s) { 
	        System.out.println("in service"); 
	        sdi.saveStudent(s); 
	        System.out.println("out service"); 
	    }

		@Override
		public List<Student> login(String username, String password) {
			List<Student> list = sdi.login(username, password);
			return list;
		}

		@Override
		public List<Student> deleteStudent(int rollno) {
			List<Student> l = sdi.deleteStudent(rollno);
			return l;
		}

		@Override
		public Student updateStudent(int rollno) {
			Student s = sdi.updateStudent(rollno);
			return s;
		}

		@Override
		public List<Student> UpdateS(Student s) {
			List<Student> l = sdi.UpdateS(s);
			return l;
		}    
	} 

