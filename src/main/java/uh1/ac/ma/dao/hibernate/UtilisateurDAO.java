package uh1.ac.ma.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import uh1.ac.ma.dao.ObjectDAO;
import uh1.ac.ma.metier.entities.Utilisateur;
import utils.HibernateUtil;

/**
 * Le rôle de cette classe est de persister l'objet de type Utilisateur
 * @author dictator
 *
 */
public class UtilisateurDAO implements ObjectDAO  {

	/**
	 * La session de hibernate : sert à persister les objet dans une base de données relationelle
	 */
	private Session session;
	
	
	/**
	 * Ajouter un utilisateur
	 */
	public void addObject(Object o) {
		Utilisateur u = (Utilisateur) o;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
	}
	

	/**
	 * Supprimer un utilisateur
	 */
	public void removeObject(Object o) {
		Utilisateur u = (Utilisateur) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
	}

	
	/**
	 * Mettre à jour un utilisateur
	 */
	public void updateObject(Object o) {
		Utilisateur u = (Utilisateur) o;		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(u);
		session.getTransaction().commit();
	}
	
	/**
	 * Recuperer l'utilisateur qui le code = code 
	 */
	@SuppressWarnings("unchecked")
	public Utilisateur getObject(long code) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Utilisateur u = (Utilisateur) session.get(Utilisateur.class, code);
		if( u == null) throw new RuntimeException("Agence introuvable");
		session.getTransaction().commit();
		return u;
	}


	/**
	 * Recuperer tout les utilisateurs
	 */
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllObjects() {
		List<Utilisateur> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req =  session.createQuery("from Utilisateur");
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}
	
	
	/**
	 * Recuperer l'utilisateur qui a le cin = type
	 */
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getObjectsByType(String type) {
		List<Utilisateur> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("from Utilisateur where cin='"+type+"'");
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}


	/**
	 * Recuperer les utilisateur qui respectent les criteres données dans la liste criteres
	 * dans ce cas username te password
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <Utilisateur> List<Utilisateur> getObjectsByCriteres(List<String> criteres) {
		List<Utilisateur> liste;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("from Utilisateur where username='"+criteres.get(0)+"' and password='"+criteres.get(1)+"'");
		liste = req.list();
		session.getTransaction().commit();
		return liste;
	}
	

}
