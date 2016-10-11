package uh1.ac.ma.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Agence;
import uh1.ac.ma.metier.entities.Utilisateur;

public class UtilisateurDAO implements ObjectDAO  {

	@PersistenceContext
	private EntityManager em;
	
	public void addObject(Object o) {
		Utilisateur u = (Utilisateur) o;
		em.persist(u); 
	}
	

	public void removeObject(Object o) {
		Utilisateur u = (Utilisateur) o;
		em.remove(u);
	}

	
	public void updateObject(Object o) {
		Utilisateur u = (Utilisateur) o;
		em.merge(u);
	}

	@SuppressWarnings("unchecked")
	public Utilisateur getObject(long code) {
		// TODO Auto-generated method stub
		Utilisateur u =  em.find(Utilisateur.class,code);
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getAllObjects() {
		Query req=em.createQuery("select u from Utilisateur u");
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getObjectsByType(String type) {
		Query req=em.createQuery("select u from Utilisateur u where cin='"+type+"'");
		return req.getResultList();
	}


	@SuppressWarnings({ "unchecked", "hiding" })
	public <Utilisateur> List<Utilisateur> getObjectsByCriteres(List<String> criteres) {
		Query req=em.createQuery("select u from Utilisateur u where username='"+criteres.get(0)+"' and password='"+criteres.get(1)+"'");
		return req.getResultList();
	}

}
