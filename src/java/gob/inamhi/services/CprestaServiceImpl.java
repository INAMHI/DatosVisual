package gob.inamhi.services;

import gob.inamhi.dao.CprestaDAO;
import gob.inamhi.entidades.Cpresta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Cali entities
 *
 */
@Service("CprestaService")
@Transactional
public class CprestaServiceImpl implements CprestaService {

    /**
     * DAO injected by Spring that manages Cali entities
     *
     */
    @Autowired
    private CprestaDAO cprestaDAO;

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
    public CprestaServiceImpl() {
    }

    @Transactional
    public List<Cpresta> findCprestaByEsta(int esta) {
        return new ArrayList<Cpresta>(cprestaDAO.findCprestaByEsta(esta));
    }
}
