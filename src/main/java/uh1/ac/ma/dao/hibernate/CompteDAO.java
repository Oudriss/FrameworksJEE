package uh1.ac.ma.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Compte;
import uh1.ac.ma.metier.entities.Utilisateur;
import utils.HibernateUtil;

/**
 * Le rôle de cette classe est de persister l'objet de type Compte
 * @author dictator
 *
 */
public class CompteDAO implements ObjectDAO {

	private Session session;
	
	public void addObject(Object o) {
		Compte c = (Compte) o;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	

	public void removeObject(Object o) {
		Compte c = (Compte) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
	}

	
	public void updateObject(Object o) {
		Compte c = (Compte) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(c);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Compte getObject(long code) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Compte c = (Compte) session.get(Compte.class, code);
		session.getTransaction().commit();
		return c;
	}


	@SuppressWarnings("unchecked")
	public List<Compte> getAllObjects() {
		List<Compte> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req =  session.createQuery("from Compte");
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getObjectsByType(String type) {
		List<Utilisateur> liste;
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
