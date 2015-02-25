package gob.inamhi.services;

import gob.inamhi.entidades.Copa;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Copa entities
 *
 */
public interface CopaService {

    public List<Copa> findAllCopas();
}