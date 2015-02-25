package gob.inamhi.services;

import gob.inamhi.dao.CpestaDAO;
import gob.inamhi.entidades.Cpesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Cali entities
 *
 */
@Service("CpestaService")
@Transactional
public class CpestaServiceImpl implements CpestaService {

    /**
     * DAO injected by Spring that manages Cali entities
     *
     */
    @Autowired
    private CpestaDAO cpestaDAO;

    /**
     * DAO injected by Spring that manages Data1h entities
     *
     */
//    @Autowired
//    private Data1hDAO data1hDAO;
    /**
     * Instantiates a new CaliServiceImpl.
     *
     */
    public CpestaServiceImpl() {
    }

    @Transactional
    public List<Cpesta> findCpestaByEsta(int esta) {
        return new ArrayList<Cpesta>(cpestaDAO.findCpestaByEsta(esta));
    }
}
