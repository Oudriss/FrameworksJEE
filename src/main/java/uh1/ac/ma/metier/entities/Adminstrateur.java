package uh1.ac.ma.metier.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/***********************************************************************
 * Module:  Adminstrateur.java
 * Author:  soufiane
 * Purpose: Defines the Class Adminstrateur
 ***********************************************************************/

@Entity
@DiscriminatorValue("admin")
public class Adminstrateur extends Utilisateur {
	
	@Transient
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="admin",fetch=FetchType.LAZY)
	private List<Agence> agences;
	
	
	
	public Adminstrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Adminstrateur(long code) {
		super(code);
		// TODO Auto-generated constructor stub
	}



	public Adminstrateur(String cin, String nom, String prenom, String username, String password, String telephone,
			String ville, String adresse, Date dateNaissance, String email, char genre) {
		super(cin, nom, prenom, username, password, telephone, ville, adresse, dateNaissance, email, genre);
		// TODO Auto-generated constructor stub
	}



	public List<Agence> getAgences() {
		return agences;
	}
	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}



	@Override
	public String toString() {
		return "Adminstrateur";
	}
	
	
	

}