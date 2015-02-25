package gob.inamhi.dao;

import gob.inamhi.entidades.VtaTiposEstacion;
import java.util.Set;

/**
 */
public interface VtaTiposEstacionDAO {

    public Set<VtaTiposEstacion> VtaTiposEstacion_findAll();
    public Set<VtaTiposEstacion> findAllVtaTiposEstacionsByEstaCapto(int esta,int capto) ;
}