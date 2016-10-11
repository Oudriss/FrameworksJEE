package uh1.ac.ma.dao;

import java.util.List;


/**
 * Tout les objets DAO (Data Access Object) doivent implémenter cette interface 
 * Elle sert à injecter les objets de la couche DAO (que sa soit JPA ou Hibernate) dans la couche métier
 * @author dictator
 *
 */
public interface ObjectDAO {

	/**
	 * Ajouter un objet o
	 * @param o : objet
	 */
	public void addObject(Object o);
	/**
	 * Supprimer un objet o
	 * @param o : objet
	 */
	public void removeObject(Object o);
	/**
	 * Mettre à jour un objet o
	 * @param o : objet
	 */
	public void updateObject(Object o);
	/**
	 * Recuperer l'objet qui a ID = code
	 * @param code
	 * @return objet
	 */
	public <T> T getObject(long code);
	/**
	 * Recuperer tout les objets
	 * @return liste des objets
	 */
	public <T> List<T> getAllObjects();
	/**
	 * Recuperer les objets qui respectent les criteres donnés dans la liste
	 * @param criteres : liste des criteres
	 * @return liste des objets
	 */
	public <T> List<T> getObjectsByCriteres(List<String> criteres);
	/**
	 * Recuprer l'objet
	 * @param type
	 * @return liste des objets
	 */
	public <T> List<T> getObjectsByType(String type);
	
}
