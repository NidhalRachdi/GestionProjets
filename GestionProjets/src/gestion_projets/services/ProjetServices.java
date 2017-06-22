package gestion_projets.services;

import java.util.List;

import gestion_projets.dao.entity.Projet;

public interface ProjetServices {

	
	 public void add(Projet e);
	 
	 public Projet edite(Projet e);
	 
	 public void delete(Long id);
	 
	 public List<Projet> findAll();
	 
	 public Projet 	 findById(Long id);
}
