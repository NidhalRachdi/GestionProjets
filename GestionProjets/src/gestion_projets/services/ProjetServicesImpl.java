package gestion_projets.services;

import java.util.List;

import gestion_projets.dao.ProjetDAOImpl;
import gestion_projets.dao.ProjetDAO;
import gestion_projets.dao.entity.Projet;

public class ProjetServicesImpl implements ProjetServices{

	
	ProjetDAO dao = new ProjetDAOImpl();
	
	
	@Override
	public void add(Projet e) {
		dao.add(e);		
	}

	@Override
	public Projet edite(Projet e) {

		
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		
		
		dao.delete(id);
	}

	@Override
	public List<Projet> findAll() {

		
		
		return dao.findAll();
	}

	@Override
	public Projet findById(Long id) {
		
		
		return findById(id);
	}

}
