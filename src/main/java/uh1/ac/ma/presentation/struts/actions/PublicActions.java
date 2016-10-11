package uh1.ac.ma.presentation.struts.actions;



import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import uh1.ac.ma.metier.services.IAuthentificationServices;
import uh1.ac.ma.presentation.allModels.AuthentificationModel;

public class PublicActions extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAuthentificationServices authentificationMetier;
	
	private AuthentificationModel authModel;

	public void setAuthentificationMetier(IAuthentificationServices authentificationMetier) {
		this.authentificationMetier = authentificationMetier;
	}
	
	public String connecter(){
//		if(authentificationMetier.connecter(authModel.getUsername(),authModel.getPassword()))
//			authModel.setMessage("OK");
//		else authModel.setMessage("Erreur !!");
		return SUCCESS;
	}
	
	
}
