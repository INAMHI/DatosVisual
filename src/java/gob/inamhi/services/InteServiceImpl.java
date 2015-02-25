package gob.inamhi.services;

import gob.inamhi.dao.InteDAO;
import gob.inamhi.dao.InutDAO;
import gob.inamhi.entidades.Inte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Inte entities
 *
 */
@Service("InteService")
@Transactional
public class InteServiceImpl implements InteService {

    /**
     * DAO injected by Spring that manages Inte entities
     *
     */
    @Autowired
    private InteDAO inteDAO;
    /**
     * DAO injected by Spring that manages Inut entities
     *
     */
    @Autowired
    private InutDAO inutDAO;

    /**
     * Instantiates a new InteServiceImpl.
     *
     */
    public InteServiceImpl() {
    }

    @Transactional
    public List<Inte> findAllIntes() {
        return new java.util.ArrayList<Inte>(inteDAO.findAllIntes());
    }
}
