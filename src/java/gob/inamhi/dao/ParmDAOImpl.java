package gob.inamhi.dao;

import gob.inamhi.entidades.Parm;
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
@Repository("ParmDAO")
@Transactional
public class ParmDAOImpl implements ParmDAO {

    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Parm.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Parm> findAllParms() throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from Parm");
        this.getCurrentSession().flush();
        return new LinkedHashSet<Parm>(query.list());
    }

    public boolean canBeMerged(Parm entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
