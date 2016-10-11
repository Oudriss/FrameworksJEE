package uh1.ac.ma.presentation.jsf.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import uh1.ac.ma.metier.services.IAuthentificationServices;
import uh1.ac.ma.presentation.allModels.AuthentificationModel;

@ManagedBean(name="publicMB")
@RequestScoped
public class PublicMB {
	
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
		return "success";
	}
	
	
}
