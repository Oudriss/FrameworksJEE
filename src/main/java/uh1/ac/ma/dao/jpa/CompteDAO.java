 package uh1.ac.ma.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Agence;
import uh1.ac.ma.metier.entities.Compte;


public class CompteDAO implements ObjectDAO  {

	@PersistenceContext
	private EntityManager em; 
	
	public void addObject(Object o) {
		Compte c = (Compte) o;
		em.persist(c); 
	}
	

	public void removeObject(Object o) {
		Compte c = (Compte) o;
		em.remove(c);
	}

	
	public void updateObject(Object o) {
		Compte c = (Compte) o;
		em.merge(c);
	}

	@SuppressWarnings("unchecked")
	public Compte getObject(long code) {
		Compte c =  em.find(Compte.class,code);
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getAllObjects() {
		Query req=em.createQuery("select c from Compte c");
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getObjectsByType(String type) {
		Query req=em.createQuery("select c from Compte c where typeCompte='"+type+"'");
		return req.getResultList();
	}


	public <T> List<T> getObjectsByCriteres(List<String> criteres) {
		// TODO Auto-generated method stub
		return null;
	}

}
