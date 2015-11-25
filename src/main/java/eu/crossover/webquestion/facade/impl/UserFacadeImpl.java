package eu.crossover.webquestion.facade.impl;

import java.io.Serializable;

import eu.crossover.webquestion.dao.IUserDAO;
import eu.crossover.webquestion.entity.User;
import eu.crossover.webquestion.facade.UserFacade;

/**
 * Concrete implementation of the {@code UserFacade}. Uses a {@code IUserDAO} to data access.
 * @author janiofreire
 */
public class UserFacadeImpl implements UserFacade,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUser(String name, String password) {
		return userDAO.getUSerByNamePassWord(name, password);
	}

}
