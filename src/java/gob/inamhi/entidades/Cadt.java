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
@Table(name = "cadt", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadt.findAll", query = "SELECT c FROM Cadt c"),
    @NamedQuery(name = "Cadt.findByCadtId", query = "SELECT c FROM Cadt c WHERE c.cadtId = :cadtId"),
    @NamedQuery(name = "Cadt.findByCadtvalo", query = "SELECT c FROM Cadt c WHERE c.cadtvalo = :cadtvalo"),
    @NamedQuery(name = "Cadt.findByCadtcodi", query = "SELECT c FROM Cadt c WHERE c.cadtcodi = :cadtcodi"),
    @NamedQuery(name = "Cadt.findByCadtdesc", query = "SELECT c FROM Cadt c WHERE c.cadtdesc = :cadtdesc"),
    @NamedQuery(name = "Cadt.findByCadtuing", query = "SELECT c FROM Cadt c WHERE c.cadtuing = :cadtuing"),
    @NamedQuery(name = "Cadt.findByCadtfing", query = "SELECT c FROM Cadt c WHERE c.cadtfing = :cadtfing"),
    @NamedQuery(name = "Cadt.findByCadtumod", query = "SELECT c FROM Cadt c WHERE c.cadtumod = :cadtumod"),
    @NamedQuery(name = "Cadt.findByCadtfmod", query = "SELECT c FROM Cadt c WHERE c.cadtfmod = :cadtfmod")})
public class Cadt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cadt__id")
    private Integer cadtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "cadtvalo")
    private String cadtvalo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "cadtcodi")
    private String cadtcodi;
    @Size(max = 1000)
    @Column(name = "cadtdesc")
    private String cadtdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cadtuing")
    private String cadtuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cadtfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cadtfing;
    @Size(max = 20)
    @Column(name = "cadtumod")
    private String cadtumod;
    @Column(name = "cadtfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cadtfmod;
    @JoinColumn(name = "mdtl__id", referencedColumnName = "mdtl__id")
    @ManyToOne
    private Mdtl mdtlId;
    @JoinColumn(name = "calin__id", referencedColumnName = "calin__id")
    @ManyToOne
    private Calin calinId;

    public Cadt() {
    }

    public Cadt(Integer cadtId) {
        this.cadtId = cadtId;
    }

    public Cadt(Integer cadtId, String cadtvalo, String cadtcodi, String cadtuing, Date cadtfing) {
        this.cadtId = cadtId;
        this.cadtvalo = cadtvalo;
        this.cadtcodi = cadtcodi;
        this.cadtuing = cadtuing;
        this.cadtfing = cadtfing;
    }

    public Integer getCadtId() {
        return cadtId;
    }

    public void setCadtId(Integer cadtId) {
        this.cadtId = cadtId;
    }

    public String getCadtvalo() {
        return cadtvalo;
    }

    public void setCadtvalo(String cadtvalo) {
        this.cadtvalo = cadtvalo;
    }

    public String getCadtcodi() {
        return cadtcodi;
    }

    public void setCadtcodi(String cadtcodi) {
        this.cadtcodi = cadtcodi;
    }

    public String getCadtdesc() {
        return cadtdesc;
    }

    public void setCadtdesc(String cadtdesc) {
        this.cadtdesc = cadtdesc;
    }

    public String getCadtuing() {
        return cadtuing;
    }

    public void setCadtuing(String cadtuing) {
        this.cadtuing = cadtuing;
    }

    public Date getCadtfing() {
        return cadtfing;
    }

    public void setCadtfing(Date cadtfing) {
        this.cadtfing = cadtfing;
    }

    public String getCadtumod() {
        return cadtumod;
    }

    public void setCadtumod(String cadtumod) {
        this.cadtumod = cadtumod;
    }

    public Date getCadtfmod() {
        return cadtfmod;
    }

    public void setCadtfmod(Date cadtfmod) {
        this.cadtfmod = cadtfmod;
    }

    public Mdtl getMdtlId() {
        return mdtlId;
    }

    public void setMdtlId(Mdtl mdtlId) {
        this.mdtlId = mdtlId;
    }

    public Calin getCalinId() {
        return calinId;
    }

    public void setCalinId(Calin calinId) {
        this.calinId = calinId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cadtId != null ? cadtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadt)) {
            return false;
        }
        Cadt other = (Cadt) object;
        if ((this.cadtId == null && other.cadtId != null) || (this.cadtId != null && !this.cadtId.equals(other.cadtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cadt[ cadtId=" + cadtId + " ]";
    }
}
