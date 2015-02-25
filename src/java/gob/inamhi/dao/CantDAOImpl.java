package gob.inamhi.dao;

import gob.inamhi.entidades.Cant;
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
@Repository("CantDAO")
@Transactional
public class CantDAOImpl implements CantDAO {

    @Autowired
    //@Qualifier("SessionFactory2")
    private SessionFactory sessionFactory;

    @Transactional
    public Set<Cant> findAllCants(int prov) throws DataAccessException {
        this.getCurrentSession().beginTransaction();
        Query query = this.getCurrentSession().createQuery("from Cant where provId="+prov+"");
        this.getCurrentSession().flush();
        return new LinkedHashSet<Cant>(query.list());
    }

    public boolean canBeMerged(Cant entity) {
        return true;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
