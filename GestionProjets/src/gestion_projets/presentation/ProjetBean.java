package gestion_projets.presentation;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import gestion_projets.dao.entity.Projet;
import gestion_projets.dao.entity.Type;
import gestion_projets.services.ProjetServices;
import gestion_projets.services.ProjetServicesImpl;
import gestion_projets.services.TypeServices;
import gestion_projets.services.TypeServicesImpl;

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
	
	//appelle couche services 
	
	private ProjetServices projetServices = new ProjetServicesImpl();
	private TypeServices typeServices = new TypeServicesImpl();
	
	
	
	
	private String title;
	private String description;
	private String budget;
	private String type;
	private String active;
	
	private String success;
	private boolean showForm;
	//chaque objet dans cette liste est une ligne dans le menu de type
	private List<SelectItem> typeList;
	private List<Projet> projetList;
	
	{
		
		System.out.println("Block !");
	}
	
	static {
		
		System.out.println("Block static !");
	}
	
	public ProjetBean() {
		System.out.println("construct!");
	}
	
	//Allow this function to be applied first
		//on initialise les objets dans cette méthode
	
	
	
	
	
		@PostConstruct
		public void initBean(){
			
			System.out.println("Post construct !");
			showForm=false;
			
			//remplir typeList
			typeList =new ArrayList<SelectItem>();
			typeList.add(new SelectItem("", ""));
			//typeList.add(new SelectItem(1, "Informatique"));
			//typeList.add(new SelectItem(2, "Commerce"));
			//typeList.add(new SelectItem(3, "Autre"));
			try{
			List<Type> listServices = typeServices.findAll();
			for(Type o:listServices){
				typeList.add(new SelectItem(o.getId(), o.getName()));
			}
			}catch(Exception e){
				
				System.out.println("Exception 2 à gérée");
			}
			//remplir projetList
			try{
			projetList = projetServices.findAll();
			}catch(Exception e){
				
				System.out.println("exception 1 à gérée");
			}
			
		}
		
		
		
		
		
		
		
		
	public void showFormAction(ActionEvent e){
			
			log.info("true");
			showForm=true;
		}
		
		
	public void cancelAction(ActionEvent e){
			
			log.info("false");
			showForm=true;
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
		
		success="";
		
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
			
			Projet p = new Projet();
			p.setTitle(title);
			p.setDescription(description);
			p.setBudget(Double.valueOf(budget));
			p.setTypeId(Long.valueOf(type));
			p.setActive(active);
			
			projetServices.add(p);
			
			success="Bien ajouté";
			
			title="";
			description="";
			budget="";
			type="";
			active="";
			
			// add dataBase
		}
		
	}
	public void deleteProject(ActionEvent e){
		
		log.info("delete project");
		
		
		
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

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List<Projet> getProjetList() {
		return projetList;
	}

	public void setProjetList(List<Projet> projetList) {
		this.projetList = projetList;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	
	
	
	
	
}
