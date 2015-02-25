package gob.inamhi.services;

import gob.inamhi.dao.PuobDAO;
import gob.inamhi.entidades.Puob;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for VtaEstaciones entities
 *
 */
@Service("PuobService")
@Transactional
public class PuobServiceImpl implements PuobService {

    /**
     * DAO injected by Spring that manages VtaEstaciones entities
     *
     */
    @Autowired
    private PuobDAO puobDAO;

    /**
     * Instantiates a new VtaEstacionesServiceImpl.
     *
     */
    public PuobServiceImpl() {
    }

    @Transactional
    public List<Puob> findAllPuobs() {
        return new java.util.ArrayList<Puob>(puobDAO.findAllPuobs());
    }

    @Transactional
    public List<Puob> findAllPuobPorProv(String prov) {
        return new java.util.ArrayList<Puob>(puobDAO.findAllPuobPorProv(prov));
    }

    @Transactional
    public List<Puob> findAllPuobPorCant(int cant) {
        return new java.util.ArrayList<Puob>(puobDAO.findAllPuobPorCant(cant));
    }

    @Transactional
    public List<Puob> findAllPuobPorParr(int parr) {
        return new java.util.ArrayList<Puob>(puobDAO.findAllPuobPorParr(parr));
    }
}
