package gob.inamhi.services;

import gob.inamhi.entidades.Umet;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Umet entities
 *
 */
public interface UmetService {

    public List<Umet> findAllUmets();
}