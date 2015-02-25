package gob.inamhi.services;

import gob.inamhi.entidades.Inte;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Inte entities
 *
 */
public interface InteService {

    public List<Inte> findAllIntes();
}