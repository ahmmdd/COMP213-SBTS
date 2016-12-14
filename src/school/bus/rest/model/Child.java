package school.bus.rest.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;


@Entity
public class Child implements Serializable {


	//********************************
	//  PRIVATE GLOBAL VARIABLES 
	//********************************
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String name;


	//********************************
	//  CONSTRUCTORS 
	//********************************
	public Child()
	{	
	}

	/**
	 * Creates a new instance of a child and adds it into the hashmap
	 * @param id The id of the child
	 * @param name The name of child
	 * @return Nothing
	 */
	public Child(int id, String name){
		this.id = id;
		this.name = name;

		//Add child to map
		//Child.childMap.put(id, this);
	}

	/**
	 * Retrieves the id of the current instance of a child.
	 * @param None
	 * @return child Id 
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Retrieves the id of the current instance of a child object.
	 * @param None
	 * @return child Id 
	 */
	public void setId(final int id) {
		this.id = id;
	}


	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	/**
	 * Compares this instance of a child object with obj
	 * @param obj: Instance of child object to compare with
	 * @return 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Child)) {
			return false;
		}
		Child other = (Child) obj;

		if (this.id != other.id)
		{
			return false;
		}
		return true;
	}



	/**
	 * Retrieves the name of this child instance 
	 * @param None
	 * @return String name of this child instance
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this child instance  
	 * @param name: String name
	 * @return None
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (name != null && !name.trim().isEmpty())
			result += "name: " + name;
		return result;
	}
}