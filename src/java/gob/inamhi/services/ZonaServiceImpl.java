package gob.inamhi.services;

import gob.inamhi.dao.ProvDAO;
import gob.inamhi.dao.ZonaDAO;
import gob.inamhi.entidades.Zona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Zona entities
 *
 */
@Service("ZonaService")
@Transactional
public class ZonaServiceImpl implements ZonaService {

    /**
     * DAO injected by Spring that manages Prov entities
     *
     */
    @Autowired
    private ProvDAO provDAO;
    /**
     * DAO injected by Spring that manages Zona entities
     *
     */
    @Autowired
    private ZonaDAO zonaDAO;

    /**
     * Instantiates a new ZonaServiceImpl.
     *
     */
    public ZonaServiceImpl() {
    }

    @Transactional
    public List<Zona> findAllZonas() {
        return new java.util.ArrayList<Zona>(zonaDAO.findAllZonas());
    }
}
