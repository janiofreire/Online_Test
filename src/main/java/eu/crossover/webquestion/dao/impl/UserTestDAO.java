package eu.crossover.webquestion.dao.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import eu.crossover.webquestion.dao.IUserTestDAO;
import eu.crossover.webquestion.entity.UserTest;

/**
 * Concrete implementation of the {@code IUserTestDAO}. Extends {@code GenericDAO}.
 * @author janiofreire
 *
 */
@Transactional
public class UserTestDAO extends GenericDAO<UserTest> implements IUserTestDAO,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserTestDAO() throws Exception {
		super();
	}

}
