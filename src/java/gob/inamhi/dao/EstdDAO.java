package gob.inamhi.dao;

import gob.inamhi.entidades.Estd;

import java.util.Date;
import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface EstdDAO {

    public Set<Estd> findAllEstds() throws DataAccessException;
}