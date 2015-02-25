package gob.inamhi.services;

import gob.inamhi.dao.Data1hDAO;
import gob.inamhi.entidades.Data1h;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Data1h entities
 *
 */
@Service("Data1hService")
//@WebService
@Transactional
public class Data1hServiceImpl implements Data1hService {

    /**
     * DAO injected by Spring that manages Data1h entities
     *
     */
    @Autowired
    private Data1hDAO data1hDAO;

    /**
     * Instantiates a new Data1hServiceImpl.
     *
     */
    public Data1hServiceImpl() {
    }

    @Transactional
    @Override
    public List<Data1h> findAllData1hs() {
        return new java.util.ArrayList<Data1h>(data1hDAO.findAllData1hs());
    }

    @Transactional
    @Override
    public List<Data1h> findAllData1hsByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa) {
        return new java.util.ArrayList<Data1h>(data1hDAO.findAllData1hsByEstaFetdCopa(esta, fechaInicio, fechaFin, copa));
    }
}
