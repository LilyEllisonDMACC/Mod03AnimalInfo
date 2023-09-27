/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 6, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AnimalList;


/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 6, 2023
 */
public class ListAnimalHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AnimalInfo");

	/**
	 * @param toAdd
	 */
	public void insertAnimal(AnimalList toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();		
	}
	
	/**
	 * @return
	 */
	public List<AnimalList> showAllAnimals() {
		EntityManager em = emfactory.createEntityManager();
		List<AnimalList> allAnimals = em.createQuery("SELECT a FROM AnimalList a").getResultList();
		return allAnimals;
	}

	/**
	 * @param toDelete
	 */
	public void deleteAnimal(AnimalList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AnimalList> typedQuery = em.createQuery("select al from AnimalList al where al.name = :selectedName and al.species = :selectedSpecies", AnimalList.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		
		typedQuery.setMaxResults(1);
		
		AnimalList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();		
	}

	/**
	 * @param animalName
	 * @return
	 */
	public List<AnimalList> searchForAnimalByName(String animalName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AnimalList> typedQuery = em.createQuery("select al from AnimalList al where al.name = :selectedName", AnimalList.class);
		typedQuery.setParameter("selectedName", animalName);
		
		List<AnimalList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}

	/**
	 * @param speciesName
	 * @return
	 */
	public List<AnimalList> searchForAnimalBySpecies(String speciesName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AnimalList> typedQuery = em.createQuery("select al from AnimalList al where al.species = :selectedSpecies", AnimalList.class);
		typedQuery.setParameter("selectedSpecies", speciesName);
		
		List<AnimalList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public AnimalList searchForAnimalById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AnimalList found = em.find(AnimalList.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateAnimal(AnimalList toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * 
	 */
	public void cleanUp() {
		emfactory.close();
	}


}
