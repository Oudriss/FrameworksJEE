package uh1.ac.ma.metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  soufiane
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/


@Entity
@Table(name="UTILISATEURS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ROLE")
public class Utilisateur implements Serializable {
  
	@Transient
   private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private long codeUtilisateur;
   private String cin;
   private String nom;
   private String prenom;
   private String username;
   private String password;
   private String telephone;
   private String ville;
   private String adresse;
   @DateTimeFormat(pattern = "dd/MM/yyyy")
   private Date dateNaissance;
   private String email;
   private char genre;
   
   
   
   
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(long code) {
		this.codeUtilisateur = code;
	}

	
	
	public Utilisateur(String cin, String nom, String prenom, String username, String password, String telephone,
			String ville, String adresse, Date dateNaissance, String email, char genre) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.ville = ville;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.genre = genre;
	}

	public long getCodeUtilisateur() {
		return codeUtilisateur;
	}
	public void setCodeUtilisateur(long codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}
	
	
	
	
	   
   
   
   
  
}