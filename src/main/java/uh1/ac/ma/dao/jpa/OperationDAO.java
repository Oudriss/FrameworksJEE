package uh1.ac.ma.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Agence;
import uh1.ac.ma.metier.entities.Operation;


public class OperationDAO implements ObjectDAO  {

	@PersistenceContext
	private EntityManager em;
	
	public void addObject(Object o) {
		Operation op = (Operation) o;
		em.persist(op); 
	}
	

	public void removeObject(Object o) {
		Operation op = (Operation) o;
		em.remove(op);
	}

	
	public void updateObject(Object o) {
		Operation op = (Operation) o;
		em.merge(op);
	}

	@SuppressWarnings("unchecked")
	public Operation getObject(long code) {
		Operation op =  em.find(Operation.class,code);
		return op;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getAllObjects() {
		Query req=em.createQuery("select op from Operation op");
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getObjectsByType(String type) {
		Query req=em.createQuery("select op from Operation op where type='"+type+"'");
		return req.getResultList();
	}


	public <T> List<T> getObjectsByCriteres(List<String> criteres) {
		// TODO Auto-generated method stub
		return null;
	}


}
