package gob.inamhi.dao;

import gob.inamhi.entidades.VtaEstacionParametros;
import java.util.Set;

/**
 */
public interface VtaEstacionParametrosDAO {

    public Set<VtaEstacionParametros> VtaEstacionParametros_findAll();
    public Set<VtaEstacionParametros> findAllVtaTiposEstacionsByEstaParm(int esta, int parm);
}