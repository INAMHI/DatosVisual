package gob.inamhi.services;

import gob.inamhi.entidades.VtaEstacionParametros;
import java.util.List;

/**
 * Spring service that handles CRUD requests for VtaEstacionParametros entities
 *
 */
public interface VtaEstacionParametrosService {

    public List<VtaEstacionParametros> findAllVtaEstacionParametross();

    public List<VtaEstacionParametros> findAllVtaTiposEstacionsByEstaParm(int esta, int parm);
}