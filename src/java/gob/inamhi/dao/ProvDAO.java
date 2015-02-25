package gob.inamhi.dao;

import gob.inamhi.entidades.Prov;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface ProvDAO {

    public Set<Prov> findAllProvs() throws DataAccessException;

    public Prov findProvById(String id) throws DataAccessException;
}