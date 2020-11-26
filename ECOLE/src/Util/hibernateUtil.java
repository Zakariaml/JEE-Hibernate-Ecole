package Util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Eleve;
import Model.Enseignant;
import Model.Note;
import Model.module;


public class hibernateUtil {
	private static SessionFactory sessionF = null;
	
	static {
		try {
			sessionF = new Configuration().
					configure("hibernate.cfg.xml").
					addAnnotatedClass(Eleve.class).
					addAnnotatedClass(Enseignant.class).
					addAnnotatedClass(module.class).
					addAnnotatedClass(Note.class).
					buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static SessionFactory openSession() {
		return (SessionFactory) sessionF.openSession();
	}
	public static SessionFactory getSessionf() {
		return sessionF;
	}
	
	public static void Shutdown() {
		try {
			sessionF.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
