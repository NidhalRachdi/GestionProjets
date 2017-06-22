package gestion_projets.utils;


import org.apache.log4j.Logger;
import org.hibernate.Session;

import gestion_projets.dao.ProjetDAOImpl;
import gestion_projets.dao.ProjetDAO;
import gestion_projets.dao.entity.Projet;

public class Test {

static Session session=HibernateUtil.openSession();


//log4j
	public static  Logger logg =Logger.getLogger(Test.class	);
	
	public static void main(String[] args) throws Exception {
			  
		
		//session.createQuery("select o from Projet o").list();


		ProjetDAO dao = new ProjetDAOImpl();
		
		Projet p =new Projet();
		
		p.setTitle("titre de projet1");
		p.setActive("A");
		p.setDescription("description");
		p.setBudget(5.526);
		
		
		dao.add(p);
		
		System.out.println("ooooooo");
		
		logg.info("message");
		
		
	}
	
}
