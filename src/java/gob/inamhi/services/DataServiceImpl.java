package gob.inamhi.services;

import gob.inamhi.dao.CaliDAO;
import gob.inamhi.dao.CopaDAO;
import gob.inamhi.dao.DataDAO;
import gob.inamhi.dao.EstaDAO;
import gob.inamhi.entidades.Data;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Data1h entities
 *
 */
@Service("DataService")
@Transactional
public class DataServiceImpl implements DataService {

    /**
     * DAO injected by Spring that manages Data entities
     *
     */
    @Autowired
    private DataDAO dataDAO;

    /**
     * Instantiates a new Data1hServiceImpl.
     *
     */
    public DataServiceImpl() {
    }

    @Transactional
    @Override
    public List<Data> findAllDatas() {
        return new java.util.ArrayList<Data>(dataDAO.findAllDatas());
    }

    @Transactional
    @Override
    public List<Data> findAllDatasByEstaFetdCopa(int esta, String fechaInicio, String fechaFin, int copa) {
        return new java.util.ArrayList<Data>(dataDAO.findAllDatasByEstaFetdCopa(esta, fechaInicio, fechaFin, copa));
    }

    @Override
    public List<Data> findLastObservation(int esta, int numparams) {
        return new java.util.ArrayList<Data>(dataDAO.findLastObservation(esta, numparams));
    }
}