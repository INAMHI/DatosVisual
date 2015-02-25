/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.beans;

import gob.inamhi.entidades.Data;
import gob.inamhi.entidades.Prov;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Diego
 */
@Controller
@Scope("session")
public class DatosCrudosBean implements Serializable {

    @Autowired
    private DataBean dataBean;
    @Autowired
    private ProvBean provBean;
    @Autowired
    private CprestaBean cprestaBean;
    @Autowired
    private EstaBean estaBean;
    @Autowired
    private PuobBean puobBean;
    private List<Prov> provincias;
    private Date fechaConsultaDesde;
    private Date fechaConsultaHasta;
    private String criteriosBusqueda = "";
    private String criterioPuob = "";
    private String criterioEsta = "";
    private String criterioCpresta = "";
    private String criterioFechaDesde = "";
    private String criterioFechaHasta = "";
    private String nombreArchivo = "";
    private String estacionCodigo = "";
    private String estacionNombre = "";
    private String nombreParametro = "";
    private String datosGrafico = "";

    public DatosCrudosBean() {
        fechaConsultaDesde = Calendar.getInstance().getTime();
        fechaConsultaHasta = Calendar.getInstance().getTime();
    }

    public void setFechaConsultaDesde(Date fechaConsultaDesde) {
        this.fechaConsultaDesde = fechaConsultaDesde;
    }

    public Date getFechaConsultaDesde() {
        return fechaConsultaDesde;
    }

    public Date getFechaConsultaHasta() {
        return fechaConsultaHasta;
    }

    public void setFechaConsultaHasta(Date fechaConsultaHasta) {
        this.fechaConsultaHasta = fechaConsultaHasta;
    }

    public void actionListener() {
        try {
            estacionCodigo = puobBean.getSelected().getPuobcodi();
            estacionNombre = puobBean.getSelected().getPuobnomb();
        } catch (Exception e) {
            estacionCodigo = "N/A";
            estacionNombre = "N/A";
        }

        if (estaBean.getSelected() != null && cprestaBean.getSelected() != null) {
            if (this.diasDiferenciaEntreFechas() <= 31) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaDesde = sdf.format(fechaConsultaDesde);
                String fechaHasta = sdf.format(fechaConsultaHasta);
                setNombreArchivo();
                setNombreParametro();
                dataBean.consultarDatosPorEstaFechaCopa(estaBean.getSelected().getEstaId(), fechaDesde + " 00:00:00", fechaHasta + " 23:59:59", cprestaBean.getSelected().getCopaId().getCopaId());
//                generarDatosGrafico();
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CRITERIOS DE BUSQUEDA", criteriosBusqueda);
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            } else {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ADVERTENCIA", "SOLO SE PERMITEN CONSULTAS NO MAYORES A 31 DIAS");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            }
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ADVERTENCIA", "CRITERIO INCOMPLETO");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            dataBean.setDatos(new ArrayList<Data>());
        }

    }

    public void selectListenerEsta() {
        cprestaBean.setItems(null);
        cprestaBean.setFilteredParametros(null);
        dataBean.setFilteredData(null);
        cprestaBean.setSelected(null);
        cprestaBean.findCprestaByEsta(estaBean.getSelected().getEstaId());
        cprestaBean.setFilteredParametros(null);
        criterioEsta = "<li><strong>ESTACION: </strong>" + estaBean.getSelected().getCatiId().getCaptoId().getCaptonomb() + " " + estaBean.getSelected().getCatiId().getTipoId().getCateId().getCatenomb() + " " + estaBean.getSelected().getCatiId().getTipoId().getTiponomb() + "<br/></li>";
        criteriosBusqueda = criterioPuob + criterioEsta;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CRITERIOS DE BUSQUEDA", criteriosBusqueda);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public void selectListenerPuob() {
        estaBean.setItems(null);
        estaBean.setFilteredEstas(null);
        estaBean.setSelected(null);
        dataBean.setFilteredData(null);
        cprestaBean.setItems(null);
        cprestaBean.setFilteredParametros(null);
        cprestaBean.setSelected(null);
        estaBean.findEstaByPuob(puobBean.getSelected().getPuobId());
        criterioPuob = "<li><strong>PTO. OBS: </strong>" + puobBean.getSelected().getPuobcodi() + " " + puobBean.getSelected().getPuobnomb() + "<br/></li>";
        criteriosBusqueda = criterioPuob;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CRITERIOS DE BUSQUEDA", criteriosBusqueda);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public void selectListenerCpresta() {
        try {
            criterioCpresta = "<li><strong>PARÁMETRO: </strong> " + cprestaBean.getSelected().getCopaId().getParmId().getParmdesc() + " " + cprestaBean.getSelected().getCopaId().getUmepId().getUmepsimb() + " " + cprestaBean.getSelected().getCopaId().getEstdId().getEstdsimb() + "<br/></li>";
        } catch (Exception e) {
        }
        criteriosBusqueda = criterioPuob + criterioEsta + criterioCpresta;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CRITERIOS DE BUSQUEDA", criteriosBusqueda);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public List<Prov> getProvincias() {
        provincias = provBean.consultarTodasProvincias();
        provBean.setSelected(provincias.get(24));
        return provincias;
    }

    public void setProvincias(List<Prov> provincias) {
        this.provincias = provincias;
    }

    public void onDateSelectDesde(SelectEvent event) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date aux = new SimpleDateFormat("yyyy-MM-dd").parse(format.format(event.getObject()));
        criterioFechaDesde = "<li><strong>FECHA DESDE: </strong>" + format.format(aux) + "<br/></li>";
        setFechaConsultaDesde(aux);
        criteriosBusqueda = criterioPuob + criterioEsta + criterioCpresta + criterioFechaDesde;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CRITERIOS DE BUSQUEDA", criteriosBusqueda);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);

    }

    public void onDateSelectHasta(SelectEvent event) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date aux = new SimpleDateFormat("yyyy-MM-dd").parse(format.format(event.getObject()));
        criterioFechaHasta = "<li><strong>FECHA HASTA: </strong>" + format.format(aux) + "</li>";
        setFechaConsultaHasta(aux);
        criteriosBusqueda = criterioPuob + criterioEsta + criterioCpresta + criterioFechaDesde + criterioFechaHasta;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CRITERIOS DE BUSQUEDA", criteriosBusqueda);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);

    }

    public void setNombreArchivo() {
        if (cprestaBean.getSelected() != null) {
            String parametro = cprestaBean.getSelected().getCopaId().getParmId().getParmdesc().replaceAll(" ", "_");
            String unidadMedida = cprestaBean.getSelected().getCopaId().getUmepId().getUmepsimb();
            String estadistico = cprestaBean.getSelected().getCopaId().getEstdId().getEstddesc().replaceAll(" ", "_");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDesde = sdf.format(fechaConsultaDesde);
            String fechaHasta = sdf.format(fechaConsultaHasta);
            nombreArchivo = estacionCodigo + "_" + parametro + "_" + "(" + unidadMedida + ")" + "_" + estadistico + "_" + fechaDesde + "_" + fechaHasta;
        } else {
            nombreArchivo = "";
        }
    }

    public String getNombreArchivo() {
        return nombreArchivo;
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

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro() {
        if (cprestaBean.getSelected() != null) {
            String parametro = cprestaBean.getSelected().getCopaId().getParmId().getParmdesc();
            String unidadMedida = "(" + cprestaBean.getSelected().getCopaId().getUmepId().getUmepsimb() + ")";
            String estadistico = cprestaBean.getSelected().getCopaId().getEstdId().getEstddesc();
            this.nombreParametro = parametro + " " + unidadMedida + " " + estadistico;
        } else {
            nombreParametro = "";
        }
    }

    public String getDatosGrafico() {
        return datosGrafico;
    }

    public void setDatosGrafico(String datosGrafico) {
        this.datosGrafico = datosGrafico;
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }

    public long diasDiferenciaEntreFechas() {

        try {
            long diff = getFechaConsultaHasta().getTime() - getFechaConsultaDesde().getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void generarDatosGrafico() {
        List<Data> datos = dataBean.getDatos();
        Iterator itDatos = datos.iterator();
        datosGrafico = "FECHA," + getNombreParametro() + "\\n";
        while (itDatos.hasNext()) {
            Data aux = (Data) itDatos.next();
            String datosYaux = "";
            String datosGraficoAux = "";
            if (aux.getDatavalo() != null) {
                datosYaux = aux.getDatavalo().toString();
            }
            String datosXaux = aux.getDatafetd().toString();
            datosXaux = datosXaux.substring(0, 19);
            datosGraficoAux = datosXaux + "," + datosYaux + "\\n";
            if (itDatos.hasNext()) {
                datosGraficoAux = datosGraficoAux + "\\n";
            }
            datosGrafico = datosGrafico + datosGraficoAux;
        }
//        System.out.println(datosGrafico);
    }
}
