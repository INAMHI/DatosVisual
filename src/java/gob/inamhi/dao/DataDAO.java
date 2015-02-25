package gob.inamhi.dao;

import gob.inamhi.entidades.Data;
import java.util.Set;

/**
 */
public interface DataDAO {

    public Set<Data> findAllDatas();

    public Set<Data> findAllDatasByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa);

    public Set<Data> datosEstacionPorParametroFecha(int esta, String fechaInicio, String fechaFin, int copa);

    public Set<Data> findLastObservation(int esta, int numparms);
}