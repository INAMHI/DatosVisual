package gob.inamhi.dao;

import gob.inamhi.entidades.VtaTiposEstacion;
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
@Repository("VtaTiposEstacionDAO")
@Transactional
public class VtaTiposEstacionDAOImpl implements VtaTiposEstacionDAO {

    @Autowired
    //@Qualifier("SessionFactory2")
    private SessionFactory sessionFactory;

    @Transactional
    public Set<VtaTiposEstacion> VtaTiposEstacion_findAll() {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from VtaTiposEstacion");
            this.getCurrentSession().flush();
            return new LinkedHashSet<VtaTiposEstacion>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<VtaTiposEstacion>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }
    }

    @Transactional
    public Set<VtaTiposEstacion> findAllVtaTiposEstacionsByEstaCapto(int esta, int capto) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from VtaTiposEstacion v where v.estaId =" + esta + " and v.captoId=" + capto + "");
            this.getCurrentSession().flush();
            return new LinkedHashSet<VtaTiposEstacion>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<VtaTiposEstacion>();
        } finally {
            this.getCurrentSession().getTransaction().commit();
        }

    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
