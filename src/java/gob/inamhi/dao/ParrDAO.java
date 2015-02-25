package gob.inamhi.dao;

import gob.inamhi.entidades.Parr;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface ParrDAO {

    public Set<Parr> findAllParrs(int cant) throws DataAccessException;
}