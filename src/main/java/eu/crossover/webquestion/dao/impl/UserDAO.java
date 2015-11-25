package eu.crossover.webquestion.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import eu.crossover.webquestion.dao.IUserDAO;
import eu.crossover.webquestion.entity.User;

/**
 * Concrete implementation of the {@code IUserDAO}. Extends {@code GenericDAO}.
 * @author janiofreire
 *
 */
@Transactional
public class UserDAO extends GenericDAO<User> implements IUserDAO,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDAO() throws Exception {
		super();
	}

	@Override
	public User getUSerByNamePassWord(String name, String password) {
		StringBuffer stringBuffer = new StringBuffer("from User u where");
		stringBuffer.append(" u.name='"+name+"' and");
		stringBuffer.append(" u.password='"+password+"'");
		
		Session session = super.getSession();
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery(stringBuffer.toString()).list();
		if(list ==null || list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
	}

}
