package uh1.ac.ma.metier.services;


import java.util.List;

import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Operation;

public interface IAgentServices {

	public boolean verser(Compte compte, double montant);
	public boolean retirer(Compte compte, double montant);
	public boolean virement(Compte emetteur,Compte recepteur, double montant);
	
	public List<Operation> getAllOperations();
	public boolean removeOperation(long code);
	
	
	
}
