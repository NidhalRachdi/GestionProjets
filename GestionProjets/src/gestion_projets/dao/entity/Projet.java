package gestion_projets.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@Column(name="type_id")
	private Long typeId;
	
	
	//pour dire un type peut exister dans plusieurs projets
	@ManyToOne
	@JoinColumn(name="type_id", referencedColumnName="id", insertable=false, updatable=false)
	private Type type;
	
	
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
	
	/* permet de mettre oui ou non dans active selon sa valeur Y or N
	public String getActiveConvert() {
		if("Y".equalsIgnoreCase(active)){
			
			return "Oui";
		}else{
			
			return "Non";
		}
	}
	
	*/
	

	public void setActive(String active) {
		this.active = active;
	}

	
	
	


	public Long getTypeId() {
		return typeId;
	}



	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}


 
	
	
	
}
