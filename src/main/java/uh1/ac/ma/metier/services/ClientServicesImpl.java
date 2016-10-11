package uh1.ac.ma.metier.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Client;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Operation;

@Transactional
public class ClientServicesImpl implements IClientServices {

	private ObjectDAO compteDAO;
	private ObjectDAO operationDAO;
	
	
	
	public void setCompteDAO(ObjectDAO compteDAO) {
		this.compteDAO = compteDAO;
	}


	public void setOperationDAO(ObjectDAO operationDAO) {
		this.operationDAO = operationDAO;
	}


	public List<Compte> getComptes(Client client) {
		List<String> criteres = new ArrayList<String>();
		criteres.add(String.valueOf(client.getCodeUtilisateur()));
		return compteDAO.getObjectsByCriteres(criteres);
	}

	
	public List<Operation> getOperations(Client client) {
		List<String> criteres = new ArrayList<String>();
		criteres.add(String.valueOf(client.getCodeUtilisateur()));
		return operationDAO.getObjectsByCriteres(criteres);
	}

}
