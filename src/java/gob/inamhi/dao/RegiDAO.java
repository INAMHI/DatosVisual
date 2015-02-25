package gob.inamhi.dao;

import gob.inamhi.entidades.Regi;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface RegiDAO {

    public Set<Regi> findAllRegis() throws DataAccessException;
}