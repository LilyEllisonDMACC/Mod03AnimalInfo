/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 6, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 6, 2023
 */

@Entity
@Table(name="animals")
public class AnimalList {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="SPECIES")
	private String species;
	@Column(name="COND")
	private String condition;
	
	public AnimalList() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	public AnimalList(String name, String species, String condition) {
		super();
		this.name = name;
		this.species = species;
		this.condition = condition;
	}
	
	public String returnAnimalDetails() {
		return this.name + ", a " + this.species + " has " + this.condition;
	}

}
