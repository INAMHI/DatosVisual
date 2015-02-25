package gob.inamhi.services;

import gob.inamhi.dao.ProvDAO;
import gob.inamhi.dao.RegiDAO;
import gob.inamhi.entidades.Regi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Regi entities
 *
 */
@Service("RegiService")
@Transactional
public class RegiServiceImpl implements RegiService {

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
     * Instantiates a new RegiServiceImpl.
     *
     */
    public RegiServiceImpl() {
    }

    @Transactional
    public List<Regi> findAllRegis() {
        return new java.util.ArrayList<Regi>(regiDAO.findAllRegis());
    }
}
