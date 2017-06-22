package gestion_projets.dao;

import java.util.List;

import com.sun.tracing.Probe;

import gestion_projets.dao.entity.Projet;

public interface ProjetDAO {
	
	 public void add(Projet e);
	 
	 public Projet edite(Projet e);
	 
	 public void delete(Long id);
	 
	 public List<Projet> findAll();
	 
	 public Projet 	 findById(Long id);
	 
}
