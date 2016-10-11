package uh1.ac.ma.presentation.allModels;

import java.util.List;

import uh1.ac.ma.metier.entities.Compte;

public class CompteModel {

	private List<Compte> comptes;
	private Compte newCompte;
	private String message;
	private boolean newOrModify = false;
	private String type;
	private String clientsCINs;
	
	
	
	public CompteModel() {
		newOrModify = false;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Compte getNewCompte() {
		return newCompte;
	}
	public void setNewCompte(Compte newCompte) {
		this.newCompte = newCompte;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClientsCINs() {
		return clientsCINs;
	}
	public void setClientsCINs(String clientsCINs) {
		this.clientsCINs = clientsCINs;
	}
	
	
	
}
