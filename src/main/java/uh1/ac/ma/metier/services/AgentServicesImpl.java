package uh1.ac.ma.metier.services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Operation;

@Transactional
public class AgentServicesImpl implements IAgentServices {

	private ObjectDAO compteDAO;
	private ObjectDAO operationDAO;
	


	public void setCompteDAO(ObjectDAO compteDAO) {
		this.compteDAO = compteDAO;
	}

	
	

	public void setOperationDAO(ObjectDAO operationDAO) {
		this.operationDAO = operationDAO;
	}
	
	
	

	public boolean verser(Compte compte, double montant) {
		compte = compteDAO.getObject(compte.getCodeCompte());
		if( compte != null && compte.isActive() ){
			Operation op = new Operation( new Date(), montant, 'v');
			op.setCompteRecepteur(compte);
			compte.setSolde(compte.getSolde()+montant); 
			compte.getOperationsRecu().add(op);
			operationDAO.addObject(op);
			compteDAO.updateObject(compte);
			return true;
		} else return false;
	}
	

	
	public boolean retirer(Compte compte, double montant) {
		compte = compteDAO.getObject(compte.getCodeCompte());
		if( compte != null && compte.isActive() && compte.getSolde() > montant ){
			Operation op = new Operation( new Date(), montant, 'r');
			op.setCompteRecepteur(compte);
			compte.setSolde(compte.getSolde()-montant); 
			compte.getOperationsRecu().add(op);
			operationDAO.addObject(op);
			compteDAO.updateObject(compte);
			return true;
		} else return false;
	}

	
	public boolean virement(Compte emetteur, Compte recepteur, double montant) {
		emetteur = compteDAO.getObject(emetteur.getCodeCompte());
		recepteur = compteDAO.getObject(recepteur.getCodeCompte());
		if( emetteur.isActive() && recepteur.isActive() && emetteur.getSolde() > montant ){
			Operation op = new Operation( new Date(), montant, 'i');
			op.setCompteEmetteur(emetteur);
			op.setCompteRecepteur(recepteur);
			emetteur.setSolde(emetteur.getSolde()-montant); 
			recepteur.setSolde(recepteur.getSolde()+montant);
			recepteur.getOperationsRecu().add(op);
			emetteur.getOperationsEmis().add(op);
			operationDAO.addObject(op);
			compteDAO.updateObject(emetteur);
			compteDAO.updateObject(recepteur);
			return true;
		}else return false;
	}

	
	
	public List<Operation> getAllOperations(){
		return operationDAO.getAllObjects();
	}




	public boolean removeOperation(long code) {
		Operation op = operationDAO.getObject(code);
		if( op != null){
			operationDAO.removeObject(op);
			return true;
		}else return false;
	}
	
	

}
