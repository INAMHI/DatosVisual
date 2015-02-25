package gob.inamhi.services;

import gob.inamhi.dao.VtaTiposEstacionDAO;
import gob.inamhi.entidades.VtaTiposEstacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for VtaTiposEstacion entities
 *
 */
@Service("VtaTiposEstacionService")
@Transactional
public class VtaTiposEstacionServiceImpl implements VtaTiposEstacionService {
    
    @Autowired
    private VtaTiposEstacionDAO vtaTiposEstacionDAO;
    
    @Transactional
    public List<VtaTiposEstacion> findAllVtaTiposEstacions() {
        return new java.util.ArrayList<VtaTiposEstacion>(vtaTiposEstacionDAO.VtaTiposEstacion_findAll());
    }
    
    @Transactional
    public List<VtaTiposEstacion> findAllVtaTiposEstacionsByEstaCapto(int esta, int capto) {
        return new java.util.ArrayList<VtaTiposEstacion>(vtaTiposEstacionDAO.findAllVtaTiposEstacionsByEstaCapto(esta, capto));
    }
}
