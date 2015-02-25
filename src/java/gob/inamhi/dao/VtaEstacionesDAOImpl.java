package gob.inamhi.dao;

import gob.inamhi.entidades.VtaEstaciones;
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
@Repository("VtaEstacionesDAO")
@Transactional
public class VtaEstacionesDAOImpl implements VtaEstacionesDAO {

    @Autowired
    //@Qualifier("SessionFactory2")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{VtaEstaciones.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<VtaEstaciones> findAllVtaEstacioness() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from VtaEstaciones v where v.estaesta=TRUE ORDER BY v.estanomb");
            this.getCurrentSession().flush();
            return new LinkedHashSet<VtaEstaciones>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<VtaEstaciones>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }
    }

    @Transactional
    public Set<VtaEstaciones> findAllVtaEstacionesPorProv(String prov) throws DataAccessException {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from VtaEstaciones where provId='" + prov + "' and estaesta=TRUE");
            this.getCurrentSession().flush();
            return new LinkedHashSet<VtaEstaciones>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<VtaEstaciones>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }
    }

    @Transactional
    public Set<VtaEstaciones> findAllVtaEstacionesPorCant(int cant) throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from VtaEstaciones where cantId=" + cant + " and estaesta=TRUE");
        this.getCurrentSession().flush();
        this.getCurrentSession().getTransaction().commit();
        return new LinkedHashSet<VtaEstaciones>(query.list());
    }

    @Transactional
    public Set<VtaEstaciones> findAllVtaEstacionesPorParr(int parr) throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from VtaEstaciones where parrId=" + parr + " and estaesta=TRUE");
        this.getCurrentSession().flush();
        this.getCurrentSession().getTransaction().commit();
        return new LinkedHashSet<VtaEstaciones>(query.list());
    }

    public boolean canBeMerged(VtaEstaciones entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
