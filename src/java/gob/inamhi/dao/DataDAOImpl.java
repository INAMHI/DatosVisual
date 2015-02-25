package gob.inamhi.dao;

import gob.inamhi.entidades.Data;
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
@Repository("DataDAO")
@Transactional
public class DataDAOImpl implements DataDAO {

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
    public Set<Data> findAllDatas() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data");
            this.getCurrentSession().getTransaction().commit();
            return new LinkedHashSet<Data>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data>();
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
    public Set<Data> findAllDatasByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data d where d.estaId= " + esta + " and d.datafetd between '" + fechaInicio + "' and '" + fechaFin + "'  and d.copaId=" + copa + " order by d.datafetd asc ");
            return new LinkedHashSet<Data>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data>();
        } finally {
            this.getCurrentSession().close();
        }
    }

 
    @Override
    public Set<Data> findLastObservation(int esta,int numparams) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data d where d.estaId.estaId= " + esta + " order by d.datafetd desc").setMaxResults(numparams);
            return new LinkedHashSet<Data>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data>();
        } finally {
            this.getCurrentSession().close();
        }
    }

    @Override
    public Set<Data> datosEstacionPorParametroFecha(int esta, String fechaInicio, String fechaFin, int copa) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Data d where d.estaId =" + esta + " and d.datafetd>='" + fechaInicio + "' and d.datafetd<='" + fechaFin + "'  and d.copaId=" + copa + " order by d.datafetd desc ");
            return new LinkedHashSet<Data>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Data>();
        } finally {
            this.getCurrentSession().close();
        }
    }
}
