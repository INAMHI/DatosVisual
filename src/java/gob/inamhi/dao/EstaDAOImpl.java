package gob.inamhi.dao;

import gob.inamhi.entidades.Esta;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Repository("EstaDAO")
@Transactional
public class EstaDAOImpl implements EstaDAO {

    /**
     * Set of entity classes managed by this DAO. Typically a DAO manages a
     * single entity.
     *
     */
    @Autowired
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Esta.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Esta> findAllEstas() throws DataAccessException {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("FROM Esta e ");
            this.getCurrentSession().getTransaction().commit();
            return new LinkedHashSet<Esta>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Esta>();
        } finally {
            getCurrentSession().close();
        }
    }

    @Transactional
    public Set<Esta> findAllEstasPorPuob(int puob) throws DataAccessException {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("FROM Esta e WHERE e.puobId.puobId=" + puob + " ");
            return new LinkedHashSet<Esta>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Esta>();
        } finally {
            getCurrentSession().close();
        }
    }

    public boolean canBeMerged(Esta entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
