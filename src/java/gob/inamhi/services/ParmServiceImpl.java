package gob.inamhi.services;

import gob.inamhi.dao.CopaDAO;
import gob.inamhi.dao.ParmDAO;
import gob.inamhi.entidades.Parm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Parm entities
 *
 */
@Service("ParmService")
@Transactional
public class ParmServiceImpl implements ParmService {

    /**
     * DAO injected by Spring that manages Copa entities
     *
     */
    @Autowired
    private CopaDAO copaDAO;
    /**
     * DAO injected by Spring that manages Parm entities
     *
     */
    @Autowired
    private ParmDAO parmDAO;

    /**
     * Instantiates a new ParmServiceImpl.
     *
     */
    public ParmServiceImpl() {
    }

    @Transactional
    public List<Parm> findAllParms() {
        return new java.util.ArrayList<Parm>(parmDAO.findAllParms());
    }
}
