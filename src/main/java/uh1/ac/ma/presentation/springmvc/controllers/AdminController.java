package uh1.ac.ma.presentation.springmvc.controllers;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
import utils.Util;

@Controller
@Scope("session")
public class AdminController {

	@Autowired
	private IAdminServices adminMetier;
	
	
	public void setAdminMetier(IAdminServices adminMetier) {
		this.adminMetier = adminMetier;
	}

	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	
	@RequestMapping(value="/agences")
	public String agences(Model model){
		AgenceModel agenceModel = new AgenceModel();
		agenceModel.setAgences(adminMetier.getAllAgences());
		model.addAttribute("agenceModel",agenceModel);
		return "agences";
	}
	
	@RequestMapping(value="/agences/new")
	public String addAgence(AgenceModel agenceModel,Model model){
		adminMetier.addAgence(agenceModel.getNewAgence());
		agenceModel.setMessage("Agence est ajoutée");
		agenceModel.setAgences(adminMetier.getAllAgences());
		model.addAttribute("agenceModel",agenceModel);
		return "agences";
	}
	
	
	@RequestMapping(value="/agences/remove",method=RequestMethod.GET)
	public String removeAgence(AgenceModel agenceModel,Model model,@RequestParam long ref){
		adminMetier.removeAgence(ref);
		agenceModel.setMessage("Agence est supprimée");
		agenceModel.setAgences(adminMetier.getAllAgences());
		model.addAttribute("agenceModel",agenceModel);
		return "agences";
	}
	
	
	@RequestMapping(value="/agences/modify",method=RequestMethod.GET)
	public String modifyAgence(AgenceModel agenceModel,Model model,@RequestParam long ref){
		agenceModel.setNewOrModify(true);
		agenceModel.setNewAgence(adminMetier.getAgence(ref));
		agenceModel.setAgences(adminMetier.getAllAgences());
		model.addAttribute("agenceModel",agenceModel);
		return "agences";
	}
	
	
	@RequestMapping(value="/agences/postModify")
	public String postModifyAgence(AgenceModel agenceModel,Model model){
		agenceModel.setNewOrModify(false);
		adminMetier.updateAgence(agenceModel.getNewAgence());
		agenceModel.setAgences(adminMetier.getAllAgences());
		model.addAttribute("agenceModel",agenceModel);
		return "agences";
	}
	
	
	
	
	@RequestMapping(value="/utilisateurs")
	public String utilisateurs(Model model){
		UtilisateurModel utilisateurModel = new UtilisateurModel();
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		model.addAttribute("utilisateurModel",utilisateurModel);
		return "utilisateurs";
	}
	
	@RequestMapping(value="/utilisateurs/new")
	public String addUtilisateur(UtilisateurModel utilisateurModel,Model model){
		Utilisateur u = utilisateurModel.getNewUtilisateur();
		u.setDateNaissance(Util.getDateFromString(utilisateurModel.getDateNaissance()));
		if(utilisateurModel.getRole().equals("admin"))
			adminMetier.addUtilisateur(new Adminstrateur(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre()));
		else if( utilisateurModel.getRole().equals("client") )
			adminMetier.addUtilisateur(new Client(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre()));
		else if( utilisateurModel.getRole().equals("agent") )
			adminMetier.addUtilisateur(new Agent(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre()));
		else adminMetier.addUtilisateur(utilisateurModel.getNewUtilisateur());
		
			
		utilisateurModel.setMessage("Utilisateur est ajouté");
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		model.addAttribute("utilisateurModel",utilisateurModel);
		return "utilisateurs";
	}
	
	
	@RequestMapping(value="/utilisateurs/remove",method=RequestMethod.GET)
	public String removeUtilisateur(UtilisateurModel utilisateurModel,Model model,@RequestParam long ref){
		adminMetier.removeUtilisateur(ref);
		utilisateurModel.setMessage("Utilisateur est supprimée");
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		model.addAttribute("utilisateurModel",utilisateurModel);
		return "utilisateurs";
	}
	
	
	@RequestMapping(value="/utilisateurs/modify",method=RequestMethod.GET)
	public String modifyUtilisateur(UtilisateurModel utilisateurModel,Model model,@RequestParam long ref){
		utilisateurModel.setNewOrModify(true);
		utilisateurModel.setNewUtilisateur(adminMetier.getUtilisateur(ref));
		utilisateurModel.setRole(utilisateurModel.getNewUtilisateur().toString());
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		model.addAttribute("utilisateurModel",utilisateurModel);
		return "utilisateurs";
	}
	
	
	@RequestMapping(value="/utilisateurs/postModify")
	public String postModifyUtilisateur(UtilisateurModel utilisateurModel,Model model){
		
		Utilisateur u = utilisateurModel.getNewUtilisateur();
		if(utilisateurModel.getRole().equals("Administrateur")){
			Adminstrateur a = new Adminstrateur(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre());
			a.setCodeUtilisateur(u.getCodeUtilisateur());
			adminMetier.updateUtilisateur(a);
		}else if( utilisateurModel.getRole().equals("Client") ){
			Client c = new Client(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre());
			c.setCodeUtilisateur(u.getCodeUtilisateur());
			adminMetier.updateUtilisateur(c);
		}else if( utilisateurModel.getRole().equals("Agent") ){
			Agent a = new Agent(u.getCin(), u.getNom(), u.getPrenom(), u.getUsername(), u.getPassword(), u.getTelephone(), u.getVille(), u.getAdresse(), u.getDateNaissance(), u.getEmail(), u.getGenre());
			a.setCodeUtilisateur(u.getCodeUtilisateur());
			adminMetier.updateUtilisateur(a);
		}
		
		utilisateurModel.setNewOrModify(false);
		utilisateurModel.setUtilisateurs(adminMetier.getAllUtilisateurs());
		model.addAttribute("utilisateurModel",utilisateurModel);
		return "utilisateurs";
	}
	
	


	@RequestMapping(value="/comptes")
	public String comptes(Model model){
		CompteModel compteModel = new CompteModel();
		compteModel.setComptes(adminMetier.getAllComptes());
		model.addAttribute("compteModel",compteModel);
		return "comptes";
	}
	
	
	private List<Client> getClientsByCINs(String CINs){
		List<Client> clients = new ArrayList<Client>();
		CINs = CINs.trim();
		String[] tableCins = CINs.split(";");
		for( int i = 0 ; i < tableCins.length ; i++){
			clients.add((Client)adminMetier.getUtilisateurByCin(tableCins[i].trim()));
			System.out.println(clients.get(i).getCodeUtilisateur()+"\n==========================");
		}
		return clients;
	}
	
	
	private String getCINsByClients( List<Client> clients){
		String CINs = "";
		for(Client c:clients){
			CINs = CINs+c.getCin()+";";
		}
		return CINs.substring(0, CINs.length()-1);
	}
	
	@RequestMapping(value="/comptes/new")
	public String addCompte(CompteModel compteModel,Model model){
		Compte c = compteModel.getNewCompte();
		c.setDateCreation(new Date());
		c.setClients(this.getClientsByCINs(compteModel.getClientsCINs()));
		boolean test = false;
		if(compteModel.getType().equals("courant"))
			test = adminMetier.addCompteCourant(new CompteCourant(c.getCode(), c.getDateCreation(), c.getSolde(), 0,c.getAgent(),c.getClients(),c.isActive()));
		else if( compteModel.getType().equals("epargne") )
			test = adminMetier.addCompteEpargne(new CompteEpargne(c.getCode(), c.getDateCreation(), c.getSolde(), 0,c.getAgent(),c.getClients(),c.isActive()));
			
		if(test) compteModel.setMessage("Compte est ajouté");
		else compteModel.setMessage("Compte n'est pas ajouté");
		compteModel.setComptes(adminMetier.getAllComptes());
		model.addAttribute("compteModel",compteModel);
		return "comptes";
	}
	
	
	@RequestMapping(value="/comptes/remove",method=RequestMethod.GET)
	public String removeCompte(CompteModel compteModel,Model model,@RequestParam long ref){
		adminMetier.removeCompte(ref);
		compteModel.setMessage("Compte est supprimée");
		compteModel.setComptes(adminMetier.getAllComptes());
		model.addAttribute("compteModel",compteModel);
		return "comptes";
	}
	
	
	@RequestMapping(value="/comptes/modify",method=RequestMethod.GET)
	public String modifyCompte(CompteModel compteModel,Model model,@RequestParam long ref){
		compteModel.setNewOrModify(true);
		Compte c = adminMetier.getCompte(ref);
		compteModel.setNewCompte(c);
		compteModel.setType(c.toString());
		compteModel.setClientsCINs(this.getCINsByClients(c.getClients()));
		compteModel.setComptes(adminMetier.getAllComptes());
		model.addAttribute("compteModel",compteModel);
		return "comptes";
	}
	
	
	@RequestMapping(value="/comptes/postModify")
	public String postModifyCompte(CompteModel compteModel,Model model){
		compteModel.setNewOrModify(false);
		Compte c = compteModel.getNewCompte();
		if(compteModel.getType().equals("Compte courant")){
			CompteCourant cc = (CompteCourant)adminMetier.getCompte(c.getCode());
			cc.setSolde(c.getSolde());
			cc.setAgent(c.getAgent());
			cc.setActive(c.isActive());
			cc.setClients(this.getClientsByCINs(compteModel.getClientsCINs()));
			adminMetier.updateCompte(cc);
		}else if( compteModel.getType().equals("Compte epargne") ){
			CompteEpargne ce = (CompteEpargne)adminMetier.getCompte(c.getCode());
			ce.setSolde(c.getSolde());
			ce.setAgent(c.getAgent());
			ce.setActive(c.isActive());
			ce.setClients(this.getClientsByCINs(compteModel.getClientsCINs()));
			adminMetier.updateCompte(ce);
		}
		compteModel.setComptes(adminMetier.getAllComptes());
		model.addAttribute("compteModel",compteModel);
		return "comptes";
	}
	
	
	

}
