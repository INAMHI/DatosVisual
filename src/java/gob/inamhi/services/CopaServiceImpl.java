package gob.inamhi.services;

import gob.inamhi.dao.CopaDAO;
import gob.inamhi.dao.Data1hDAO;
import gob.inamhi.dao.EstdDAO;
import gob.inamhi.dao.InutDAO;
import gob.inamhi.dao.ParmDAO;
import gob.inamhi.dao.UmepDAO;
import gob.inamhi.entidades.Copa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Copa entities
 *
 */
@Service("CopaService")
@Transactional
public class CopaServiceImpl implements CopaService {

    /**
     * DAO injected by Spring that manages Copa entities
     *
     */
    @Autowired
    private CopaDAO copaDAO;
    /**
     * DAO injected by Spring that manages Data1h entities
     *
     */
    @Autowired
    private Data1hDAO data1hDAO;
    /**
     * DAO injected by Spring that manages Estd entities
     *
     */
    @Autowired
    private EstdDAO estdDAO;
    /**
     * DAO injected by Spring that manages Inut entities
     *
     */
    @Autowired
    private InutDAO inutDAO;
    /**
     * DAO injected by Spring that manages Parm entities
     *
     */
    @Autowired
    private ParmDAO parmDAO;
    /**
     * DAO injected by Spring that manages Umep entities
     *
     */
    @Autowired
    private UmepDAO umepDAO;

    /**
     * Instantiates a new CopaServiceImpl.
     *
     */
    public CopaServiceImpl() {
    }

    @Transactional
    public List<Copa> findAllCopas() {
        return new java.util.ArrayList<Copa>(copaDAO.findAllCopas());
    }
}
