package gob.inamhi.services;

import gob.inamhi.entidades.Cali;

import java.util.List;

/**
 * Spring service that handles CRUD requests for Cali entities
 *
 */
public interface CaliService {

    public List<Cali> findAllCalis();
}