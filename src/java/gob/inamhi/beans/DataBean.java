/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.datatable.LazyRawDataModel;
import gob.inamhi.entidades.Data;
import gob.inamhi.services.DataService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Diego
 */
@Controller
@Scope("session")
public class DataBean implements Serializable {

    @Autowired
    private DataService dataService;
    private List<Data> datos;
    private LazyDataModel<Data> lazyModel;
    private List<Data> selectedData;
    private List<Data> filteredData;
    private List<Data> ultimasObservaciones;

    public DataBean() {
    }

    public List<Data> consultarDatosPorEstaFechaCopa(int estacion, String fechaDesde, String fechaHasta, int copa) {
        return datos = dataService.findAllDatasByEstaFetdCopa(estacion, fechaDesde, fechaHasta, copa);
    }

    public void consultarDatosPorEstaFechaCopaLazy(int estacion, String fechaDesde, String fechaHasta, int copa) {
        lazyModel = new LazyRawDataModel(dataService.findAllDatasByEstaFetdCopa(estacion, fechaDesde, fechaHasta, copa));
    }

    public void findLastObservation(int esta, int numparams) {
        ultimasObservaciones = dataService.findLastObservation(esta, numparams);
    }

    public List<Data> getDatos() {
        if (datos == null) {
            datos = new ArrayList<Data>();
        }
        return datos;
    }

    public void setDatos(List<Data> datos) {
        this.datos = datos;
    }

    public LazyDataModel<Data> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyRawDataModel(new ArrayList<Data>());
        }
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Data> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public List<Data> getSelectedData() {
        return selectedData;
    }

    public void setSelectedData(List<Data> selectedData) {
        this.selectedData = selectedData;
    }

    public List<Data> getFilteredData() {
        return filteredData;
    }

    public void setFilteredData(List<Data> filteredData) {
        this.filteredData = filteredData;
    }

    public List<Data> getUltimasObservaciones() {
        return ultimasObservaciones;
    }

    public void setUltimasObservaciones(List<Data> ultimasObservaciones) {
        this.ultimasObservaciones = ultimasObservaciones;
    }
}
