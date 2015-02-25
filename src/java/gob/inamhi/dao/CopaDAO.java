package gob.inamhi.dao;

import gob.inamhi.entidades.Copa;

import java.util.Date;
import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface CopaDAO {

    public Set<Copa> findAllCopas() throws DataAccessException;

   
}