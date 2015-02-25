/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Esta;
import gob.inamhi.services.EstaService;
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
public class EstaBean implements Serializable {

    @Autowired
    private EstaService estaService;
    private List<Esta> items;
    private Esta selected;
    private List<Esta> filteredEstas;

    public List<Esta> getItems() {
        if (items == null) {
            items = new ArrayList<Esta>();
        }
        return items;
    }

    public void setItems(List<Esta> items) {
        this.items = items;
    }

    public List<Esta> findEstaByPuob(int puob) {
        items = estaService.findAllEstasPorPuob(puob);
        return items;
    }

    public Esta getSelected() {
        return selected;
    }

    public void setSelected(Esta selected) {
        this.selected = selected;
    }

    public List<Esta> getFilteredEstas() {
        return filteredEstas;
    }

    public void setFilteredEstas(List<Esta> filteredEstas) {
        this.filteredEstas = filteredEstas;
    }
}
