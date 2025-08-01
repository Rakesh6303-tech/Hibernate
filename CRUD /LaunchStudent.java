package com.tap.view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tap.model.Student;

public class LaunchStudent {

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.openSession();

		try {
			// 1) Create new user
			Student newUser = new Student("AbhiRam",9345);
				session.persist(newUser); // Saves to DB
			
			// 2) Update 
			Student newUser = session.get(Student.class, 1);
			newUser.setStudentName("Veeresh");
		        session.update(newUser);
			
			// 3) Delete single record
		      Student newUser = session.get(Student.class, 102);
		       session.delete(newUser);
		        session.beginTransaction();

				// 4) To get all Data from DB
			Query<Student> query = session.createQuery("From Student",
					Student.class);
			List<Student> students = query.list();
			for(Student stdt : students)
			{
				System.out.println(stdt);
			}
			
			session.getTransaction().commit(); // Commits the transaction

			System.out.println("Table created and user inserted!");
		} finally {
			factory.close();
		}
	}

}
