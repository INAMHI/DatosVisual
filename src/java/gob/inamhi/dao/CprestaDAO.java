package gob.inamhi.dao;

import gob.inamhi.entidades.Cpresta;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface CprestaDAO {

   
    public Set<Cpresta> findCprestaByEsta(int esta) throws DataAccessException;

   
}