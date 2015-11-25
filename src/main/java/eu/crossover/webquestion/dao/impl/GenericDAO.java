package eu.crossover.webquestion.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eu.crossover.webquestion.dao.IGenericDAO;

/**
 * Concrete implementation of the {@code IGenericDAO} using hibernate.
 * @author janiofreire
 *
 * @param <E>
 */
public class GenericDAO<E> implements IGenericDAO<E>{
	private SessionFactory sessionFactory;

	public GenericDAO() {
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Session getSession() {
		return sessionFactory.openSession();
	}
    
    public void save(E bm){
    	try{
    		getSession().saveOrUpdate(bm);
    	}catch(org.hibernate.NonUniqueObjectException e){
    		getSession().merge(bm);
    	}
    }
    
    public void del(E bm){
    	getSession().delete(bm);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarAll(Class bm){
    	return getSession().createQuery("from "+bm.getName()).list();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarAllwithLimit(Class bm, Integer limite){
    	return getSession().createQuery("from "+bm.getName()).setMaxResults(limite).list();
    }
    
}
