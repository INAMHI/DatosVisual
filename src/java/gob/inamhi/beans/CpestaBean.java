/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Cpesta;
import gob.inamhi.services.CpestaService;
import java.io.Serializable;
import java.util.ArrayList;
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
public class CpestaBean implements Serializable {

    @Autowired
    private CpestaService cpestaService;
    private List<Cpesta> items;
    private Cpesta selected;
    private List<Cpesta> filteredParametros;

    public CpestaBean() {
    }

    public List<Cpesta> getItems() {
        if (items == null) {
            items = new ArrayList<Cpesta>();
        }
        return items;
    }

    public void setItems(List<Cpesta> items) {
        this.items = items;
    }

    public List<Cpesta> findCpestaByEsta(int esta) {
        items = cpestaService.findCpestaByEsta(esta);
        return items;
    }

    public Cpesta getSelected() {
        return selected;
    }

    public void setSelected(Cpesta selected) {
        this.selected = selected;
    }

    public void setFilteredParametros(List<Cpesta> filteredParametros) {
        this.filteredParametros = filteredParametros;
    }

    public List<Cpesta> getFilteredParametros() {
        return filteredParametros;
    }
}
