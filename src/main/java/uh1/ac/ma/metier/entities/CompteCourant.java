package uh1.ac.ma.metier.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/***********************************************************************
 * Module:  CompteCourant.java
 * Author:  soufiane
 * Purpose: Defines the Class CompteCourant
 ***********************************************************************/


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
 
	private static final long serialVersionUID = 1L;
	private double decouvert;
	private double soldeMax;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(long code, Date dateCreation, Double solde, double decouvert,Agent agent,List<Client> clients,boolean active) {
		super(code, dateCreation, solde,agent,clients,active);
		this.decouvert = decouvert;
	}

	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}

	public double getSoldeMax() {
		return soldeMax;
	}

	public void setSoldeMax(double soldeMax) {
		this.soldeMax = soldeMax;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "Compte courant";
	}
	
	
	

}