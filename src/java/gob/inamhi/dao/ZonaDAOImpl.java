package gob.inamhi.dao;

import gob.inamhi.entidades.Zona;
import java.util.Set;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Repository("ZonaDAO")
@Transactional
public class ZonaDAOImpl implements ZonaDAO {

    @SuppressWarnings("unchecked")
    @Transactional
    public Set<Zona> findAllZonas() throws DataAccessException {

        return findAllZonas();
    }

    public boolean canBeMerged(Zona entity) {
        return true;
    }
}
