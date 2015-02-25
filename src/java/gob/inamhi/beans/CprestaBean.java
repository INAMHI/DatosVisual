/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Cpresta;
import gob.inamhi.services.CprestaService;
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
public class CprestaBean implements Serializable {

    @Autowired
    private CprestaService cprestaService;
    private List<Cpresta> items;
    private Cpresta selected;
    private List<Cpresta> filteredParametros;

    public CprestaBean() {
    }

    public List<Cpresta> getItems() {
        if (items == null) {
            items = new ArrayList<Cpresta>();
        }
        return items;
    }

    public void setItems(List<Cpresta> items) {
        this.items = items;
    }

    public List<Cpresta> findCprestaByEsta(int esta) {
        items = cprestaService.findCprestaByEsta(esta);
        return items;
    }

    public Cpresta getSelected() {
        return selected;
    }

    public void setSelected(Cpresta selected) {
        this.selected = selected;
    }

    public List<Cpresta> getFilteredParametros() {
        return filteredParametros;
    }

    public void setFilteredParametros(List<Cpresta> filteredParametros) {
        this.filteredParametros = filteredParametros;
    }
}
