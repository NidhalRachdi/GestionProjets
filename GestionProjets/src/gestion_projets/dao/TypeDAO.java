package gestion_projets.dao;

import java.util.List;

import gestion_projets.dao.entity.Type;

public interface TypeDAO {

	
	
	 public void add(Type e);
	 
	 public Type edite(Type e);
	 
	 public void delete(Long id);
	 
	 public List<Type> findAll();
	 
	 public Type 	 findById(Long id);
	
	 
}
