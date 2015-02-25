/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Diego
 */
@Entity
@Table(name = "vta__estaciones", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaEstaciones.findAll", query = "SELECT v FROM VtaEstaciones v"),
    @NamedQuery(name = "VtaEstaciones.findByEstaId", query = "SELECT v FROM VtaEstaciones v WHERE v.estaId = :estaId"),
    @NamedQuery(name = "VtaEstaciones.findByEstacodi", query = "SELECT v FROM VtaEstaciones v WHERE v.estacodi = :estacodi"),
    @NamedQuery(name = "VtaEstaciones.findByEstanomb", query = "SELECT v FROM VtaEstaciones v WHERE v.estanomb = :estanomb"),
    @NamedQuery(name = "VtaEstaciones.findByCoorlati", query = "SELECT v FROM VtaEstaciones v WHERE v.coorlati = :coorlati"),
    @NamedQuery(name = "VtaEstaciones.findByCoorlong", query = "SELECT v FROM VtaEstaciones v WHERE v.coorlong = :coorlong"),
    @NamedQuery(name = "VtaEstaciones.findByCooraltu", query = "SELECT v FROM VtaEstaciones v WHERE v.cooraltu = :cooraltu"),
    @NamedQuery(name = "VtaEstaciones.findByRegiId", query = "SELECT v FROM VtaEstaciones v WHERE v.regiId = :regiId"),
    @NamedQuery(name = "VtaEstaciones.findByCuenId", query = "SELECT v FROM VtaEstaciones v WHERE v.cuenId = :cuenId"),
    @NamedQuery(name = "VtaEstaciones.findByProvId", query = "SELECT v FROM VtaEstaciones v WHERE v.provId = :provId"),
    @NamedQuery(name = "VtaEstaciones.findByCantId", query = "SELECT v FROM VtaEstaciones v WHERE v.cantId = :cantId"),
    @NamedQuery(name = "VtaEstaciones.findByParrId", query = "SELECT v FROM VtaEstaciones v WHERE v.parrId = :parrId"),
    @NamedQuery(name = "VtaEstaciones.findByReginomb", query = "SELECT v FROM VtaEstaciones v WHERE v.reginomb = :reginomb"),
    @NamedQuery(name = "VtaEstaciones.findByCuennomb", query = "SELECT v FROM VtaEstaciones v WHERE v.cuennomb = :cuennomb"),
    @NamedQuery(name = "VtaEstaciones.findByProvnomb", query = "SELECT v FROM VtaEstaciones v WHERE v.provnomb = :provnomb"),
    @NamedQuery(name = "VtaEstaciones.findByCantnomb", query = "SELECT v FROM VtaEstaciones v WHERE v.cantnomb = :cantnomb"),
    @NamedQuery(name = "VtaEstaciones.findByParrnomb", query = "SELECT v FROM VtaEstaciones v WHERE v.parrnomb = :parrnomb"),
    @NamedQuery(name = "VtaEstaciones.findByEstaesta", query = "SELECT v FROM VtaEstaciones v WHERE v.estaesta = :estaesta")})
public class VtaEstaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "esta__id")
    @Id
    private Integer estaId;
    @Size(max = 8)
    @Column(name = "estacodi")
    private String estacodi;
    @Size(max = 100)
    @Column(name = "estanomb")
    private String estanomb;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coorlati", precision = 20, scale = 6)
    private BigDecimal coorlati;
    @Column(name = "coorlong", precision = 20, scale = 6)
    private BigDecimal coorlong;
    @Column(name = "cooraltu", precision = 20, scale = 6)
    private BigDecimal cooraltu;
    @Size(max = 4)
    @Column(name = "regi__id")
    private String regiId;
    @Size(max = 8)
    @Column(name = "cuen__id")
    private String cuenId;
    @Size(max = 4)
    @Column(name = "prov__id")
    private String provId;
    @Size(max = 4)
    @Column(name = "cant__id")
    private String cantId;
    @Size(max = 6)
    @Column(name = "parr__id")
    private String parrId;
    @Size(max = 100)
    @Column(name = "reginomb")
    private String reginomb;
    @Size(max = 100)
    @Column(name = "cuennomb")
    private String cuennomb;
    @Size(max = 100)
    @Column(name = "provnomb")
    private String provnomb;
    @Size(max = 200)
    @Column(name = "cantnomb")
    private String cantnomb;
    @Size(max = 100)
    @Column(name = "parrnomb")
    private String parrnomb;
    @Size(max = 100)
    @Column(name = "estenomb")
    private String estenomb;
    @Size(max = 100)
    @Column(name = "esteicon")
    private String esteicon;
    @Column(name = "estaesta")
    private Boolean estaesta;

    public VtaEstaciones() {
    }

    public Integer getEstaId() {
        return estaId;
    }

    public void setEstaId(Integer estaId) {
        this.estaId = estaId;
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

    public BigDecimal getCoorlati() {
        return coorlati;
    }

    public void setCoorlati(BigDecimal coorlati) {
        this.coorlati = coorlati;
    }

    public BigDecimal getCoorlong() {
        return coorlong;
    }

    public void setCoorlong(BigDecimal coorlong) {
        this.coorlong = coorlong;
    }

    public BigDecimal getCooraltu() {
        return cooraltu;
    }

    public void setCooraltu(BigDecimal cooraltu) {
        this.cooraltu = cooraltu;
    }

    public String getRegiId() {
        return regiId;
    }

    public void setRegiId(String regiId) {
        this.regiId = regiId;
    }

    public String getCuenId() {
        return cuenId;
    }

    public void setCuenId(String cuenId) {
        this.cuenId = cuenId;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getCantId() {
        return cantId;
    }

    public void setCantId(String cantId) {
        this.cantId = cantId;
    }

    public String getParrId() {
        return parrId;
    }

    public void setParrId(String parrId) {
        this.parrId = parrId;
    }

    public String getReginomb() {
        return reginomb;
    }

    public void setReginomb(String reginomb) {
        this.reginomb = reginomb;
    }

    public String getCuennomb() {
        return cuennomb;
    }

    public void setCuennomb(String cuennomb) {
        this.cuennomb = cuennomb;
    }

    public String getProvnomb() {
        return provnomb;
    }

    public void setProvnomb(String provnomb) {
        this.provnomb = provnomb;
    }

    public String getCantnomb() {
        return cantnomb;
    }

    public void setCantnomb(String cantnomb) {
        this.cantnomb = cantnomb;
    }

    public String getParrnomb() {
        return parrnomb;
    }

    public void setParrnomb(String parrnomb) {
        this.parrnomb = parrnomb;
    }

    public Boolean getEstaesta() {
        return estaesta;
    }

    public void setEstenomb(String estenomb) {
        this.estenomb = estenomb;
    }

    public String getEstenomb() {
        return estenomb;
    }

    public void setEsteicon(String esteicon) {
        this.esteicon = esteicon;
    }

    public String getEsteicon() {
        return esteicon;
    }

    public void setEstaesta(Boolean estaesta) {
        this.estaesta = estaesta;
    }
}
