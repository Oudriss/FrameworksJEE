package uh1.ac.ma.metier.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Agence;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.CompteCourant;
import uh1.ac.ma.metier.entities.CompteEpargne;
import uh1.ac.ma.metier.entities.Utilisateur;
import utils.Util;

@Transactional
public class AdminServicesImpl implements IAdminServices {

	private ObjectDAO utilisateurDAO;
	private ObjectDAO agenceDAO;
	private ObjectDAO compteDAO;
	
	

	public void setUtilisateurDAO(ObjectDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public void setAgenceDAO(ObjectDAO agenceDAO) {
		this.agenceDAO = agenceDAO;
	}
	

	public void setCompteDAO(ObjectDAO compteDAO) {
		this.compteDAO = compteDAO;
	}

	public AdminServicesImpl(){
		
	}
	
	public boolean addUtilisateur(Utilisateur u) {
		if(u != null){
			utilisateurDAO.addObject(u);
			return true;
		}else return false;
	}

	public boolean removeUtilisateur(long code) {
		utilisateurDAO.removeObject(utilisateurDAO.getObject(code));
		return true;
	}

	public boolean updateUtilisateur(Utilisateur u) {
		if(u != null){
			utilisateurDAO.updateObject(u);
			return true;
		}else return false;
	}

	public Utilisateur getUtilisateur(long code) {
		return utilisateurDAO.getObject(code);
	}

	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurDAO.getAllObjects();
	}


	public Utilisateur getUtilisateurByCin(String cin){
		return (Utilisateur) utilisateurDAO.getObjectsByType(cin).get(0);
	}
	
	public boolean addAgence(Agence a) {
		if( a != null){
			agenceDAO.addObject(a);
			return true;
		} else return false;
	}

	
	public boolean removeAgence(long code) {
		agenceDAO.removeObject(agenceDAO.getObject(code));
		return true;
	}

	public boolean updateAgence(Agence a) {
		agenceDAO.updateObject(a);
		return true;
	}

	public Agence getAgence(long code) {
		return agenceDAO.getObject(code);
	}
	
	public List<Agence> getAllAgences() {
		return agenceDAO.getAllObjects();
	}

	public boolean addCompteCourant(CompteCourant compteCourant) {
		if( compteCourant.getClients().size() <= 4 && Util.sontMajeurs(compteCourant.getClients())){
			compteCourant.setDecouvert(0);
			compteDAO.addObject(compteCourant);
			return true;
		}else return false;
	}
	
	
	
	public boolean addCompteEpargne(CompteEpargne compteEpargne) {
		if( compteEpargne.getClients().size() <= 4 && Util.sontFamille(compteEpargne.getClients())){
			compteEpargne.setTaux(Util.calculerTaux(compteEpargne.getClients()));
			compteDAO.addObject(compteEpargne);
			return true;
		}else return false;
	}
	
	
	public boolean removeCompte(long code) {
		compteDAO.removeObject(compteDAO.getObject(code));
		return true;
	}

	public boolean updateCompte(Compte c) {
		compteDAO.updateObject(c);
		return true;
	}

	public Compte getCompte(long code) {
		return compteDAO.getObject(code);
	}

	public List<Compte> getAllComptes() {
		return compteDAO.getAllObjects();
	}


	
}
