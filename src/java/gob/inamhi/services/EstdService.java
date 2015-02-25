package gob.inamhi.services;

import gob.inamhi.entidades.Estd;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Estd entities
 *
 */
public interface EstdService {

    public List<Estd> findAllEstds();
}