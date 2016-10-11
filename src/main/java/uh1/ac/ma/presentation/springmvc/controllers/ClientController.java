package uh1.ac.ma.presentation.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uh1.ac.ma.metier.entities.Client;
import uh1.ac.ma.presentation.allModels.ClientModel;
import utils.SessionBean;

@Controller
@Scope("session")
public class ClientController {

	@Autowired
	private SessionBean sessionBean;
	
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	@RequestMapping(value="/client/mesComptes")
	public String mesComptes(ClientModel clientModel,Model model){
		clientModel.setComptes(((Client)sessionBean.getUtilisateur()).getComptes());
		model.addAttribute("clientModel",clientModel);
		return "mesComptes";
	}
	
	@RequestMapping(value="/client/mesOperations")
	public String mesOperations(ClientModel clientModel,Model model){
		clientModel.setComptes(((Client)sessionBean.getUtilisateur()).getComptes());
		model.addAttribute("clientModel",clientModel);
		return "mesOperations";
	}
	
	
}
