package gob.inamhi.services;

import gob.inamhi.dao.CantDAO;
import gob.inamhi.dao.ParrDAO;
import gob.inamhi.entidades.Parr;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Parr entities
 *
 */
@Service("ParrService")
@Transactional
public class ParrServiceImpl implements ParrService {

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
     * Instantiates a new ParrServiceImpl.
     *
     */
    public ParrServiceImpl() {
    }

    @Transactional
    public List<Parr> findAllParrs(int cant) {
        return new java.util.ArrayList<Parr>(parrDAO.findAllParrs(cant));
    }
    
}
