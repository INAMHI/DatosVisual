package gob.inamhi.services;

import gob.inamhi.dao.CantDAO;
import gob.inamhi.dao.ParrDAO;
import gob.inamhi.dao.ProvDAO;
import gob.inamhi.entidades.Cant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Cant entities
 *
 */
@Service("CantService")
@Transactional
public class CantServiceImpl implements CantService {

    /**
     * DAO injected by Spring that manages Cant entities
     *
     */
    @Autowired
    private CantDAO cantDAO;
    /**
     * DAO injected by Spring that manages Parr entities
     *
     */
    @Autowired
    private ParrDAO parrDAO;
    /**
     * DAO injected by Spring that manages Prov entities
     *
     */
    @Autowired
    private ProvDAO provDAO;

    /**
     * Instantiates a new CantServiceImpl.
     *
     */
    public CantServiceImpl() {
    }

    /**
     * Return all Cant entity
     *
     */
    @Transactional
    public List<Cant> findAllCants(int prov) {
        return new java.util.ArrayList<Cant>(cantDAO.findAllCants(prov));
    }
}
