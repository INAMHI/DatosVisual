/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "vta__tipos_estacion", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaTiposEstacion.findAll", query = "SELECT v FROM VtaTiposEstacion v"),
    @NamedQuery(name = "VtaTiposEstacion.findByEstaId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.estaId = :estaId"),
    @NamedQuery(name = "VtaTiposEstacion.findByEscatId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.escatId = :escatId"),
    @NamedQuery(name = "VtaTiposEstacion.findByCatiId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.catiId = :catiId"),
    @NamedQuery(name = "VtaTiposEstacion.findByCaptoId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.captoId = :captoId"),
    @NamedQuery(name = "VtaTiposEstacion.findByTiparId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.tiparId = :tiparId"),
    @NamedQuery(name = "VtaTiposEstacion.findByTipoId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.tipoId = :tipoId"),
    @NamedQuery(name = "VtaTiposEstacion.findByCateId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.cateId = :cateId"),
    @NamedQuery(name = "VtaTiposEstacion.findByParmId", query = "SELECT v FROM VtaTiposEstacion v WHERE v.parmId = :parmId"),
    @NamedQuery(name = "VtaTiposEstacion.findByEstacodi", query = "SELECT v FROM VtaTiposEstacion v WHERE v.estacodi = :estacodi"),
    @NamedQuery(name = "VtaTiposEstacion.findByEstanomb", query = "SELECT v FROM VtaTiposEstacion v WHERE v.estanomb = :estanomb"),
    @NamedQuery(name = "VtaTiposEstacion.findByCaptonomb", query = "SELECT v FROM VtaTiposEstacion v WHERE v.captonomb = :captonomb"),
    @NamedQuery(name = "VtaTiposEstacion.findByTiponomb", query = "SELECT v FROM VtaTiposEstacion v WHERE v.tiponomb = :tiponomb"),
    @NamedQuery(name = "VtaTiposEstacion.findByCatenomb", query = "SELECT v FROM VtaTiposEstacion v WHERE v.catenomb = :catenomb"),
    @NamedQuery(name = "VtaTiposEstacion.findByParmdesc", query = "SELECT v FROM VtaTiposEstacion v WHERE v.parmdesc = :parmdesc")})
public class VtaTiposEstacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "esta__id")
    private Integer estaId;
    @Column(name = "escat__id")
    private Integer escatId;
    @Column(name = "cati__id")
    private Integer catiId;
    @Column(name = "capto__id")
    private Integer captoId;
    @Column(name = "tipar__id")
    private Integer tiparId;
    @Column(name = "tipo__id")
    private Integer tipoId;
    @Column(name = "cate__id")
    private Integer cateId;
    @Id
    @Column(name = "parm__id")
    private Integer parmId;
    @Size(max = 8)
    @Column(name = "estacodi")
    private String estacodi;
    @Size(max = 100)
    @Column(name = "estanomb")
    private String estanomb;
    @Size(max = 50)
    @Column(name = "captonomb")
    private String captonomb;
    @Size(max = 50)
    @Column(name = "tiponomb")
    private String tiponomb;
    @Size(max = 100)
    @Column(name = "catenomb")
    private String catenomb;
    @Size(max = 1000)
    @Column(name = "parmdesc")
    private String parmdesc;
    @Column(name = "tiparmax", precision = 5, scale = 2)
    private Double tiparmax;
    @Column(name = "tiparmin", precision = 5, scale = 2)
    private Double tiparmin;

    public VtaTiposEstacion() {
    }

    public Integer getEstaId() {
        return estaId;
    }

    public void setEstaId(Integer estaId) {
        this.estaId = estaId;
    }

    public Integer getEscatId() {
        return escatId;
    }

    public void setEscatId(Integer escatId) {
        this.escatId = escatId;
    }

    public Integer getCatiId() {
        return catiId;
    }

    public void setCatiId(Integer catiId) {
        this.catiId = catiId;
    }

    public Integer getCaptoId() {
        return captoId;
    }

    public void setCaptoId(Integer captoId) {
        this.captoId = captoId;
    }

    public Integer getTiparId() {
        return tiparId;
    }

    public void setTiparId(Integer tiparId) {
        this.tiparId = tiparId;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getParmId() {
        return parmId;
    }

    public void setParmId(Integer parmId) {
        this.parmId = parmId;
    }

    public String getEstacodi() {
        return estacodi;
    }

    public void setEstacodi(String estacodi) {
        this.estacodi = estacodi;
    }

    public String getEstanomb() {
        return estanomb;
    }

    public void setEstanomb(String estanomb) {
        this.estanomb = estanomb;
    }

    public String getCaptonomb() {
        return captonomb;
    }

    public void setCaptonomb(String captonomb) {
        this.captonomb = captonomb;
    }

    public String getTiponomb() {
        return tiponomb;
    }

    public void setTiponomb(String tiponomb) {
        this.tiponomb = tiponomb;
    }

    public String getCatenomb() {
        return catenomb;
    }

    public void setCatenomb(String catenomb) {
        this.catenomb = catenomb;
    }

    public String getParmdesc() {
        return parmdesc;
    }

    public void setParmdesc(String parmdesc) {
        this.parmdesc = parmdesc;
    }

    public Double getTiparmax() {
        return tiparmax;
    }

    public void setTiparmax(Double tiparmax) {
        this.tiparmax = tiparmax;
    }

    public Double getTiparmin() {
        return tiparmin;
    }

    public void setTiparmin(Double tiparmin) {
        this.tiparmin = tiparmin;
    }
}
