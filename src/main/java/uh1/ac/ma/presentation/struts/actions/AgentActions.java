package uh1.ac.ma.presentation.struts.actions;


import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;


import uh1.ac.ma.metier.services.IAgentServices;
import uh1.ac.ma.presentation.allModels.CompteModel;
import uh1.ac.ma.presentation.allModels.OperationModel;

public class AgentActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAgentServices agentMetier;
	
	private CompteModel compteModel;
	private OperationModel operationModel;
	private long ref;
	
	
	public void setAgentMetier(IAgentServices agentMetier) {
		this.agentMetier = agentMetier;
	}

	
	
	
	
}
