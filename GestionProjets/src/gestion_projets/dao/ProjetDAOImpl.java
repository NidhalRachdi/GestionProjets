package gestion_projets.dao;

import java.util.List;

import org.hibernate.Session;

import gestion_projets.dao.entity.Projet;
import gestion_projets.utils.HibernateUtil;

public class ProjetDAOImpl implements ProjetDAO {
	//obligatoire cet objet
	Session session=HibernateUtil.openSession();

	@Override
	public void add(Projet e) {
		
		//Ouvrir la transaction
		session.beginTransaction();
		
		session.save(e);
		
		//fermer la transaction
		session.getTransaction().commit();
	}

	@Override
	public Projet edite(Projet e) {
		
		
		
		//Ouvrir la transaction
		session.beginTransaction();
		
		//ajouter le projet = l'objet ; retourne la valeur enregistré dans la base de données
		Projet p =(Projet) session.merge(e);
		
		//fermer la transaction
		session.getTransaction().commit();
		
		
		
		return p;
	}

	@Override
	public void delete(Long id) {
		
		//Ouvrir la transaction
		session.beginTransaction();
		
		Projet p = findById(id);		
		
		// supprimer projet
		session.delete(p);
		//fermer la transaction
		session.getTransaction().commit();		
	}

	@Override
	public List<Projet> findAll() {
		
		
		return session.createQuery("select o from Projet o").list();
	}
	
	
	
	
	// trouver l'objet à partir de l'id
	@Override
	public Projet findById(Long id) {
		
		
		
		
		return (Projet) session.get(Projet.class, id);
	}

}
