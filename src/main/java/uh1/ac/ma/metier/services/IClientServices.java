package uh1.ac.ma.metier.services;

import java.util.List;

import uh1.ac.ma.metier.entities.Client;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Operation;

public interface IClientServices  {
	
	
	public List<Compte> getComptes(Client client);
	public List<Operation> getOperations(Client client);
	

}
