package uh1.ac.ma.presentation.jsf.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;


import uh1.ac.ma.metier.services.IAgentServices;
import uh1.ac.ma.presentation.allModels.CompteModel;
import uh1.ac.ma.presentation.allModels.OperationModel;

@ManagedBean(name="agentMB")
@RequestScoped
public class AgentMB{

	@Autowired
	private IAgentServices agentMetier;
	
	/*private CompteModel compteModel;
	private OperationModel operationModel;
	private long ref;
	*/
	
	public void setAgentMetier(IAgentServices agentMetier) {
		this.agentMetier = agentMetier;
	}

	
	
	
	
	
}
