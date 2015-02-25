package gob.inamhi.services;

import gob.inamhi.entidades.Data1h;
import java.util.List;
import javax.jws.WebService;

/**
 * Spring service that handles CRUD requests for Data1h entities
 *
 */
//@WebService
public interface Data1hService {

    public List<Data1h> findAllData1hs();

    public List<Data1h> findAllData1hsByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa);

//    public List<String> datosEstacionPorParametroFecha(int esta, String fechaInicio, String fechaFin, int copa);
}