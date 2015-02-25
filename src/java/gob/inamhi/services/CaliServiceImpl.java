package gob.inamhi.services;

import gob.inamhi.dao.CaliDAO;
import gob.inamhi.dao.Data1hDAO;
import gob.inamhi.entidades.Cali;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Cali entities
 *
 */
@Service("CaliService")
@Transactional
public class CaliServiceImpl implements CaliService {

    /**
     * DAO injected by Spring that manages Cali entities
     *
     */
    @Autowired
    private CaliDAO caliDAO;
    /**
     * DAO injected by Spring that manages Data1h entities
     *
     */
    @Autowired
    private Data1hDAO data1hDAO;

    /**
     * Instantiates a new CaliServiceImpl.
     *
     */
    public CaliServiceImpl() {
    }

    @Transactional
    public List<Cali> findAllCalis() {
        return new java.util.ArrayList<Cali>(caliDAO.findAllCalis());
    }
}
