package gob.inamhi.dao;

import gob.inamhi.entidades.Parr;
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
@Repository("ParrDAO")
@Transactional
public class ParrDAOImpl implements ParrDAO {

    @Autowired
    //@Qualifier("SessionFactory2")
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Parr> findAllParrs(int cant) throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from Parr where cantId=" + cant + " ");
        this.getCurrentSession().flush();
        return new LinkedHashSet<Parr>(query.list());
    }

    public boolean canBeMerged(Parr entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
