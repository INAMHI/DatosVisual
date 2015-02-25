package gob.inamhi.dao;

import gob.inamhi.entidades.Cpesta;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface CpestaDAO {

   
    public Set<Cpesta> findCpestaByEsta(int esta) throws DataAccessException;

   
}