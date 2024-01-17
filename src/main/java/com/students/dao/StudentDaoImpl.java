package com.students.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.students.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
     private SessionFactory sf;
	@Override
	public List<Student> getAllStudent() {
		List<Student> list = null;
		Session session = sf.openSession();
		try {
			Criteria ctr = session.createCriteria(Student.class);
			 list = ctr.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}
	@Override
	public boolean saveStudent(Student std) {
		Session session = sf.openSession();
		boolean isAdded=false;
		Transaction tr = session.beginTransaction();
		try {
			session.save(std);
			isAdded=true;
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return isAdded;
	}
	@Override
	public Student getStudent(int id) {
		Session session = sf.openSession();
		Student std=null;;
		try {
			 std=session.get(Student.class, id);
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return std;
	}
	@Override
	public boolean deleteStudent(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean isDeleted=false;
		try {
			Student stud = session.get(Student.class, id);
			session.delete(stud);
			tr.commit();
			isDeleted=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return isDeleted;
	}
}
