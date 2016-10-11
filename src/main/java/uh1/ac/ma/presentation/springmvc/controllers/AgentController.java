package uh1.ac.ma.presentation.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import uh1.ac.ma.metier.services.IAgentServices;
import uh1.ac.ma.presentation.allModels.OperationModel;

@Controller
@Scope("session")
public class AgentController{

	@Autowired
	private IAgentServices agentMetier;
	
	
	public void setAgentMetier(IAgentServices agentMetier) {
		this.agentMetier = agentMetier;
	}

	
	@RequestMapping(value="/operations")
	public String operations(OperationModel operationModel,Model model){
		operationModel.setOperations(agentMetier.getAllOperations());
		model.addAttribute("operationModel", operationModel);
		return "operations";
	}
	
	@RequestMapping(value="/operations/verser")
	public String verser(OperationModel operationModel,Model model){
		operationModel.setOperations(agentMetier.getAllOperations());
		if( agentMetier.verser(operationModel.getRecepteur(), operationModel.getMontant()))
			operationModel.setMessage("L'operation est effectuée");
		else operationModel.setMessage("L'operation n'est pas effectuée");
		model.addAttribute("operationModel",operationModel);
		return "operations";
	}
	
	
	@RequestMapping(value="/operations/retirer")
	public String retirer(OperationModel operationModel,Model model){
		operationModel.setOperations(agentMetier.getAllOperations());
		if( agentMetier.retirer(operationModel.getRecepteur(), operationModel.getMontant()))
			operationModel.setMessage("L'operation est effectuée");
		else operationModel.setMessage("L'operation n'est pas effectuée");
		model.addAttribute("operationModel",operationModel);
		return "operations";
	}
	
	@RequestMapping(value="/operations/virement")
	public String virement(OperationModel operationModel,Model model){
		operationModel.setOperations(agentMetier.getAllOperations());
		if( agentMetier.virement(operationModel.getEmetteur(),operationModel.getRecepteur(), operationModel.getMontant()))
			operationModel.setMessage("L'operation est effectuée");
		else operationModel.setMessage("L'operation n'est pas effectuée");
		model.addAttribute("operationModel",operationModel);
		return "operations";
	}
	
	@RequestMapping(value="/operations/remove",method=RequestMethod.GET)
	public String removeAgence(OperationModel operationModel,Model model,@RequestParam long ref){
		agentMetier.removeOperation(ref);
		operationModel.setOperations(agentMetier.getAllOperations());
		operationModel.setMessage("Operation est supprimée");
		model.addAttribute("operationModel",operationModel);
		return "operations";
	}
	
	
	
	
	
	
}
