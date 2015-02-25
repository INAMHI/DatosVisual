/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Prov;
import gob.inamhi.services.ProvService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Diego
 */
@Controller
@Scope("session")
public class ProvBean implements Serializable {

    @Autowired
    private ProvService prov;
    private List<Prov> provincias;
    private Prov selected;

    public List<Prov> consultarTodasProvincias() {
        return provincias = prov.findAllProvs();
    }

    public void setProv(ProvService prov) {
        this.prov = prov;
    }

    public List<Prov> getProvincias() {
        if (provincias == null) {
            provincias = prov.findAllProvs();
            setSelected(provincias.get(24));
        }
        return provincias;
    }

    public Prov getSelected() {
        return selected;
    }

    public void setSelected(Prov selected) {
        this.selected = selected;
    }
}
