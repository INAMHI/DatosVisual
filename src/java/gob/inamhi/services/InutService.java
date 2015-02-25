package gob.inamhi.services;

import gob.inamhi.entidades.Inut;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Inut entities
 *
 */
public interface InutService {

    public List<Inut> findAllInuts();
}