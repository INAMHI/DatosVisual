package gob.inamhi.services;

import gob.inamhi.entidades.Esta;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Esta entities
 *
 */
public interface EstaService {

    public List<Esta> findAllEstas();

    public List<Esta> findAllEstasPorPuob(int puob);
}