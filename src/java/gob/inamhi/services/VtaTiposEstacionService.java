package gob.inamhi.services;

import gob.inamhi.entidades.VtaTiposEstacion;
import java.util.List;

/**
 * Spring service that handles CRUD requests for VtaTiposEstacion entities
 *
 */
public interface VtaTiposEstacionService {

    public List<VtaTiposEstacion> findAllVtaTiposEstacions();
    public List<VtaTiposEstacion> findAllVtaTiposEstacionsByEstaCapto(int esta, int capto);
}