package gob.inamhi.dao;

import gob.inamhi.entidades.Regi;
import java.util.Set;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Repository("RegiDAO")
@Transactional
public class RegiDAOImpl implements RegiDAO {

    @Transactional
    public Set<Regi> findAllRegis() throws DataAccessException {

        return findAllRegis();
    }

    public boolean canBeMerged(Regi entity) {
        return true;
    }
}
