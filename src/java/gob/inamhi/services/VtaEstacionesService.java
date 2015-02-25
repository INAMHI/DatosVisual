package gob.inamhi.services;

import gob.inamhi.entidades.VtaEstaciones;
import java.util.List;

/**
 * Spring service that handles CRUD requests for VtaEstaciones entities
 *
 */
public interface VtaEstacionesService {

    public List<VtaEstaciones> findAllVtaEstacioness();

    public List<VtaEstaciones> findAllVtaEstacionesPorProv(String prov);

    public List<VtaEstaciones> findAllVtaEstacionesPorCant(int cant);

    public List<VtaEstaciones> findAllVtaEstacionesPorParr(int parr);
}