package com.spring.onetoone.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Create {

	public static void main(String[] args) 
	{
		SessionFactory sessionfactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
		
		Session session=sessionfactory.getCurrentSession();
		
		try
		{
			Instructor ins1=new Instructor("Richard12","L12","richard.l12@gmail.com");
			
			InstructorDetails insdet1=new InstructorDetails("Richard12 Code","Reading12");
			
			ins1.setInstructordetails(insdet1);
			
			session.beginTransaction();
			
			session.save(ins1);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally
		{
			
		}
		

	}

}
