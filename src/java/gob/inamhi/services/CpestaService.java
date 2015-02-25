package gob.inamhi.services;

import gob.inamhi.entidades.Cpesta;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Cali entities
 *
 */
public interface CpestaService {

    public List<Cpesta> findCpestaByEsta(int esta);
}