package gob.inamhi.dao;

import gob.inamhi.entidades.Umep;
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
@Repository("UmepDAO")
@Transactional
public class UmepDAOImpl implements UmepDAO {

    @Autowired
    //@Qualifier("SessionFactory1")
    private SessionFactory sessionFactory;
    private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{Umep.class}));

    public Set<Class<?>> getTypes() {
        return dataTypes;
    }

    @Transactional
    public Set<Umep> findAllUmeps() throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from Umep");
        this.getCurrentSession().flush();
        return new LinkedHashSet<Umep>(query.list());
    }

    public boolean canBeMerged(Umep entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
