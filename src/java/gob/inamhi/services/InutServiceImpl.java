package gob.inamhi.services;

import gob.inamhi.dao.CopaDAO;
import gob.inamhi.dao.InteDAO;
import gob.inamhi.dao.InutDAO;
import gob.inamhi.dao.UmetDAO;

import gob.inamhi.entidades.Copa;
import gob.inamhi.entidades.Inte;
import gob.inamhi.entidades.Inut;
import gob.inamhi.entidades.Umet;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Inut entities
 *
 */
@Service("InutService")
@Transactional
public class InutServiceImpl implements InutService {

    /**
     * DAO injected by Spring that manages Copa entities
     *
     */
    @Autowired
    private CopaDAO copaDAO;
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
     * DAO injected by Spring that manages Umet entities
     *
     */
    @Autowired
    private UmetDAO umetDAO;

    /**
     * Instantiates a new InutServiceImpl.
     *
     */
    public InutServiceImpl() {
    }

    @Transactional
    public List<Inut> findAllInuts() {
        return new java.util.ArrayList<Inut>(inutDAO.findAllInuts());
    }
}
