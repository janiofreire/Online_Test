package eu.crossover.webquestion.facade;

import eu.crossover.webquestion.entity.User;

/**
 * Facade the have methods for manipulate the {@code Test} class.
 * @author janiofreire
 *
 */
public interface UserFacade {
	/**
	 * Get a {@code User} with the parameters values. 
	 * @param name Name of the {@code User}  
	 * @param password Password of the {@code User}
	 * @return
	 */
	User getUser(String name, String password);
}
