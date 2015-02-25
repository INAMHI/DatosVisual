package gob.inamhi.dao;

import gob.inamhi.entidades.Cali;

import java.util.Date;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface CaliDAO {

   
    public Set<Cali> findAllCalis() throws DataAccessException;

   
}