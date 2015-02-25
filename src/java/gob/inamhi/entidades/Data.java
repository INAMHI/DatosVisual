/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "data", schema = "storage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findByDataId", query = "SELECT d FROM Data d WHERE d.dataId = :dataId"),
    @NamedQuery(name = "Data.findByEstaId", query = "SELECT d FROM Data d WHERE d.estaId = :estaId"),
    @NamedQuery(name = "Data.findByCopaId", query = "SELECT d FROM Data d WHERE d.copaId = :copaId"),
    @NamedQuery(name = "Data.findByCadtId", query = "SELECT d FROM Data d WHERE d.cadtId = :cadtId"),
    @NamedQuery(name = "Data.findByCali1Id", query = "SELECT d FROM Data d WHERE d.cali1Id = :cali1Id"),
    @NamedQuery(name = "Data.findByFennId", query = "SELECT d FROM Data d WHERE d.fennId = :fennId"),
    @NamedQuery(name = "Data.findByCfgesId", query = "SELECT d FROM Data d WHERE d.cfgesId = :cfgesId"),
    @NamedQuery(name = "Data.findByTrcoId", query = "SELECT d FROM Data d WHERE d.trcoId = :trcoId"),
    @NamedQuery(name = "Data.findByIndaId", query = "SELECT d FROM Data d WHERE d.indaId = :indaId"),
    @NamedQuery(name = "Data.findByDatafetd", query = "SELECT d FROM Data d WHERE d.datafetd = :datafetd"),
    @NamedQuery(name = "Data.findByDatavalo", query = "SELECT d FROM Data d WHERE d.datavalo = :datavalo"),
    @NamedQuery(name = "Data.findByDataince", query = "SELECT d FROM Data d WHERE d.dataince = :dataince"),
    @NamedQuery(name = "Data.findByDataobse", query = "SELECT d FROM Data d WHERE d.dataobse = :dataobse"),
    @NamedQuery(name = "Data.findByDatactrl", query = "SELECT d FROM Data d WHERE d.datactrl = :datactrl"),
    @NamedQuery(name = "Data.findByDatavers", query = "SELECT d FROM Data d WHERE d.datavers = :datavers"),
    @NamedQuery(name = "Data.findByDatauing", query = "SELECT d FROM Data d WHERE d.datauing = :datauing"),
    @NamedQuery(name = "Data.findByDatafing", query = "SELECT d FROM Data d WHERE d.datafing = :datafing"),
    @NamedQuery(name = "Data.findByDataumod", query = "SELECT d FROM Data d WHERE d.dataumod = :dataumod"),
    @NamedQuery(name = "Data.findByDatafmod", query = "SELECT d FROM Data d WHERE d.datafmod = :datafmod")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "data__id")
    private String dataId;
    @Column(name = "esta__id")
    private Integer estaId;
    @Column(name = "copa__id")
    private Integer copaId;
    @Column(name = "cadt__id")
    private String cadtId;
    @Column(name = "cali1__id")
    private Integer cali1Id;
    @Column(name = "fenn__id")
    private Integer fennId;
    @Column(name = "cfges__id")
    private Integer cfgesId;
    @Column(name = "trco__id")
    private String trcoId;
    @Column(name = "inda__id")
    private String indaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datafetd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafetd;
    @Column(name = "datavalo")
    private BigDecimal datavalo;
    @Column(name = "dataince", nullable = true)
    private BigInteger dataince;
    @Size(max = 2147483647)
    @Column(name = "dataobse")
    private String dataobse;
    @Column(name = "datactrl")
    private Boolean datactrl;
    @Column(name = "datavers")
    private Integer datavers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datauing")
    private String datauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafing;
    @Size(max = 20)
    @Column(name = "dataumod")
    private String dataumod;
    @Column(name = "datafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafmod;

    public Data() {
    }

    public Data(String dataId) {
        this.dataId = dataId;
    }

    public Data(String dataId, Date datafetd, String datauing, Date datafing) {
        this.dataId = dataId;
        this.datafetd = datafetd;
        this.datauing = datauing;
        this.datafing = datafing;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getEstaId() {
        return estaId;
    }

    public void setEstaId(Integer estaId) {
        this.estaId = estaId;
    }

    public Integer getCopaId() {
        return copaId;
    }

    public void setCopaId(Integer copaId) {
        this.copaId = copaId;
    }

    public String getCadtId() {
        return cadtId;
    }

    public void setCadtId(String cadtId) {
        this.cadtId = cadtId;
    }

    public Integer getCali1Id() {
        return cali1Id;
    }

    public void setCali1Id(Integer cali1Id) {
        this.cali1Id = cali1Id;
    }

    public Integer getFennId() {
        return fennId;
    }

    public void setFennId(Integer fennId) {
        this.fennId = fennId;
    }

    public Integer getCfgesId() {
        return cfgesId;
    }

    public void setCfgesId(Integer cfgesId) {
        this.cfgesId = cfgesId;
    }

    public String getTrcoId() {
        return trcoId;
    }

    public void setTrcoId(String trcoId) {
        this.trcoId = trcoId;
    }

    public String getIndaId() {
        return indaId;
    }

    public void setIndaId(String indaId) {
        this.indaId = indaId;
    }

    public Date getDatafetd() {
        return datafetd;
    }

    public void setDatafetd(Date datafetd) {
        this.datafetd = datafetd;
    }

    public BigDecimal getDatavalo() {
        return datavalo;
    }

    public void setDatavalo(BigDecimal datavalo) {
        this.datavalo = datavalo;
    }

    public BigInteger getDataince() {
        return dataince;
    }

    public void setDataince(BigInteger dataince) {
        this.dataince = dataince;
    }

    public String getDataobse() {
        return dataobse;
    }

    public void setDataobse(String dataobse) {
        this.dataobse = dataobse;
    }

    public Boolean getDatactrl() {
        return datactrl;
    }

    public void setDatactrl(Boolean datactrl) {
        this.datactrl = datactrl;
    }

    public Integer getDatavers() {
        return datavers;
    }

    public void setDatavers(Integer datavers) {
        this.datavers = datavers;
    }

    public String getDatauing() {
        return datauing;
    }

    public void setDatauing(String datauing) {
        this.datauing = datauing;
    }

    public Date getDatafing() {
        return datafing;
    }

    public void setDatafing(Date datafing) {
        this.datafing = datafing;
    }

    public String getDataumod() {
        return dataumod;
    }

    public void setDataumod(String dataumod) {
        this.dataumod = dataumod;
    }

    public Date getDatafmod() {
        return datafmod;
    }

    public void setDatafmod(Date datafmod) {
        this.datafmod = datafmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataId != null ? dataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.dataId == null && other.dataId != null) || (this.dataId != null && !this.dataId.equals(other.dataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Data[ dataId=" + dataId + " ]";
    }
}
