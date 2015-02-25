/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.datatable.LazyProcessedDataModel;
import gob.inamhi.entidades.Data1h;
import gob.inamhi.services.Data1hService;
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
public class Data1hBean implements Serializable {

    @Autowired
    private Data1hService data1hService;
    private List<Data1h> datos;
    private LazyDataModel<Data1h> lazyModel;
    private List<Data1h> selectedData;
    private List<Data1h> filteredData;

    public Data1hBean() {
    }

    public List<Data1h> consultarDatosPorEstaFechaCopa(int estacion, String fechaDesde, String fechaHasta, int copa) {
        return datos = data1hService.findAllData1hsByEstaFetdCopa(estacion, fechaDesde, fechaHasta, copa);
    }

    public void consultarDatosPorEstaFechaCopaLazy(int estacion, String fechaDesde, String fechaHasta, int copa) {
        lazyModel = new LazyProcessedDataModel(data1hService.findAllData1hsByEstaFetdCopa(estacion, fechaDesde, fechaHasta, copa));
    }

    public List<Data1h> getDatos() {
        if (datos == null) {
            datos = new ArrayList<Data1h>();
        }
        return datos;
    }

    public void setDatos(List<Data1h> datos) {
        this.datos = datos;
    }

    public LazyDataModel<Data1h> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyProcessedDataModel(new ArrayList<Data1h>());
        }
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Data1h> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public List<Data1h> getSelectedData() {
        return selectedData;
    }

    public void setSelectedData(List<Data1h> selectedData) {
        this.selectedData = selectedData;
    }

    public List<Data1h> getFilteredData() {
        return filteredData;
    }

    public void setFilteredData(List<Data1h> filteredData) {
        this.filteredData = filteredData;
    }
}
