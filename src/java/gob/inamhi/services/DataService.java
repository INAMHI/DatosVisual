package gob.inamhi.services;

import gob.inamhi.entidades.Data;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Data1h entities
 *
 */
//@WebService
public interface DataService {

    public List<Data> findAllDatas();

    public List<Data> findAllDatasByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa);

    public List<Data> findLastObservation(int esta, int numparams);
}