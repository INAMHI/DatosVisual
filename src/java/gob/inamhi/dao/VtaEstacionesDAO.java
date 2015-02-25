package gob.inamhi.dao;

import gob.inamhi.entidades.VtaEstaciones;

import java.math.BigDecimal;

import java.util.Set;



import org.springframework.dao.DataAccessException;

/**
 */
public interface VtaEstacionesDAO {

    public Set<VtaEstaciones> findAllVtaEstacioness() throws DataAccessException;
    public Set<VtaEstaciones> findAllVtaEstacionesPorProv(String prov) throws DataAccessException;
    public Set<VtaEstaciones> findAllVtaEstacionesPorCant(int cant) throws DataAccessException;
    public Set<VtaEstaciones> findAllVtaEstacionesPorParr(int parr) throws DataAccessException;
}