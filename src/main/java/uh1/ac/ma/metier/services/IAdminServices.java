package uh1.ac.ma.metier.services;

import java.util.List;

import uh1.ac.ma.metier.entities.Agence;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.CompteCourant;
import uh1.ac.ma.metier.entities.CompteEpargne;
import uh1.ac.ma.metier.entities.Utilisateur;

public interface IAdminServices {
	
	public boolean addUtilisateur(Utilisateur u);
	public boolean removeUtilisateur(long code);
	public boolean updateUtilisateur(Utilisateur u);
	public Utilisateur getUtilisateur(long code);
	public Utilisateur getUtilisateurByCin(String cin);
	public List<Utilisateur> getAllUtilisateurs();
	
	public boolean addAgence(Agence a);
	public boolean removeAgence(long code);
	public boolean updateAgence(Agence a);
	public Agence getAgence(long code);
	public List<Agence> getAllAgences();
	
	public boolean addCompteCourant(CompteCourant compte);
	public boolean addCompteEpargne(CompteEpargne compte);
	public boolean removeCompte(long code);
	public boolean updateCompte(Compte c);
	public Compte getCompte(long code);
	public List<Compte> getAllComptes();
	
}
