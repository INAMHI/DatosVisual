package gob.inamhi.dao;

import gob.inamhi.entidades.Cali;
import gob.inamhi.entidades.Cpesta;
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
@Repository("CpestaDAO")
@Transactional
public class CpestaDAOImpl implements CpestaDAO {

    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Cali.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Cpesta> findCpestaByEsta(int esta) {
        try {
            this.getCurrentSession().beginTransaction();
            Query query = this.getCurrentSession().createQuery("from Cpesta c where c.estaId.estaId = " + esta + " order by c.copaId.parmId.parmdesc");
            return new LinkedHashSet<Cpesta>(query.list());
        } catch (Exception e) {
            this.getCurrentSession().getTransaction().rollback();
            return new LinkedHashSet<Cpesta>();
        } finally {
            this.getCurrentSession().close();
        }
    }
    
    

    public boolean canBeMerged(Cali entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
