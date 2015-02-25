package gob.inamhi.dao;

import gob.inamhi.entidades.Copa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 */
@Repository("CopaDAO")
@Transactional
public class CopaDAOImpl implements CopaDAO {

    /**
     * Set of entity classes managed by this DAO. Typically a DAO manages a
     * single entity.
     *
     */
    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Copa.class}));

    /**
     * Returns the set of entity classes managed by this DAO.
     *
     */
    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Copa> findAllCopas() throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from Copa");
        this.getCurrentSession().flush();
        return new LinkedHashSet<Copa>(query.list());
    }

    public boolean canBeMerged(Copa entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
