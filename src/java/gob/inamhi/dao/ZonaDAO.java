package gob.inamhi.dao;

import gob.inamhi.entidades.Zona;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface ZonaDAO {

    public Set<Zona> findAllZonas() throws DataAccessException;
}