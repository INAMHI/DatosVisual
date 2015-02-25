package gob.inamhi.dao;

import gob.inamhi.entidades.VtaEstacionParametros;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Repository("VtaEstacionParametrosDAO")
@Transactional
public class VtaEstacionParametrosDAOImpl implements VtaEstacionParametrosDAO {

    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;

    @Transactional
    public Set<VtaEstacionParametros> VtaEstacionParametros_findAll() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from VtaEstacionParametros");
            this.getCurrentSession().flush();
            return new LinkedHashSet<VtaEstacionParametros>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<VtaEstacionParametros>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }
    }

    public Set<VtaEstacionParametros> findAllVtaTiposEstacionsByEstaParm(int esta, int parm) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from VtaEstacionParametros v where v.estaId=" + esta + " and v.parmId=" + parm + " and v.cpestaesta=true");
            this.getCurrentSession().flush();
            return new LinkedHashSet<VtaEstacionParametros>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<VtaEstacionParametros>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }


    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
