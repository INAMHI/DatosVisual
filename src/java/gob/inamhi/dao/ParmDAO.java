package gob.inamhi.dao;

import gob.inamhi.entidades.Parm;

import java.util.Date;
import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface ParmDAO {

    public Set<Parm> findAllParms() throws DataAccessException;
}