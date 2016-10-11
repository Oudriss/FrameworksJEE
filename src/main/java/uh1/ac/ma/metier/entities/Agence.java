package uh1.ac.ma.metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/***********************************************************************
 * Module:  Agence.java
 * Author:  soufiane
 * Purpose: Defines the Class Agence
 ***********************************************************************/


@Entity
@Table(name="AGENCES")
public class Agence implements Serializable {
	

	@Transient
   private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long codeAgence;
   private String adresse;
   private String ville;
   @ManyToOne
   @JoinColumn(name="codeUtilisateur")
   private Adminstrateur admin;
	
	@OneToMany(mappedBy="agence",fetch=FetchType.LAZY)
   private List<Client> clients;
	@OneToMany(mappedBy="agence",fetch=FetchType.LAZY)
   private List<Agent> agents;
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agence(long code) {
		super();
		this.codeAgence = code;
	}
	
	public Agence(String adresse,String ville) {
		super();
		this.adresse = adresse;
		this.ville = ville;
	}

	public Long getCodeAgence() {
		return codeAgence;
	}
	public void setCodeAgence(Long codeAgence) {
		this.codeAgence = codeAgence;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setCodeAgence(long codeAgence) {
		this.codeAgence = codeAgence;
	}
	public Adminstrateur getAdmin() {
		return admin;
	}
	public void setAdmin(Adminstrateur admin) {
		this.admin = admin;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agence other = (Agence) obj;
		if (codeAgence != other.codeAgence)
			return false;
		return true;
	}
	
	
	
	
	
   
   
   
}