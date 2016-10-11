package uh1.ac.ma.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Agence;
import utils.HibernateUtil;

/**
 * Le rôle de cette classe est de persister l'objet de type Agence
 * @author dictator
 *
 */
public class AgenceDAO implements ObjectDAO {

	private Session session;
	
	public void addObject(Object o) {
		Agence a = (Agence) o;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
	}
	

	public void removeObject(Object o) {
		Agence a = (Agence) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(a);
		session.getTransaction().commit();
	}

	
	public void updateObject(Object o) {
		Agence a = (Agence) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Agence getObject(long code) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Agence a = (Agence) session.get(Agence.class, code);
		//if( a == null) throw new RuntimeException("Agence introuvable");
		session.getTransaction().commit();
		return a;
	}


	@SuppressWarnings("unchecked")
	public List<Agence> getAllObjects() {
		List<Agence> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req =  session.createQuery("from Agence");
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agence> getObjectsByType(String type) {
		List<Agence> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("from Agence");
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
