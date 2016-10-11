package uh1.ac.ma.presentation.allModels;

import java.util.List;

import uh1.ac.ma.metier.entities.Utilisateur;

public class UtilisateurModel {
	
	private List<Utilisateur> utilisateurs;
	private Utilisateur newUtilisateur;
	private String message;
	private boolean newOrModify;
	private String role;
	private String dateNaissance;
	
	public UtilisateurModel(){
		this.newOrModify = false;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Utilisateur getNewUtilisateur() {
		return newUtilisateur;
	}
	public void setNewUtilisateur(Utilisateur newUtilisateur) {
		this.newUtilisateur = newUtilisateur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isNewOrModify() {
		return newOrModify;
	}
	public void setNewOrModify(boolean newOrModify) {
		this.newOrModify = newOrModify;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	

}
