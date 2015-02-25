package gob.inamhi.dao;

import gob.inamhi.entidades.Cant;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface CantDAO {

    public Set<Cant> findAllCants(int prov) throws DataAccessException;
}