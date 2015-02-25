package gob.inamhi.dao;

import gob.inamhi.entidades.Data1h;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Repository("Data1hDAO")
@Transactional
public class Data1hDAOImpl implements Data1hDAO {

    /**
     * Set of entity classes managed by this DAO. Typically a DAO manages a
     * single entity.
     *
     */
    @Autowired
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Data1h.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Data1h> findAllData1hs() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data1h");
            return new LinkedHashSet<Data1h>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data1h>();
        } finally {
            this.getCurrentSession().close();
        }
    }

    public boolean canBeMerged(Data1h entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Set<Data1h> findAllData1hsByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data1h d where d.estaId.estaId= " + esta + " and d.data1hfetd >= '" + fechaInicio + "' and d.data1hfetd <= '" + fechaFin + "'  and d.copaId.copaId=" + copa + " order by d.data1hfetd asc ");
            return new LinkedHashSet<Data1h>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data1h>();
        } finally {
            this.getCurrentSession().close();
        }
    }

    @Override
    public Set<Data1h> datosEstacionPorParametroFecha(int esta, String fechaInicio, String fechaFin, int copa) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data1h d where d.estaId =" + esta + " and d.data1hfetd>='" + fechaInicio + "' and d.data1hfetd<='" + fechaFin + "'  and d.copaId=" + copa + " order by d.data1hfetd desc ");
            return new LinkedHashSet<Data1h>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data1h>();
        } finally {
            this.getCurrentSession().close();
        }
    }
}
