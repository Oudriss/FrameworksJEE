package uh1.ac.ma.presentation.struts.actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import uh1.ac.ma.metier.services.IClientServices;
import uh1.ac.ma.presentation.allModels.ClientModel;

@ManagedBean(name="clientMB")
@RequestScoped
public class ClientActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IClientServices clientMetier;
	
	private ClientModel clientModel;
	
	public void setClientMetier(IClientServices clientMetier) {
		this.clientMetier = clientMetier;
	}

	public String mesComptes(){
		clientModel.setOperations(clientMetier.getOperations(clientModel.getClient()));
		return SUCCESS;
	}
	

	public String mesOperations(){
		clientModel.setComptes(clientMetier.getComptes(clientModel.getClient()));
		return SUCCESS;
	}
	
	
}
