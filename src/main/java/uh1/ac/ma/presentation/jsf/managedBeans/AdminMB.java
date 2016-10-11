package uh1.ac.ma.presentation.jsf.managedBeans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uh1.ac.ma.metier.entities.Adminstrateur;
import uh1.ac.ma.metier.entities.Agent;
import uh1.ac.ma.metier.entities.Client;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.CompteCourant;
import uh1.ac.ma.metier.entities.CompteEpargne;
import uh1.ac.ma.metier.entities.Utilisateur;
import uh1.ac.ma.metier.services.IAdminServices;
import uh1.ac.ma.presentation.allModels.AgenceModel;
import uh1.ac.ma.presentation.allModels.CompteModel;
import uh1.ac.ma.presentation.allModels.UtilisateurModel;

@ManagedBean(name="adminMB")
@RequestScoped
public class AdminMB {

	@Autowired
	private IAdminServices adminMetier;
	
	private AgenceModel agenceModel;
	private UtilisateurModel utilisateurModel;
	private CompteModel compteModel;
	private long ref;
	
	public void setAdminMetier(IAdminServices adminMetier) {
		this.adminMetier = adminMetier;
	}

	public String index(){
		return "index";
	}
	
	
	public String agences(Model model){
		AgenceModel agenceModel = new AgenceModel();
		agenceModel.setAgences(adminMetier.getAllAgences());
		model.addAttribute("agenceModel",agenceModel);
		return "success";
	}
	
	@RequestMapping(value="/agences/new")
	public String addAgence(){
		adminMetier.addAgence(agenceModel.getNewAgence());
		agenceModel.setMessage("Agence est ajoutée");
		agenceModel.setAgences(adminMetier.getAllAgences());
		return "success";
	}
	
	
	public String removeAgence(){
		adminMetier.removeAgence(ref);
		agenceModel.setMessage("Agence est supprimée");
		agenceModel.setAgences(adminMetier.getAllAgences());
		return "success";
	}
	
	
	public String modifyAgence(){
		agenceModel.setNewOrModify(true);
		agenceModel.setNewAgence(adminMetier.getAgence(ref));
		agenceModel.setAgences(adminMetier.getAllAgences());
		return "success";
	}
	
	
	public String postModifyAgence(){
		agenceModel.setNewOrModify(false);
		adminMetier.updateAgence(agenceModel.getNewAgence());
		agenceModel.setAgences(adminMetier.getAllAgences());
		return "success";
	}
	
	
	
	
	public String utilisateurs(){
		UtilisateurModel utilisateurModel = new UtilisateurModel();
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		return "success";
	}
	
	public String addUtilisateur(){
		Utilisateur u = utilisateurModel.getNewUtilisateur();
		if(utilisateurModel.getRole().equals("admin"))
			adminMetier.addUtilisateur(new Adminstrateur(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre()));
		else if( utilisateurModel.getRole().equals("client") )
			adminMetier.addUtilisateur(new Client(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre()));
		else if( utilisateurModel.getRole().equals("agent") )
			adminMetier.addUtilisateur(new Agent(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre()));
		else adminMetier.addUtilisateur(utilisateurModel.getNewUtilisateur());
			
		utilisateurModel.setMessage("Utilisateur est ajouté");
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		return "success";
	}
	
	
	public String removeUtilisateur(){
		adminMetier.removeUtilisateur(ref);
		utilisateurModel.setMessage("Utilisateur est supprimée");
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		return "success";
	}
	
	
	public String modifyUtilisateur(){
		utilisateurModel.setNewOrModify(true);
		utilisateurModel.setNewUtilisateur(adminMetier.getUtilisateur(ref));
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		return "success";
	}
	
	
	public String postModifyUtilisateur(){
		utilisateurModel.setNewOrModify(false);
		adminMetier.updateUtilisateur(utilisateurModel.getNewUtilisateur());
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		return "success";
	}
	
	
	
	
	public String comptes(){
		CompteModel compteModel = new CompteModel();
		compteModel.setComptes(adminMetier.getAllComptes());
		return "success";
	}
	

	public String addCompte(){
		Compte c = compteModel.getNewCompte();
		boolean test = false;
		if(compteModel.getType().equals("Compte courant"))
			test = adminMetier.addCompteCourant(new CompteCourant(c.getCode(), c.getDateCreation(), c.getSolde(), 0,c.getAgent(),c.getClients(),c.isActive()));
		else if( compteModel.getType().equals("Compte d'epargne") )
			test = adminMetier.addCompteEpargne(new CompteEpargne(c.getCode(), c.getDateCreation(), c.getSolde(), 0,c.getAgent(),c.getClients(),c.isActive()));
			
		if(test) compteModel.setMessage("Compte est ajouté");
		else compteModel.setMessage("Compte n'est pas ajouté");
		compteModel.setComptes(adminMetier.getAllComptes());
		return "success";
	}
	
	
	public String removeCompte(){
		adminMetier.removeCompte(ref);
		compteModel.setMessage("Compte est supprimée");
		compteModel.setComptes(adminMetier.getAllComptes());
		return "success";
	}
	
	
	public String modifyCompte(){
		compteModel.setNewOrModify(true);
		compteModel.setNewCompte(adminMetier.getCompte(ref));
		compteModel.setComptes(adminMetier.getAllComptes());
		return "success";
	}
	
	
	public String postModifyCompte(){
		compteModel.setNewOrModify(false);
		adminMetier.updateCompte(compteModel.getNewCompte());
		compteModel.setComptes(adminMetier.getAllComptes());
		return "success";
	}

	public AgenceModel getAgenceModel() {
		return agenceModel;
	}

	public void setAgenceModel(AgenceModel agenceModel) {
		this.agenceModel = agenceModel;
	}

	public UtilisateurModel getUtilisateurModel() {
		return utilisateurModel;
	}

	public void setUtilisateurModel(UtilisateurModel utilisateurModel) {
		this.utilisateurModel = utilisateurModel;
	}

	public CompteModel getCompteModel() {
		return compteModel;
	}

	public void setCompteModel(CompteModel compteModel) {
		this.compteModel = compteModel;
	}

	public long getRef() {
		return ref;
	}

	public void setRef(long ref) {
		this.ref = ref;
	}
	
	
	
	


	
}
