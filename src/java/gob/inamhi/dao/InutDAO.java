package gob.inamhi.dao;

import gob.inamhi.entidades.Inut;

import java.util.Date;
import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface InutDAO {

    public Set<Inut> findAllInuts() throws DataAccessException;
}