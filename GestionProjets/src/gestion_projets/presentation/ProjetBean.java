package gestion_projets.presentation;


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

	public Logger log= Logger.getLogger(ProjetBean.class);
	private String title;

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
	
	
	
	
}
