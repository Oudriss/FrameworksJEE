package uh1.ac.ma.metier.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/***********************************************************************
 * Module:  Agent.java
 * Author:  soufiane
 * Purpose: Defines the Class Agent
 ***********************************************************************/

@Entity
@DiscriminatorValue("agent")
public class Agent extends Utilisateur {

	@Transient
	private static final long serialVersionUID = 1L;
	@ManyToOne
  	@JoinColumn(name="codeAgence")
	private Agence agence;

	
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Agent(long code) {
		super(code);
		// TODO Auto-generated constructor stub
	}





	public Agent(String cin, String nom, String prenom, String username, String password, String telephone,
			String ville, String adresse, Date dateNaissance, String email, char genre) {
		super(cin, nom, prenom, username, password, telephone, ville, adresse, dateNaissance, email, genre);
		// TODO Auto-generated constructor stub
	}





	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	@Override
	public String toString() {
		return "Agent";
	}

	
}
