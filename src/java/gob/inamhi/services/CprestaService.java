package gob.inamhi.services;

import gob.inamhi.entidades.Cpresta;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Cali entities
 *
 */
public interface CprestaService {

    public List<Cpresta> findCprestaByEsta(int esta);
}