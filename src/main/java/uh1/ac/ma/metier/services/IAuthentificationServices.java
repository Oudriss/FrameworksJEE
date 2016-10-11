package uh1.ac.ma.metier.services;

import uh1.ac.ma.metier.entities.Utilisateur;

public interface IAuthentificationServices   {

	public Utilisateur connecter(String username,String password);
	public boolean deconnecter(String username);
}

