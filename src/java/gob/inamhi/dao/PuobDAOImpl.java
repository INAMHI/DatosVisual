package gob.inamhi.dao;

import gob.inamhi.entidades.Puob;
import gob.inamhi.entidades.VtaEstaciones;
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
@Repository("PuobDAO")
@Transactional
public class PuobDAOImpl implements PuobDAO {

    @Autowired
    //@Qualifier("SessionFactory2")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{VtaEstaciones.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Puob> findAllPuobs() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("FROM Puob p WHERE EXISTS (FROM Esta e WHERE e.puobId.puobId=p.puobId) ORDER BY p.puobnomb");
//            this.getCurrentSession().getTransaction().commit();
            return new LinkedHashSet<Puob>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Puob>();
        } finally {
            this.getCurrentSession().close();
        }
    }

    @Transactional
    public Set<Puob> findAllPuobPorProv(String prov) throws DataAccessException {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("FROM Puob p WHERE EXISTS (FROM Esta e WHERE e.puobId.puobId=p.puobId) AND p.parrId.cantId.provId.provId='" + prov + "'");
//            this.getCurrentSession().getTransaction().commit();
            return new LinkedHashSet<Puob>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Puob>();
        } finally {
            this.getCurrentSession().close();
        }
    }

    @Transactional
    public Set<Puob> findAllPuobPorCant(int cant) throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("FROM Puob p WHERE EXISTS (FROM Esta e WHERE e.puobId.puobId=p.puobId) AND p.parrId.cantId.cantId=" + cant + "");
        this.getCurrentSession().flush();
        this.getCurrentSession().getTransaction().commit();
        return new LinkedHashSet<Puob>(query.list());
    }

    @Transactional
    public Set<Puob> findAllPuobPorParr(int parr) throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("FROM Puob p WHERE EXISTS (FROM Esta e WHERE e.puobId.puobId=p.puobId) AND p.parrId.parrId=" + parr + "");
        this.getCurrentSession().flush();
        this.getCurrentSession().getTransaction().commit();
        return new LinkedHashSet<Puob>(query.list());
    }

    public boolean canBeMerged(VtaEstaciones entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
