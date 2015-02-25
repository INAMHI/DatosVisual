package gob.inamhi.dao;

import gob.inamhi.entidades.Inte;

import java.util.Date;
import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface InteDAO {

    public Set<Inte> findAllIntes() throws DataAccessException;
}