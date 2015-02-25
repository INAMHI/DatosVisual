package gob.inamhi.services;

import gob.inamhi.dao.CopaDAO;
import gob.inamhi.dao.UmepDAO;
import gob.inamhi.entidades.Umep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Umep entities
 *
 */
@Service("UmepService")
@Transactional
public class UmepServiceImpl implements UmepService {

    /**
     * DAO injected by Spring that manages Copa entities
     *
     */
    @Autowired
    private CopaDAO copaDAO;
    /**
     * DAO injected by Spring that manages Umep entities
     *
     */
    @Autowired
    private UmepDAO umepDAO;

    /**
     * Instantiates a new UmepServiceImpl.
     *
     */
    public UmepServiceImpl() {
    }

    @Transactional
    public List<Umep> findAllUmeps() {
        return new java.util.ArrayList<Umep>(umepDAO.findAllUmeps());
    }
}
