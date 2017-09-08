package cl.pitstop.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

public interface GenericDao {

	public Serializable insert(Object objeto);

	public boolean delete(Object objeto);

	public void update(Object objeto);

	public Object findByCriteria(DetachedCriteria criteria);

	public Object findByCriteria(DetachedCriteria criteria,
			FetchMode fetchMode, String... addAssociationPaths);

	public <T> T findById(Serializable id);

	public <T> T findById(Serializable id, String... addAssociationPaths);

	public <T> T findById(Serializable id, FetchMode fetchMode,
			String... addAssociationPaths);

	public <T> T findById(Serializable id, int joinType,
			String... addAssociationPaths);

	public <T> T findById(Serializable id, FetchMode fetchMode, int joinType,
			String... addAssociationPaths);

	public <T> T findByParameter(Criterion... criterions);

	public List<?> findAll(Integer _maxRows, FetchMode fetchMode,
			String... addAssociationPaths);

	public List<?> findAll(Order _order, FetchMode _fetchMode, int _joinType,
			String... _addAssociationPaths);

	public List<?> findAll(Order _order, Integer maxRows, FetchMode _fetchMode,
			int _joinType, String... _addAssociationPaths);

	public List<?> findAll(Order _order, FetchMode _fetchMode, int _joinType,
			List<Criterion> _criterions, String... _addAssociationPaths);

	List<?> findAll(List<Order> _order, FetchMode _fetchMode, int _joinType,
			List<Criterion> _criterions, String... _addAssociationPaths);

	List<?> findAll(List<Order> _order, Integer maxRows, FetchMode _fetchMode,
			int _joinType, String... _addAssociationPaths);

	public List<?> findAll(Order _order);

	public List<?> findAll(Order _order, Integer _maxRows);

	public List<?> findAll(Order _order, Criterion... criterions);

	public List<?> findAll(Order order, int maxRows, Criterion... _criterions);

	public List<?> findAll(Order order, int maxRows, String associationPath,
			FetchMode fetchMode, Criterion... _criterions);

	public List<?> findAll(Order order, int maxRows, FetchMode fetchMode,
			Criterion _criterion, String... _associationPaths);

	public List<?> findAll(Order _order, Integer _maxRows, FetchMode fetchMode,
			String... addAssociationPaths);

	public List<?> findAll(Order _order, FetchMode fetchMode,
			String... addAssociationPaths);

	public List<?> findAll(String... addAssociationPaths);

	public List<?> findAllByCriteria(DetachedCriteria criteria);

	public List<?> findAllByCriteria(DetachedCriteria _criteria,
			FetchMode fetchMode, String... addAssociationPaths);

	public List<?> findAllByCriteria(DetachedCriteria _criteria, int maxRows);

	public List<?> findAllByCriteria(DetachedCriteria _criteria, int maxRows,
			FetchMode fetchMode, String... addAssociationPaths);

	public List<?> findUsingQuery(String query);

	public Integer findMax(String propiedad);
}