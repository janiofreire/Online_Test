package eu.crossover.webquestion.facade.impl;

import java.io.Serializable;

import eu.crossover.webquestion.dao.IUserTestDAO;
import eu.crossover.webquestion.entity.UserTest;
import eu.crossover.webquestion.facade.UserTestFacade;


/**
 * Concrete implementation of the {@code UserTestFacade}. Uses a {@code IUserTestDAO} to data access.
 * @author janiofreire
 */
public class UserTestFacadeImpl implements UserTestFacade,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserTestDAO userTestDAO;
	
	public void setUserTestDAO(IUserTestDAO userTestDAO) {
		this.userTestDAO = userTestDAO;
	}

	@Override
	public void saveUserTestFacade(UserTest userTest) {
		userTestDAO.save(userTest);
	}

}
