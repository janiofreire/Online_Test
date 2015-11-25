package eu.crossover.webquestion.facade.impl;

import java.io.Serializable;
import java.util.List;

import eu.crossover.webquestion.dao.ITestDAO;
import eu.crossover.webquestion.entity.Test;
import eu.crossover.webquestion.facade.TestFacade;


/**
 * Concrete implementation of the {@code TestFacade}. Uses a {@code ITestDAO} to data access.
 * @author janiofreire
 */
public class TestFacadeImpl implements TestFacade, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITestDAO testDAO;
	
	public void setTestDAO(ITestDAO testDAO) {
		this.testDAO = testDAO;
	}

	public Test getTest() {
		List<Test> listTest = testDAO.listarAll(Test.class);
		if(listTest !=null && listTest.size() > 0){
			return listTest.get(0);
		}else{
			return null;
		}
	}

}
