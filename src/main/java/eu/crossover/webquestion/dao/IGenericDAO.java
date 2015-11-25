package eu.crossover.webquestion.dao;

import java.util.List;

/**
 * Generic interface that have basic methods for data access.
 * 
 * @author janiofreire
 *
 * @param <E>
 */
public interface IGenericDAO<E> {
	/**
	 * Persist the object.
	 * 
	 * @param entity
	 */
	void save(E entity);

	/**
	 * Delete the object.
	 * 
	 * @param entity
	 */
	void del(E entity);

	/**
	 * List all data for a give class type.
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<E> listarAll(Class entity);

	/**
	 * List all data for a give class type with a limite.
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<E> listarAllwithLimit(Class entity, Integer limite);
}
