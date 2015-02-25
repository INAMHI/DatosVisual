package gob.inamhi.dao;

import gob.inamhi.entidades.Puob;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface PuobDAO {

    public Set<Puob> findAllPuobs() throws DataAccessException;

    public Set<Puob> findAllPuobPorProv(String prov) throws DataAccessException;

    public Set<Puob> findAllPuobPorCant(int cant) throws DataAccessException;

    public Set<Puob> findAllPuobPorParr(int parr) throws DataAccessException;
}