package gestion_projets.presentation;


import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

/**
 * 
 * 
 * @author Himanshu
 *
 */

@ManagedBean(name="projetBean1")
@RequestScoped
public class ProjetBean {

	//Add logger fo display title
	public Logger log= Logger.getLogger(ProjetBean.class);
	private String title;
	private String description;
	private String budget;
	private String type;
	

	


	//Allow this function to be applied first
	@PostConstruct
	public void initBean(){
		
		title="tappez un mot";
	}


	
	
	//Ajout methode qui affiche le message tappé par l'utilisateur
	public void saveDate(ActionEvent e){
		// Affichage avec log
		log.info("Le titre est : "+ title);
		
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

	
	
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
