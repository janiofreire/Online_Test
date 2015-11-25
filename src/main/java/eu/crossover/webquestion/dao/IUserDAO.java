package eu.crossover.webquestion.dao;

import eu.crossover.webquestion.entity.User;

/**
 * Interface of data access for the {@code User} object.
 * @author janiofreire
 *
 */
public interface IUserDAO extends IGenericDAO<User>{
	/**
	 * Get a {@code User} with the parameters values.
	 * @param name name of the {@code User} 
	 * @param password pass word of the {@code User}
	 * @return
	 */
	User getUSerByNamePassWord(String name, String password);
}
