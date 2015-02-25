package gob.inamhi.dao;

import gob.inamhi.entidades.Prov;
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
@Repository("ProvDAO")
@Transactional
public class ProvDAOImpl implements ProvDAO {

    @Autowired
    //@Qualifier("SessionFactory2")
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Prov> findAllProvs() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Prov order by provId");
            this.getCurrentSession().flush();
            return new LinkedHashSet<Prov>(query.list());
        } catch (DataAccessException e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Prov>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }
    }

    @Transactional
    public Prov findProvById(String id) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Prov where provId='" + id + "'");
            this.getCurrentSession().flush();
            return (Prov) query.uniqueResult();
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new Prov();
        } finally {

            this.getCurrentSession().getTransaction().commit();
        }
    }

    public boolean canBeMerged(Prov entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
