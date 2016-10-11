package utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	static{
		try{
			sessionFactory = new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Cr�ation du sessionFactory a �chou� : "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static  SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
