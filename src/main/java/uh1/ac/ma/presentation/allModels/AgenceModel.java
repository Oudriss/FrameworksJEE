package uh1.ac.ma.presentation.allModels;

import java.util.List;

import uh1.ac.ma.metier.entities.Agence;

public class AgenceModel {
	
	private List<Agence> agences;
	private Agence newAgence;
	private String message;
	private boolean newOrModify = false;
	
	

	public AgenceModel() {
		this.newOrModify = false;
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	public Agence getNewAgence() {
		return newAgence;
	}

	public void setNewAgence(Agence newAgence) {
		this.newAgence = newAgence;
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
	
	
	
	
	

}
