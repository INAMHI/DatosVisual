package gob.inamhi.services;

import gob.inamhi.entidades.Cant;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Cant entities
 *
 */
public interface CantService {

    /**
     * Return all Cant entity
     *
     */
    public List<Cant> findAllCants(int prov);
}