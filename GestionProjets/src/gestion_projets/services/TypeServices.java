package gestion_projets.services;

import java.util.List;

import gestion_projets.dao.entity.Type;

public interface TypeServices {

	 public void add(Type e);
	 
	 public Type edite(Type e);
	 
	 public void delete(Long id);
	 
	 public List<Type> findAll();
	 
	 public Type 	 findById(Long id);
}
