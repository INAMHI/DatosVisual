package gob.inamhi.dao;

import gob.inamhi.entidades.Cpresta;
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
@Repository("CprestaDAO")
@Transactional
public class CprestaDAOImpl implements CprestaDAO {

    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Cpresta> findCprestaByEsta(int esta) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Cpresta c where c.estaId.estaId = " + esta + " order by c.copaId.parmId.parmdesc");
//            this.getCurrentSession().getTransaction().commit();
            return new LinkedHashSet<Cpresta>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Cpresta>();
        } finally {
            getCurrentSession().close();
        }
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
