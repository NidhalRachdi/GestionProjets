package gestion_projets.presentation;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

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
	private String active;
	
	//chaque objet dans cette liste est une ligne dans le menu de type
	private List<SelectItem> typeList;

	
	{
		
		System.out.println("Block !");
	}
	
	static {
		
		System.out.println("Block static !");
	}
	
	public ProjetBean() {
		System.out.println("construct!");
	}

	public void generateDescription(ActionEvent e){
		
		String desc = "";
		
		desc+="Le titre est :" + title;
		desc= desc + "Le montant : " + budget ;
		desc+="Active :" + ("Y".equalsIgnoreCase(active)?"Oui" : "Non");
		description=desc;
		
		title="";
		budget="";
		active="";
		
	}
	public void addProject(ActionEvent e){
		
		
		if("".equalsIgnoreCase(title)){
			
			
			FacesContext.getCurrentInstance().addMessage("title", new FacesMessage("Le titre est vide ! "));
			
		}else if(title.length()>10){
			FacesContext.getCurrentInstance().addMessage("title", new FacesMessage("Le titre est supp de 10 chars ! "));
		}
		else{
			
			
			log.error("Les valeurs : ");
			
			log.info(" titre : "+ title);
			log.info(" description : "+ description);
			log.info(" budget : "+ budget);
			log.info(" type : "+ type);
			log.info(" active : "+ active);
			// add dataBase
		}
		
		
		
	
		
	}

	
	
	
	
	//Allow this function to be applied first
	//on initialise les objets dans cette méthode
	@PostConstruct
	public void initBean(){
		
		typeList =new ArrayList<SelectItem>();
		typeList.add(new SelectItem("", ""));
		typeList.add(new SelectItem(1, "Informatique"));
		typeList.add(new SelectItem(2, "Commerce"));
		typeList.add(new SelectItem(3, "Autre"));
		
		System.out.println("Post construct !");
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


	public List<SelectItem> getTypeList() {
		return typeList;
	}


	public void setTypeList(List<SelectItem> typeList) {
		this.typeList = typeList;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	
	
}
