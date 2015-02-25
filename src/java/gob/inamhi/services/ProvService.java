package gob.inamhi.services;

import gob.inamhi.entidades.Prov;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
public interface ProvService {

    public List<Prov> findAllProvs();

    public Prov findProvById(String id);
}