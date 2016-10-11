package uh1.ac.ma.presentation.allModels;

import java.util.List;

import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Operation;

public class OperationModel {
	
	private List<Operation> operations;
	private double montant;
	private Compte emetteur;
	private Compte recepteur;
	private String message;
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Compte getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Compte emetteur) {
		this.emetteur = emetteur;
	}
	public Compte getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(Compte recepteur) {
		this.recepteur = recepteur;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
	
}
