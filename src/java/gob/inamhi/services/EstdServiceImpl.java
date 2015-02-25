package gob.inamhi.services;

import gob.inamhi.dao.CopaDAO;
import gob.inamhi.dao.EstdDAO;

import gob.inamhi.entidades.Estd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Estd entities
 *
 */
@Service("EstdService")
@Transactional
public class EstdServiceImpl implements EstdService {

    /**
     * DAO injected by Spring that manages Copa entities
     *
     */
    @Autowired
    private CopaDAO copaDAO;
    /**
     * DAO injected by Spring that manages Estd entities
     *
     */
    @Autowired
    private EstdDAO estdDAO;

    /**
     * Instantiates a new EstdServiceImpl.
     *
     */
    public EstdServiceImpl() {
    }

    @Transactional
    public List<Estd> findAllEstds() {
        return new java.util.ArrayList<Estd>(estdDAO.findAllEstds());
    }
}
