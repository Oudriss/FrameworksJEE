package uh1.ac.ma.metier.entities;

/***********************************************************************
 * Module:  Client.java
 * Author:  soufiane
 * Purpose: Defines the Class Client
 ***********************************************************************/

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur {
  
	
	@Transient
	private static final long serialVersionUID = 1L;
	@ManyToMany(mappedBy="clients",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Compte> comptes;
	@ManyToOne
  	@JoinColumn(name="codeAgence")
	private Agence agence;
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Client(long code) {
		super(code);
		// TODO Auto-generated constructor stub
	}


	public Client(String cin, String nom, String prenom, String username, String password, String telephone,
			String ville, String adresse, Date dateNaissance, String email, char genre) {
		super(cin, nom, prenom, username, password, telephone, ville, adresse, dateNaissance, email, genre);
		// TODO Auto-generated constructor stub
	}


	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	@Override
	public String toString() {
		return "Client";
	}
	
	
}