package uh1.ac.ma.presentation.jsf.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import uh1.ac.ma.metier.services.IClientServices;
import uh1.ac.ma.presentation.allModels.ClientModel;

@ManagedBean(name="clientMB")
@RequestScoped
public class ClientMB {

	@Autowired
	private IClientServices clientMetier;
	
	private ClientModel clientModel;
	
	public void setClientMetier(IClientServices clientMetier) {
		this.clientMetier = clientMetier;
	}

	public String mesComptes(){
		clientModel.setOperations(clientMetier.getOperations(clientModel.getClient()));
		return "success";
	}
	

	public String mesOperations(){
		clientModel.setComptes(clientMetier.getComptes(clientModel.getClient()));
		return "success";
	}
	
	
}
