package gestion_projets.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projet implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//veut dire que la valeur de l'id est auto-increment
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	private String title;
	
	private String description;
	
	private Double budget; 
	
	private String active;

	private int type_id;
	
	
	
	public Projet() {
		super();
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	} 
	
	
	
}
