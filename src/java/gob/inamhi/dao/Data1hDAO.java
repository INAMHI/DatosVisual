package gob.inamhi.dao;

import gob.inamhi.entidades.Data1h;
import java.util.List;
import java.util.Set;

/**
 */
public interface Data1hDAO {

    public Set<Data1h> findAllData1hs();

    public Set<Data1h> findAllData1hsByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa);

    public Set<Data1h> datosEstacionPorParametroFecha(int esta, String fechaInicio, String fechaFin, int copa);
}