package gob.inamhi.dao;

import gob.inamhi.entidades.Umet;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface UmetDAO {

    public Set<Umet> findAllUmets() throws DataAccessException;
}