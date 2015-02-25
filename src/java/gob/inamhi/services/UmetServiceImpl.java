package gob.inamhi.services;

import gob.inamhi.dao.InutDAO;
import gob.inamhi.dao.UmetDAO;
import gob.inamhi.entidades.Umet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Umet entities
 *
 */
@Service("UmetService")
@Transactional
public class UmetServiceImpl implements UmetService {

    /**
     * DAO injected by Spring that manages Inut entities
     *
     */
    @Autowired
    private InutDAO inutDAO;
    /**
     * DAO injected by Spring that manages Umet entities
     *
     */
    @Autowired
    private UmetDAO umetDAO;

    /**
     * Instantiates a new UmetServiceImpl.
     *
     */
    public UmetServiceImpl() {
    }

    /**
     * Return all Umet entity
     *
     */
    @Transactional
    public List<Umet> findAllUmets() {
        return new java.util.ArrayList<Umet>(umetDAO.findAllUmets());
    }
}
