package school.bus.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

public class User implements Serializable {
	
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
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	public User(){}
	
	/**
	 * Creates a new instance of user and adds it into the hashmap
	 * @param id The id of the user
	 * @param name The name of the user
	 * @param login The username of the user
	 * @param password The password of the user
	 * @return Nothing
	 */
	public User(int id, String name, String login, String password){
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;

		//Add user to map
		//User.userMap.put(id, this);
	}
	
	/**
	 * Retrieves the if of the current user
	 * @return user Id
	 */
	public int getId() { return this.id; }
	/**
	 * Retrieves the id of the current instance of a child object.
	 * @param None
	 * @return child Id 
	 */
	public void setId(final int id) { this.id = id; }
	
	public int getVersion() { return this.version; }

	public void setVersion(final int version) { this.version = version; }

	/**
	 * Compares this instance of a user object with obj
	 * @param obj: Instance of user object to compare with
	 * @return 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (!(obj instanceof Child)) { return false; }
		User other = (User) obj;
		if (this.id != other.id) { return false; }
		return true;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getLogin() { return login; }
	public void setLogin(String login) { this.login = login; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (name != null && !name.trim().isEmpty()){
			result += "name: " + name;
		}
		return result;
	}
}
