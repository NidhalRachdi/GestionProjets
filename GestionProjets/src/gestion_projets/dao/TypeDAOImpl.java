package gestion_projets.dao;

import java.util.List;

import org.hibernate.Session;

import gestion_projets.dao.entity.Type;
import gestion_projets.utils.HibernateUtil;

public class TypeDAOImpl implements TypeDAO {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Type e) {

		// Ouvrir la transaction
		session.beginTransaction();

		session.save(e);

		// fermer la transaction
		session.getTransaction().commit();
	}

	@Override
	public Type edite(Type e) {

		// Ouvrir la transaction
		session.beginTransaction();

		// ajouter le projet = l'objet ; retourne la valeur enregistré dans la
		// base de données
		Type p = (Type) session.merge(e);

		// fermer la transaction
		session.getTransaction().commit();

		return p;
	}

	@Override
	public void delete(Long id) {

		// Ouvrir la transaction
		session.beginTransaction();

		Type p = findById(id);

		// supprimer projet
		session.delete(p);
		// fermer la transaction
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() {

		return session.createQuery("select o from Type o").list();
	}

	// trouver l'objet à partir de l'id
	@Override
	public Type findById(Long id) {

		return (Type) session.get(Type.class, id);
	}

}
