package gob.inamhi.dao;

import gob.inamhi.entidades.Umep;

import java.util.Date;
import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface UmepDAO {

    public Set<Umep> findAllUmeps() throws DataAccessException;
}