package com.cjc.springmvccrudapp.daoi;

import java.util.List;

import com.cjc.springmvccrudapp.model.Student;

public interface StudentDaoI {
	 public void saveStudent(Student s);

	 public List<Student> login(String username, String password);
	 public List<Student> deleteStudent(int rollno);
	 public Student updateStudent(int rollno);
	 public List<Student> UpdateS(Student s);
}
