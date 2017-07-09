package gestion_projets.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
 * Sous controlleur Jsf ManagedBean
 * 
 * @author Himanshu
 *
 */

@ManagedBean(name = "projetBean1")

@RequestScoped

public class ProjetBean {

	// Add logger for display title
	public Logger log = Logger.getLogger(ProjetBean.class);

	// appel de la couche service
	private ProjetServices projetServices = new ProjetServicesImpl();
	private TypeServices typeServices = new TypeServicesImpl();

	// variable d'instance indiquant le titre du projet
	private String title;
	// variable d'instance indiquant la description du projet sélectionné
	private String description;
	// variable d'instance indiquant le budget du projet
	private String budget;
	// variable d'instance indiquant le type du projet
	private String type;
	// variable d'instance indiquant le statut du projet
	private String active;
	// variable d'instance indiquant si le projet a été bien ajouté
	private String success;
	// Variable d'instance permet d'afficher ou de cacher le formulaire d'ajout
	// d'un projet
	private boolean showForm = true;
	// contient la Liste des types des projets enregistrés dans la base de
	// données, chaque objet dans cette liste est une ligne dans le menu de type
	private List<SelectItem> typeList;
	// contient la Liste des projets enregistrés dans la base de données
	private List<Projet> projetList;
	// id du projet sélectionné
	private String id;
	// opération effectuée sur le projet sélectionné
	private String operation;

	// Allow this function to be applied first
	// We initialize the objects in this method
	@PostConstruct
	public void initBean() {

		// remplir typeList
		typeList = new ArrayList<>();
		typeList.add(new SelectItem("", ""));

		try {
			List<Type> listServices = typeServices.findAll();
			for (Type o : listServices) {
				// maMethode();

				System.out.println("\\\\\\\\\\" + o.getName());
				System.out.println("\\\\\\\\\\" + o.getId());
				typeList.add(new SelectItem(o.getId(), o.getName()));
				System.out.println("\\\\\\\\\\" + o.getName());
				System.out.println("\\\\\\\\\\" + o.getId());
			}
		} catch (Exception e) {

			System.out.println("Exception 2 à gérée");
		}
		// remplir projetList

		projetList = projetServices.findAll();

		System.out.println("id : " + getParam("id"));
		System.out.println("operation : " + getParam("operation"));

		if ("edit".equalsIgnoreCase(getParam("operation"))) {
			setOperation(getParam("operation"));
			Long id = null;
			Projet projet = null;

			try {
				id = Long.valueOf(getParam("id"));
				setId(getParam("id"));
			} catch (Exception e) {
			}

			if (id != null) {

				projet = projetServices.findById(id);

				if (projet != null) {

					title = projet.getTitle();
					description = projet.getDescription();

					if (projet.getBudget() != null) {
						budget = projet.getBudget().toString();
					}

					type = projet.getTypeId().toString() + "";
					active = projet.getActive();

					showForm = true;
				}
			}

		}
	}

	public String getParam(String name) {

		FacesContext fc = FacesContext.getCurrentInstance();

		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

		return params.get(name);
	}

	public void showFormAction(ActionEvent e) {

		log.info("true");
		showForm = true;
	}

	public void cancelAction(ActionEvent e) {

		log.info("false");
		showForm = false;
	}

	public void generateDescription(ActionEvent e) {

		String desc = "";

		desc += "Le titre est :" + title;
		desc = desc + "Le montant : " + budget;
		desc += "Active :" + ("Y".equalsIgnoreCase(active) ? "Oui" : "Non");
		description = desc;

		title = "";
		budget = "";
		active = "";

	}

	public void addProject(ActionEvent e) {

		success = "";

		if ("".equalsIgnoreCase(title)) {

			FacesContext.getCurrentInstance().addMessage("title", new FacesMessage("Le titre est vide ! "));

		} else if (title.length() > 10) {
			FacesContext.getCurrentInstance().addMessage("title", new FacesMessage("Le titre est supp de 10 chars ! "));
		} else {

			log.error("Les valeurs : ");

			log.info(" titre : " + title);
			log.info(" description : " + description);
			log.info(" budget : " + budget);
			log.info(" type : " + type);
			log.info(" active : " + active);

			Projet p = null;

			System.out.println("addProject : " + operation + "-" + id);

			if ("edit".equalsIgnoreCase(operation)) {

				p = projetServices.findById(new Long(id));
				System.out.println("edit");
			} else {

				p = new Projet();
				System.out.println("new");
			}

			p.setTitle(title);
			p.setDescription(description);
			p.setBudget(Double.valueOf(budget));
			p.setTypeId(Long.valueOf(type));
			p.setActive(active);

			projetServices.add(p);
			success = "Bien ajouté";

			title = "";
			description = "";
			budget = "";
			type = "";
			active = "";
			id = "";
			operation = "";
			// add dataBase
		}

	}

	public void deleteProject(ActionEvent e) {

		log.info("delete project");

		// id et name

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();

		log.info("id :" + param.get("id"));
		log.info("name :" + param.get("name"));
		projetServices.delete(new Long(param.get("id")));
		projetList = projetServices.findAll();
	}

	// Ajout methode qui affiche le message tappé par l'utilisateur
	public void saveDate(ActionEvent e) {
		// Affichage avec log
		log.info("Le titre est : " + title);

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public ProjetServices getProjetServices() {
		return projetServices;
	}

	public void setProjetServices(ProjetServices projetServices) {
		this.projetServices = projetServices;
	}

	public TypeServices getTypeServices() {
		return typeServices;
	}

	public void setTypeServices(TypeServices typeServices) {
		this.typeServices = typeServices;
	}

}
