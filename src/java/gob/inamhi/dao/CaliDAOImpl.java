package gob.inamhi.dao;

import gob.inamhi.entidades.Cali;
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
@Repository("CaliDAO")
@Transactional
public class CaliDAOImpl implements CaliDAO {

    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Cali.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Cali> findAllCalis() throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from Cali");
        this.getCurrentSession().flush();
        return new LinkedHashSet<Cali>(query.list());
    }

    public boolean canBeMerged(Cali entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
