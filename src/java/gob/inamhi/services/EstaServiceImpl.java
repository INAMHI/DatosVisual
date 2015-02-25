package gob.inamhi.services;

import gob.inamhi.dao.Data1hDAO;
import gob.inamhi.dao.EstaDAO;
import gob.inamhi.entidades.Esta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Esta entities
 *
 */
@Service("EstaService")
@Transactional
public class EstaServiceImpl implements EstaService {

    /**
     * DAO injected by Spring that manages Data1h entities
     *
     */
    @Autowired
    private Data1hDAO data1hDAO;
    /**
     * DAO injected by Spring that manages Esta entities
     *
     */
    @Autowired
    private EstaDAO estaDAO;

    /**
     * Instantiates a new EstaServiceImpl.
     *
     */
    public EstaServiceImpl() {
    }

    @Transactional
    public List<Esta> findAllEstas() {
        return new java.util.ArrayList<Esta>(estaDAO.findAllEstas());
    }

    @Transactional
    public List<Esta> findAllEstasPorPuob(int puob) {
        return new java.util.ArrayList<Esta>(estaDAO.findAllEstasPorPuob(puob));
    }
}
