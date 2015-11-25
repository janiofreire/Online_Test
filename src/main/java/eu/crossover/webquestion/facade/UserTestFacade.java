package eu.crossover.webquestion.facade;

import eu.crossover.webquestion.entity.UserTest;

/**
 * Facade the have methods for manipulate the {@code UserTest} class.
 * @author janiofreire
 *
 */
public interface UserTestFacade {
	/**
	 * Save the {@code UserTest} parameter.
	 * @param userTest
	 */
	void saveUserTestFacade(UserTest userTest);
}
