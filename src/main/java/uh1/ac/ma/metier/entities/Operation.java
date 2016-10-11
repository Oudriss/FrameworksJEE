package uh1.ac.ma.metier.entities;

import java.io.Serializable;

/***********************************************************************
 * Module:  Operation.java
 * Author:  soufiane
 * Purpose: Defines the Class Operation
 ***********************************************************************/

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="OPERATIONS")
public class Operation implements Serializable {
	

	@Transient
   private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;
   private Date dateOperation;
   private Double montant;
   private char type;
   @ManyToOne
   @JoinColumn(name="codeCompteEmetteur")
   private Compte compteEmetteur;
   @ManyToOne
   @JoinColumn(name="codeCompteRecepeteur")
   private Compte compteRecepteur;
   
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Operation( Date dateOperation, Double montant, char type) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public int getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public Compte getCompteEmetteur() {
		return compteEmetteur;
	}
	public void setCompteEmetteur(Compte compteEmetteur) {
		this.compteEmetteur = compteEmetteur;
	}
	public Compte getCompteRecepteur() {
		return compteRecepteur;
	}
	public void setCompteRecepteur(Compte compteRecepteur) {
		this.compteRecepteur = compteRecepteur;
	}

}