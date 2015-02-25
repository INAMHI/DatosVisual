package gob.inamhi.services;

import gob.inamhi.entidades.Puob;
import java.util.List;

/**
 * Spring service that handles CRUD requests for VtaEstaciones entities
 *
 */
public interface PuobService {

    public List<Puob> findAllPuobs();

    public List<Puob> findAllPuobPorProv(String prov);

    public List<Puob> findAllPuobPorCant(int cant);

    public List<Puob> findAllPuobPorParr(int parr);
}