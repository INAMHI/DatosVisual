package gob.inamhi.services;

import gob.inamhi.entidades.Parr;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Parr entities
 *
 */
public interface ParrService {

    public List<Parr> findAllParrs(int cant);
}