package eu.crossover.webquestion.dao.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import eu.crossover.webquestion.dao.ITestDAO;
import eu.crossover.webquestion.entity.Test;

/**
 * Concrete implementation of the {@code ITestDAO}. Extends {@code GenericDAO}.
 * @author janiofreire
 *
 */
@Transactional
public class TestDAO extends GenericDAO<Test> implements ITestDAO,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestDAO() throws Exception {
		super();
	}
}
