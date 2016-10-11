package uh1.ac.ma.presentation.allModels;

import java.util.List;

import uh1.ac.ma.metier.entities.Client;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Operation;

public class ClientModel {
	
	private Client client;
	private List<Operation> operations;
	private List<Compte> comptes;
	private String message;
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
