package uh1.ac.ma.metier.entities;

import java.io.Serializable;

/***********************************************************************
 * Module:  Compte.java
 * Author:  soufiane
 * Purpose: Defines the Class Compte
 ***********************************************************************/

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="COMPTES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte",discriminatorType=DiscriminatorType.STRING,length=2)
public class Compte implements Serializable {

	@Transient
   private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
   private long codeCompte;
   private Date dateCreation;
   private double solde;
   private boolean active;
   	 @ManyToMany(fetch = FetchType.EAGER)
   	 @JoinTable(name="mesComptes",joinColumns=@JoinColumn(name="codeCompte"),inverseJoinColumns=@JoinColumn(name="codeUtilisateur"))
   	@Fetch(value = FetchMode.SUBSELECT)
   private List<Client> clients;
   	 @ManyToOne
   	 @JoinColumn(name="codeUtilisateur")
   private Agent agent;
   	 @OneToMany(mappedBy="compteEmetteur",fetch = FetchType.EAGER)
   	@Fetch(value = FetchMode.SUBSELECT)
   private List<Operation> operationsEmis;
   	 @OneToMany(mappedBy="compteRecepteur",fetch = FetchType.EAGER)
   	@Fetch(value = FetchMode.SUBSELECT)
   private List<Operation> operationsRecu;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(long code) {
		this.codeCompte = code;
	}
	public Compte(long code, Date dateCreation, double solde,Agent agent,List<Client> clients,boolean active) {
		super();
		this.codeCompte = code;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.agent = agent;
		this.clients = clients;
		this.active = active;
	}
	public long getCode() {
		return codeCompte;
	}
	public void setCode(long code) {
		this.codeCompte = code;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public long getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(long codeCompte) {
		this.codeCompte = codeCompte;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public List<Operation> getOperationsEmis() {
		return operationsEmis;
	}
	public void setOperationsEmis(List<Operation> operationsEmis) {
		this.operationsEmis = operationsEmis;
	}
	public List<Operation> getOperationsRecu() {
		return operationsRecu;
	}
	public void setOperationsRecu(List<Operation> operationsRecu) {
		this.operationsRecu = operationsRecu;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	   
   
   
   

}