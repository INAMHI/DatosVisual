package gob.inamhi.services;

import gob.inamhi.dao.VtaEstacionParametrosDAO;
import gob.inamhi.entidades.VtaEstacionParametros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for VtaEstacionParametros entities
 *
 */
@Service("VtaEstacionParametrosService")
@Transactional
public class VtaEstacionParametrosServiceImpl implements VtaEstacionParametrosService {

    /**
     * DAO injected by Spring that manages VtaEstacionParametros entities
     *
     */
    @Autowired
    private VtaEstacionParametrosDAO vtaEstacionParametrosDAO;

    @Transactional
    public List<VtaEstacionParametros> findAllVtaEstacionParametross() {
        return new java.util.ArrayList<VtaEstacionParametros>(vtaEstacionParametrosDAO.VtaEstacionParametros_findAll());
    }

    @Transactional
    public List<VtaEstacionParametros> findAllVtaTiposEstacionsByEstaParm(int esta, int parm) {
        return new java.util.ArrayList<VtaEstacionParametros>(vtaEstacionParametrosDAO.findAllVtaTiposEstacionsByEstaParm(esta, parm));
    }
}
