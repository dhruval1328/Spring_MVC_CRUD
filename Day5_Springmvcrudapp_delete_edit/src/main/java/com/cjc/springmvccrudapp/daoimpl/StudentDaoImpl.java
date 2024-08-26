package com.cjc.springmvccrudapp.daoimpl;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.springmvccrudapp.daoi.StudentDaoI;
import com.cjc.springmvccrudapp.model.Student;

import jakarta.transaction.Transaction;

@Repository
public class StudentDaoImpl implements StudentDaoI{
	@Autowired 
	  SessionFactory sf; //create SessionFactory Object 
	     
	    public void saveStudent(Student s) { 
	         System.out.println("in dao"); 
	        Session session=sf.openSession(); 
	        session.save(s); 
	         session.beginTransaction().commit(); 
	        System.out.println("out dao"); 
	    }

		@Override
		public List<Student> login(String username, String password) {
			Session session = sf.openSession();
			System.out.println("in dao");
	    	if(username.equals("ADMIN") && password.equals("ADMIN"))
	    	{
//	    		List<Student> l = session.createQuery("from Student").getResultList();
	    		return getStudent();
	    	}else {
	    		Query<Student> q = (Query<Student>) session.createQuery("from Student where username=? and password=?").getResultList();
	    		q.setParameter(1, username);
	    		q.setParameter(2, password);
	    		List<Student> l = q.getResultList();
	    		return l;
	    	}
		}

		@Override
		public List<Student> deleteStudent(int rollno) {
			Session s = sf.openSession();
			org.hibernate.Transaction t = s.beginTransaction();
//			Transaction tx = s.beginTransaction();
			Query<Student> q = s.createQuery("delete from Student where rollno=?1");
			q.setParameter(1, rollno);
			q.executeUpdate();
			t.commit();
			return getStudent();
		} 
		public List<Student> getStudent(){
			Session s = sf.openSession();
			return s.createQuery("from Student").getResultList();
		}

		@Override
		public Student updateStudent(int rollno) {
			Session s = sf.openSession();
			Query<Student> q = s.createQuery("from Student where rollno=?1");
			q.setParameter(1, rollno);
			Student s1 = q.getSingleResult();
			return s1;
		}

		@Override
		public List<Student> UpdateS(Student s) {
			Session ses = sf.openSession();
			ses.update(s);
			ses.beginTransaction().commit();
			return getStudent();
		}
	   
}
