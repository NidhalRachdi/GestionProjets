package gestion_projets.services;

import java.util.List;

import gestion_projets.dao.TypeDAO;
import gestion_projets.dao.TypeDAOImpl;
import gestion_projets.dao.entity.Type;

public class TypeServicesImpl implements TypeServices{

	//appel à la couche accés aux données
	TypeDAO dao = new TypeDAOImpl();
	
	
	@Override
	public void add(Type e) {
		dao.add(e);
	}

	@Override
	public Type edite(Type e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override
	public List<Type> findAll() {
		return dao.findAll();
	}

	@Override
	public Type findById(Long id) {
		return dao.findById(id);
	}

}
