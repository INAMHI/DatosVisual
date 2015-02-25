package gob.inamhi.services;

import gob.inamhi.entidades.Regi;
import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Regi entities
 *
 */
public interface RegiService {

    public List<Regi> findAllRegis();
}