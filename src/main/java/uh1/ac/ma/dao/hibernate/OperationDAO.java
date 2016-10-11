package uh1.ac.ma.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Operation;
import utils.HibernateUtil;

/**
 * Le rôle de cette classe est de persister l'objet de type Operation
 * @author dictator
 *
 */
public class OperationDAO implements ObjectDAO  {

	private Session session;
	
	
	public void addObject(Object o) {
		Operation op = (Operation) o;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(op);
		session.getTransaction().commit();
	}
	

	public void removeObject(Object o) {
		Operation op = (Operation) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(op);
		session.getTransaction().commit();
	}

	
	public void updateObject(Object o) {
		Operation op = (Operation) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(op);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Operation getObject(long code) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Operation op = (Operation) session.get(Operation.class, code);
		session.getTransaction().commit();
		return op;
	}


	@SuppressWarnings("unchecked")
	public List<Operation> getAllObjects() {
		List<Operation> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req =  session.createQuery("from Operation");
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}
	
	@SuppressWarnings("unchecked")
	public List<Operation> getObjectsByType(String type) {
		List<Operation> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("from Utilisateur where cin := c");
		req.setParameter("c", type);
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}


	public <T> List<T> getObjectsByCriteres(List<String> criteres) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
