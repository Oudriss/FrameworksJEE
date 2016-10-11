package uh1.ac.ma.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;


import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Agence;


public class AgenceDAO implements ObjectDAO {

	@PersistenceContext(unitName = "MyPersistenceUnit",type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	public void addObject(Object o) {
		Agence a = (Agence) o;
		em.persist(a); 
	}
	

	public void removeObject(Object o) {
		Agence a = (Agence) o;
		em.remove(a);
	}

	
	public void updateObject(Object o) {
		Agence a = (Agence) o;
		em.merge(a);
	}

	@SuppressWarnings("unchecked")
	public Agence getObject(long code) {
		Agence a =  em.find(Agence.class,code);
		return a;
	}


	@SuppressWarnings("unchecked")
	public List<Agence> getAllObjects() {
		Query req = em.createQuery("select a from Agence a");
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getObjectsByType(String type) {
		Query req=em.createQuery("select a from Agence a");
		return req.getResultList();
	}


	public <T> List<T> getObjectsByCriteres(List<String> criteres) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
