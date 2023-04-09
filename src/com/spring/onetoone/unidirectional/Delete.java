package com.spring.onetoone.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Delete {

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
			
			session.beginTransaction();
			
			int id=1;
			
			Instructor ins1=session.get(Instructor.class, id);			
			
			if(ins1!=null)
			{
				session.delete(ins1);
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally
		{
			
		}
		

	}

}
