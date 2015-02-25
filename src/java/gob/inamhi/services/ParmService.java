package gob.inamhi.services;

import gob.inamhi.entidades.Parm;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Parm entities
 *
 */
public interface ParmService {

    public List<Parm> findAllParms();
}