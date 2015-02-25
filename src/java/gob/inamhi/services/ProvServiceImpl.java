package gob.inamhi.services;

import gob.inamhi.dao.CantDAO;
import gob.inamhi.dao.ProvDAO;
import gob.inamhi.dao.RegiDAO;
import gob.inamhi.dao.ZonaDAO;
import gob.inamhi.entidades.Prov;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
@Service("ProvService")
@Transactional
public class ProvServiceImpl implements ProvService {

    /**
     * DAO injected by Spring that manages Cant entities
     *
     */
    @Autowired
    private CantDAO cantDAO;
    /**
     * DAO injected by Spring that manages Prov entities
     *
     */
    @Autowired
    private ProvDAO provDAO;
    /**
     * DAO injected by Spring that manages Regi entities
     *
     */
    @Autowired
    private RegiDAO regiDAO;
    /**
     * DAO injected by Spring that manages Zona entities
     *
     */
    @Autowired
    private ZonaDAO zonaDAO;

    /**
     * Instantiates a new ProvServiceImpl.
     *
     */
    public ProvServiceImpl() {
    }

   
    @Transactional
    public List<Prov> findAllProvs() {
        return new java.util.ArrayList<Prov>(provDAO.findAllProvs());
    }

    @Override
    public Prov findProvById(String id) {
        return provDAO.findProvById(id);
    }

    
}
