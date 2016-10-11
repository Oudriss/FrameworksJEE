package uh1.ac.ma.metier.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/***********************************************************************
 * Module:  CompteEpargne.java
 * Author:  soufiane
 * Purpose: Defines the Class CompteEpargne
 ***********************************************************************/


@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private static final long serialVersionUID = 1L;
	private double taux;

	public CompteEpargne() {
		super();
	}
	
	public CompteEpargne(long code, Date dateCreation, Double solde,double taux,Agent agent,List<Client> clients,boolean active) {
		super(code, dateCreation, solde,agent,clients,active);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
   
	@Override
	public String toString() {
		return "Compte epargne";
	}
	
	

}