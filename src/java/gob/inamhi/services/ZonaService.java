package gob.inamhi.services;

import gob.inamhi.entidades.Zona;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Zona entities
 *
 */
public interface ZonaService {

    public List<Zona> findAllZonas();
}