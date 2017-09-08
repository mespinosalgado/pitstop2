package cl.pitstop.hibernateDao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cl.pitstop.dao.GenericDao;

@SuppressWarnings("unchecked")
public abstract class AbstractDao extends HibernateDaoSupport implements
		GenericDao {

	private Class<?> entityClass;
	private DetachedCriteria criteria;
	private String alias;

	public AbstractDao() {
	}

	public AbstractDao(Class<?> _entityClass) {
		setEntityClass(_entityClass);
		setAlias("");
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
	}

	public AbstractDao(Class<?> _entityClass, String _alias) {
		setEntityClass(_entityClass);
		setAlias(_alias);
		setCriteria(DetachedCriteria.forClass(getEntityClass(), getAlias()));
	}

	@Override
	public List<?> findAll(String... addAssociationPath) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPath) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, FetchMode.JOIN);
		}
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	public List<?> findAll(FetchMode fetchMode, String... addAssociationPath) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPath) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, fetchMode);
		}
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Integer _maxRows, FetchMode fetchMode,
			String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, fetchMode);
		}
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
				_maxRows);
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(_order);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order, Integer _maxRows, FetchMode fetchMode,
			String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, fetchMode);
		}
		getCriteria().addOrder(_order);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
				_maxRows);
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order, Integer _maxRows) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(_order);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
				_maxRows);
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order, FetchMode fetchMode,
			String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, fetchMode);
		}
		getCriteria().addOrder(_order);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order order, Criterion... _criterions) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(order);
		for (Criterion criterion : _criterions)
			getCriteria().add(criterion);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public Integer findMax(String propiedad) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().setProjection(Projections.max(propiedad));
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		if (!list.isEmpty()) {
			return (Integer) list.get(0);
		}
		return null;
	}

	@Override
	public List<?> findAll(Order order, int maxRows, Criterion... _criterions) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(order);
		for (Criterion criterion : _criterions)
			getCriteria().add(criterion);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
				maxRows);
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order, FetchMode _fetchMode, int _joinType,
			String... _addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(_order);
		for (String associationPath : _addAssociationPaths) {
			getCriteria().createCriteria(associationPath, _joinType);
			getCriteria().setFetchMode(associationPath, _fetchMode);
		}

		List<?> list = new java.util.ArrayList<Object>();
		list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order, FetchMode _fetchMode, int _joinType,
			List<Criterion> _criterions, String... _addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(_order);
		for (String associationPath : _addAssociationPaths) {
			getCriteria().createCriteria(associationPath, _joinType);
			getCriteria().setFetchMode(associationPath, _fetchMode);
		}
		for (Criterion criterion : _criterions) {
			getCriteria().add(criterion);
		}
		List<?> list = new java.util.ArrayList<Object>();
		list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(List<Order> _order, FetchMode _fetchMode,
			int _joinType, List<Criterion> _criterions,
			String... _addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (Order order : _order) {
			getCriteria().addOrder(order);
		}
		for (String associationPath : _addAssociationPaths) {
			getCriteria().createCriteria(associationPath, _joinType);
			getCriteria().setFetchMode(associationPath, _fetchMode);
		}
		for (Criterion criterion : _criterions) {
			getCriteria().add(criterion);
		}
		List<?> list = new java.util.ArrayList<Object>();
		list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order _order, Integer maxRows, FetchMode _fetchMode,
			int _joinType, String... _addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(_order);
		for (String associationPath : _addAssociationPaths) {
			getCriteria().createCriteria(associationPath, _joinType);
			getCriteria().setFetchMode(associationPath, _fetchMode);
		}
		getCriteria().setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<?> list = new java.util.ArrayList<Object>();
		if (maxRows > 0)
			list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
					maxRows);
		else
			list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(List<Order> _order, Integer maxRows,
			FetchMode _fetchMode, int _joinType, String... _addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (Order order : _order) {
			getCriteria().addOrder(order);
		}
		for (String associationPath : _addAssociationPaths) {
			getCriteria().createCriteria(associationPath, _joinType);
			getCriteria().setFetchMode(associationPath, _fetchMode);
		}
		getCriteria().setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<?> list = new java.util.ArrayList<Object>();
		if (maxRows > 0)
			list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
					maxRows);
		else
			list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order order, int maxRows, String associationPath,
			FetchMode fetchMode, Criterion... _criterions) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(order);
		getCriteria().setFetchMode(associationPath, fetchMode);
		for (Criterion criterion : _criterions)
			getCriteria().add(criterion);
		List<?> list = new java.util.ArrayList<Object>();
		if (maxRows > 0)
			list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
					maxRows);
		else
			list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public List<?> findAll(Order order, int maxRows, FetchMode fetchMode,
			Criterion _criterion, String... _associationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		getCriteria().addOrder(order);
		for (String assocPath : _associationPaths) {
			getCriteria().setFetchMode(assocPath, fetchMode);
		}
		getCriteria().add(_criterion);
		List<?> list = new java.util.ArrayList<Object>();
		if (maxRows > 0)
			list = getHibernateTemplate().findByCriteria(getCriteria(), 0,
					maxRows);
		else
			list = getHibernateTemplate().findByCriteria(getCriteria());
		getHibernateTemplate().flush();
		return list;
	}

	@Override
	public <T> T findById(Serializable id) {
		T entity = (T) getEntityClass().cast(
				getHibernateTemplate().get(getEntityClass(), id));
		return entity;
	}

	@Override
	public <T> T findById(Serializable id, String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, FetchMode.JOIN);
		}
		getCriteria().add(Restrictions.idEq(id));
		T entity = (T) this.findByCriteria(getCriteria());
		return entity;
	}

	@Override
	public <T> T findById(Serializable id, FetchMode fetchMode,
			String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath);
			getCriteria().setFetchMode(_associationPath, fetchMode);
		}
		getCriteria().add(Restrictions.idEq(id));
		T entity = (T) this.findByCriteria(getCriteria());
		return entity;
	}

	@Override
	public <T> T findById(Serializable id, int joinType,
			String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath, joinType);
			getCriteria().setFetchMode(_associationPath, FetchMode.JOIN);
		}
		getCriteria().add(Restrictions.idEq(id));
		T entity = (T) this.findByCriteria(getCriteria());
		return entity;
	}

	@Override
	public <T> T findById(Serializable id, FetchMode fetchMode, int joinType,
			String... addAssociationPaths) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (String _associationPath : addAssociationPaths) {
			getCriteria().createCriteria(_associationPath, joinType);
			getCriteria().setFetchMode(_associationPath, fetchMode);
		}
		getCriteria().add(Restrictions.idEq(id));
		T entity = (T) this.findByCriteria(getCriteria());
		return entity;
	}

	@Override
	public List<?> findAllByCriteria(DetachedCriteria _criteria) {
		List<?> lista = getHibernateTemplate().findByCriteria(_criteria);
		getHibernateTemplate().flush();
		return lista;
	}

	@Override
	public Object findByCriteria(DetachedCriteria _criteria) {
		List<?> lista = getHibernateTemplate().findByCriteria(_criteria);
		Object result = null;
		if (!lista.isEmpty())
			result = lista.get(0);
		getHibernateTemplate().flush();
		return result;
	}

	@Override
	public Object findByCriteria(DetachedCriteria _criteria,
			FetchMode fetchMode, String... addAssociationPaths) {
		for (String _associationPath : addAssociationPaths) {
			_criteria.createCriteria(_associationPath);
			_criteria.setFetchMode(_associationPath, fetchMode);
		}
		List<?> lista = getHibernateTemplate().findByCriteria(_criteria);
		Object result = null;
		if (!lista.isEmpty())
			result = lista.get(0);
		getHibernateTemplate().flush();
		return result;
	}

	@Override
	public List<?> findAllByCriteria(DetachedCriteria _criteria, int maxRows,
			FetchMode fetchMode, String... addAssociationPaths) {
		for (String _associationPath : addAssociationPaths) {
			_criteria.createCriteria(_associationPath);
			_criteria.setFetchMode(_associationPath, fetchMode);
		}
		List<?> lista = getHibernateTemplate().findByCriteria(_criteria, 0,
				maxRows);
		getHibernateTemplate().flush();
		return lista;
	}

	@Override
	public List<?> findAllByCriteria(DetachedCriteria _criteria, int maxRows) {
		List<?> lista = getHibernateTemplate().findByCriteria(_criteria, 0,
				maxRows);
		getHibernateTemplate().flush();
		return lista;
	}

	@Override
	public List<?> findAllByCriteria(DetachedCriteria _criteria,
			FetchMode fetchMode, String... addAssociationPaths) {
		for (String _associationPath : addAssociationPaths) {
			_criteria.createCriteria(_associationPath);
			_criteria.setFetchMode(_associationPath, fetchMode);
		}
		List<?> lista = getHibernateTemplate().findByCriteria(_criteria);
		getHibernateTemplate().flush();
		return lista;
	}

	@Override
	public List<?> findUsingQuery(String nombreQuery) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session.getNamedQuery(nombreQuery);
		List<?> list = query.list();
		session.close();
		return list;
	}

	@Override
	public <T> T findByParameter(Criterion... _criterions) {
		setCriteria(DetachedCriteria.forClass(getEntityClass()));
		for (Criterion criterion : _criterions)
			getCriteria().add(criterion);
		List<?> list = getHibernateTemplate().findByCriteria(getCriteria());
		T result = null;
		if (!list.isEmpty())
			result = (T) getEntityClass().cast(list.get(0));
		getHibernateTemplate().flush();
		return result;
	}

	@Deprecated
	@Override
	public Serializable insert(Object objeto) {
		Serializable id = null;
		try {
			id = getHibernateTemplate().save(objeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean delete(Object objeto) {
		try {
			getHibernateTemplate().delete(objeto);
			return true;
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Deprecated
	@Override
	public void update(Object objeto) {
		try {
			getHibernateTemplate().update(objeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	public DetachedCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(DetachedCriteria criteria) {
		this.criteria = criteria;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
