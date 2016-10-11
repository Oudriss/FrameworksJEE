package uh1.ac.ma.presentation.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import uh1.ac.ma.metier.services.IAuthentificationServices;
import uh1.ac.ma.presentation.allModels.AuthentificationModel;
import utils.SessionBean;

@Controller
@Scope("session")
@SessionAttributes("sessionBean")
public class PublicController {
	
	
	
	@Autowired
	private IAuthentificationServices authentificationMetier;
	@Autowired
	private SessionBean sessionBean;

	
	
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}


	public void setAuthentificationMetier(IAuthentificationServices authentificationMetier) {
		this.authentificationMetier = authentificationMetier;
	}
	
	
	@RequestMapping(value="/")
	public String authentification(AuthentificationModel authModel,Model model){
		return "authentification";
	}
	
	@RequestMapping(value="/connecter")
	public String connecter(AuthentificationModel authModel,Model model){
		sessionBean.setUtilisateur(authentificationMetier.connecter(authModel.getUsername(),authModel.getPassword()));
		if( sessionBean.getUtilisateur() != null){
			sessionBean.setRole(sessionBean.getUtilisateur().toString());
			authModel.setMessage("OK");
			model.addAttribute("authModel", authModel);
			model.addAttribute("sessionBean", sessionBean);
			return "index";		
		}else{ 
			authModel.setMessage("Erreur !!");
			System.out.println("Erreur");
			return "authentification";
		}
	}
	
	@RequestMapping(value="/deconnecter")
	public String deconnecter(AuthentificationModel authModel,Model model){
		if( sessionBean.getUtilisateur() != null){
			sessionBean = new SessionBean();
			model.addAttribute("sessionBean", sessionBean);
			return "authentification";		
		}else{ 
			authModel.setMessage("Erreur !!");
			System.out.println("Erreur");
			return "index";
		}
	}
	
	
	
}
