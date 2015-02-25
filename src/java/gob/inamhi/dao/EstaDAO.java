package gob.inamhi.dao;

import gob.inamhi.entidades.Esta;
import java.util.Set;
import org.springframework.dao.DataAccessException;

/**
 */
public interface EstaDAO {

    public Set<Esta> findAllEstas() throws DataAccessException;

    public Set<Esta> findAllEstasPorPuob(int puob) throws DataAccessException;
}