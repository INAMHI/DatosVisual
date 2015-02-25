/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Puob;
import gob.inamhi.services.PuobService;
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
public class PuobBean implements Serializable {

    @Autowired
    private PuobService puobService;
    private List<Puob> todosPuobs;
    private List<Puob> PuobProv;
    private Puob selected;
    private List<Puob> filteredPuob;

    public List<Puob> getTodosPuobs() {
        if (todosPuobs == null) {
            todosPuobs = puobService.findAllPuobs();
        }
        return todosPuobs;
    }

    public void setTodosPuobs(List<Puob> puob) {
        this.todosPuobs = puob;
    }

    public List<Puob> getPuobProv() {
        return PuobProv;
    }

    public List<Puob> ConsultarPuobProv(String provincia) {
        todosPuobs = puobService.findAllPuobPorProv(provincia);
        return todosPuobs;
    }

    public void setPuobProv(List<Puob> PuobProv) {
        this.PuobProv = PuobProv;
    }

    public Puob getSelected() {
        return selected;
    }

    public void setSelected(Puob selected) {
        this.selected = selected;
    }

    public List<Puob> getFilteredPuob() {
        return filteredPuob;
    }

    public void setFilteredPuob(List<Puob> filteredPuob) {
        this.filteredPuob = filteredPuob;
    }
}
