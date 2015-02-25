package gob.inamhi.services;

import gob.inamhi.entidades.Umep;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Umep entities
 *
 */
public interface UmepService {

    public List<Umep> findAllUmeps();
}