/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Cpresta;
import gob.inamhi.entidades.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Diego
 */
@Controller
@Scope("session")
public class UltimaObsBean implements Serializable {

    @Autowired
    private DataBean dataBean;
    @Autowired
    private CprestaBean cprestaBean;
    @Autowired
    private EstaBean estaBean;
    @Autowired
    private PuobBean puobBean;
    private String estacionCodigo = "";
    private String estacionNombre = "";

    public UltimaObsBean() {
    }

    public void actionListener() {
    }

    public void selectListenerEsta() {
        dataBean.setUltimasObservaciones(null);
        try {
            estacionCodigo = puobBean.getSelected().getPuobcodi();
            estacionNombre = puobBean.getSelected().getPuobnomb();
        } catch (Exception e) {
            estacionCodigo = "N/A";
            estacionNombre = "N/A";
        }

        if (estaBean.getSelected() != null) {
            List<Cpresta> lista = cprestaBean.findCprestaByEsta(estaBean.getSelected().getEstaId());
            int numparms = lista.size();
            dataBean.findLastObservation(estaBean.getSelected().getEstaId(), numparms);
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ADVERTENCIA", "CRITERIO INCOMPLETO");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            dataBean.setDatos(new ArrayList<Data>());
        }
    }

    public void selectListenerPuob() {
        estaBean.setItems(null);
        estaBean.setFilteredEstas(null);
        estaBean.setSelected(null);
        dataBean.setUltimasObservaciones(null);
        estaBean.findEstaByPuob(puobBean.getSelected().getPuobId());
    }

    public String getEstacionCodigo() {
        return estacionCodigo;
    }

    public void setEstacionCodigo(String estacionCodigo) {
        this.estacionCodigo = estacionCodigo;
    }

    public String getEstacionNombre() {
        return estacionNombre;
    }

    public void setEstacionNombre(String estacionNombre) {
        this.estacionNombre = estacionNombre;
    }
}
