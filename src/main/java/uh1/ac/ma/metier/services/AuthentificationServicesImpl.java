package uh1.ac.ma.metier.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Utilisateur;

@Transactional
public class AuthentificationServicesImpl implements IAuthentificationServices {

	private ObjectDAO dao;
	
	
	
	public void setDao(ObjectDAO dao) {
		this.dao = dao;
	}

	public Utilisateur connecter(String username, String password) {
		List<String> criteres = new ArrayList<String>() ;
		criteres.add(username);criteres.add(password);
		List<Utilisateur> users = dao.getObjectsByCriteres(criteres) ;
		if( users.size() > 0) return users.get(0);
		else return null;
	}

	
	public boolean deconnecter(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
