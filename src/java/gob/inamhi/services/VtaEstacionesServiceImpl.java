package gob.inamhi.services;

import gob.inamhi.dao.VtaEstacionesDAO;

import gob.inamhi.entidades.VtaEstaciones;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for VtaEstaciones entities
 *
 */
@Service("VtaEstacionesService")
@Transactional
public class VtaEstacionesServiceImpl implements VtaEstacionesService {

    /**
     * DAO injected by Spring that manages VtaEstaciones entities
     *
     */
    @Autowired
    private VtaEstacionesDAO vtaEstacionesDAO;

    /**
     * Instantiates a new VtaEstacionesServiceImpl.
     *
     */
    public VtaEstacionesServiceImpl() {
    }

    @Transactional
    public List<VtaEstaciones> findAllVtaEstacioness() {
        return new java.util.ArrayList<VtaEstaciones>(vtaEstacionesDAO.findAllVtaEstacioness());
    }
    
    @Transactional
    public List<VtaEstaciones> findAllVtaEstacionesPorProv(String prov) {
        return new java.util.ArrayList<VtaEstaciones>(vtaEstacionesDAO.findAllVtaEstacionesPorProv(prov));
    }
    
    @Transactional
    public List<VtaEstaciones> findAllVtaEstacionesPorCant(int cant) {
        return new java.util.ArrayList<VtaEstaciones>(vtaEstacionesDAO.findAllVtaEstacionesPorCant(cant));
    }
    
    @Transactional
    public List<VtaEstaciones> findAllVtaEstacionesPorParr(int parr) {
        return new java.util.ArrayList<VtaEstaciones>(vtaEstacionesDAO.findAllVtaEstacionesPorParr(parr));
    }
}
