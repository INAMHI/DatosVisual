/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dataf", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataf.findAll", query = "SELECT d FROM Dataf d"),
    @NamedQuery(name = "Dataf.findByDatafId", query = "SELECT d FROM Dataf d WHERE d.datafId = :datafId"),
    @NamedQuery(name = "Dataf.findByIndaId", query = "SELECT d FROM Dataf d WHERE d.indaId = :indaId"),
    @NamedQuery(name = "Dataf.findByDatafcdes", query = "SELECT d FROM Dataf d WHERE d.datafcdes = :datafcdes"),
    @NamedQuery(name = "Dataf.findByDatafnoar", query = "SELECT d FROM Dataf d WHERE d.datafnoar = :datafnoar"),
    @NamedQuery(name = "Dataf.findByDataffear", query = "SELECT d FROM Dataf d WHERE d.dataffear = :dataffear"),
    @NamedQuery(name = "Dataf.findByDatafdato", query = "SELECT d FROM Dataf d WHERE d.datafdato = :datafdato"),
    @NamedQuery(name = "Dataf.findByDatafveri", query = "SELECT d FROM Dataf d WHERE d.datafveri = :datafveri"),
    @NamedQuery(name = "Dataf.findByDatafdesc", query = "SELECT d FROM Dataf d WHERE d.datafdesc = :datafdesc"),
    @NamedQuery(name = "Dataf.findByDatafuing", query = "SELECT d FROM Dataf d WHERE d.datafuing = :datafuing"),
    @NamedQuery(name = "Dataf.findByDataffing", query = "SELECT d FROM Dataf d WHERE d.dataffing = :dataffing"),
    @NamedQuery(name = "Dataf.findByDatafumod", query = "SELECT d FROM Dataf d WHERE d.datafumod = :datafumod"),
    @NamedQuery(name = "Dataf.findByDataffmod", query = "SELECT d FROM Dataf d WHERE d.dataffmod = :dataffmod"),
    @NamedQuery(name = "Dataf.findByDataffrecp", query = "SELECT d FROM Dataf d WHERE d.dataffrecp = :dataffrecp")})
public class Dataf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dataf__id")
    private Integer datafId;
    @Size(max = 5)
    @Column(name = "inda__id")
    private String indaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "datafcdes")
    private String datafcdes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "datafnoar")
    private String datafnoar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataffear")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataffear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "datafdato")
    private String datafdato;
    @Column(name = "datafveri")
    private Boolean datafveri;
    @Size(max = 1000)
    @Column(name = "datafdesc")
    private String datafdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datafuing")
    private String datafuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataffing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataffing;
    @Size(max = 20)
    @Column(name = "datafumod")
    private String datafumod;
    @Column(name = "dataffmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataffmod;
    @Column(name = "dataffrecp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataffrecp;
    @JoinColumn(name = "frmt__id", referencedColumnName = "frmt__id")
    @ManyToOne
    private Frmt frmtId;

    public Dataf() {
    }

    public Dataf(Integer datafId) {
        this.datafId = datafId;
    }

    public Dataf(Integer datafId, String datafcdes, String datafnoar, Date dataffear, String datafdato, String datafuing, Date dataffing) {
        this.datafId = datafId;
        this.datafcdes = datafcdes;
        this.datafnoar = datafnoar;
        this.dataffear = dataffear;
        this.datafdato = datafdato;
        this.datafuing = datafuing;
        this.dataffing = dataffing;
    }

    public Integer getDatafId() {
        return datafId;
    }

    public void setDatafId(Integer datafId) {
        this.datafId = datafId;
    }

    public String getIndaId() {
        return indaId;
    }

    public void setIndaId(String indaId) {
        this.indaId = indaId;
    }

    public String getDatafcdes() {
        return datafcdes;
    }

    public void setDatafcdes(String datafcdes) {
        this.datafcdes = datafcdes;
    }

    public String getDatafnoar() {
        return datafnoar;
    }

    public void setDatafnoar(String datafnoar) {
        this.datafnoar = datafnoar;
    }

    public Date getDataffear() {
        return dataffear;
    }

    public void setDataffear(Date dataffear) {
        this.dataffear = dataffear;
    }

    public String getDatafdato() {
        return datafdato;
    }

    public void setDatafdato(String datafdato) {
        this.datafdato = datafdato;
    }

    public Boolean getDatafveri() {
        return datafveri;
    }

    public void setDatafveri(Boolean datafveri) {
        this.datafveri = datafveri;
    }

    public String getDatafdesc() {
        return datafdesc;
    }

    public void setDatafdesc(String datafdesc) {
        this.datafdesc = datafdesc;
    }

    public String getDatafuing() {
        return datafuing;
    }

    public void setDatafuing(String datafuing) {
        this.datafuing = datafuing;
    }

    public Date getDataffing() {
        return dataffing;
    }

    public void setDataffing(Date dataffing) {
        this.dataffing = dataffing;
    }

    public String getDatafumod() {
        return datafumod;
    }

    public void setDatafumod(String datafumod) {
        this.datafumod = datafumod;
    }

    public Date getDataffmod() {
        return dataffmod;
    }

    public void setDataffmod(Date dataffmod) {
        this.dataffmod = dataffmod;
    }

    public Date getDataffrecp() {
        return dataffrecp;
    }

    public void setDataffrecp(Date dataffrecp) {
        this.dataffrecp = dataffrecp;
    }

    public Frmt getFrmtId() {
        return frmtId;
    }

    public void setFrmtId(Frmt frmtId) {
        this.frmtId = frmtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datafId != null ? datafId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dataf)) {
            return false;
        }
        Dataf other = (Dataf) object;
        if ((this.datafId == null && other.datafId != null) || (this.datafId != null && !this.datafId.equals(other.datafId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Dataf[ datafId=" + datafId + " ]";
    }
    
}
