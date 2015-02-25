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
@Table(name = "trco", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trco.findAll", query = "SELECT t FROM Trco t"),
    @NamedQuery(name = "Trco.findByTrcoId", query = "SELECT t FROM Trco t WHERE t.trcoId = :trcoId"),
    @NamedQuery(name = "Trco.findByTrcodesc", query = "SELECT t FROM Trco t WHERE t.trcodesc = :trcodesc"),
    @NamedQuery(name = "Trco.findByTrcouing", query = "SELECT t FROM Trco t WHERE t.trcouing = :trcouing"),
    @NamedQuery(name = "Trco.findByTrcofing", query = "SELECT t FROM Trco t WHERE t.trcofing = :trcofing"),
    @NamedQuery(name = "Trco.findByTrcoumod", query = "SELECT t FROM Trco t WHERE t.trcoumod = :trcoumod"),
    @NamedQuery(name = "Trco.findByTrcofmod", query = "SELECT t FROM Trco t WHERE t.trcofmod = :trcofmod")})
public class Trco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "trco__id")
    private String trcoId;
    @Size(max = 1000)
    @Column(name = "trcodesc")
    private String trcodesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "trcouing")
    private String trcouing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trcofing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trcofing;
    @Size(max = 20)
    @Column(name = "trcoumod")
    private String trcoumod;
    @Column(name = "trcofmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trcofmod;
    @JoinColumn(name = "prtr__id", referencedColumnName = "prtr__id")
    @ManyToOne
    private Prtr prtrId;
    @JoinColumn(name = "prco__id", referencedColumnName = "prco__id")
    @ManyToOne
    private Prco prcoId;

    public Trco() {
    }

    public Trco(String trcoId) {
        this.trcoId = trcoId;
    }

    public Trco(String trcoId, String trcouing, Date trcofing) {
        this.trcoId = trcoId;
        this.trcouing = trcouing;
        this.trcofing = trcofing;
    }

    public String getTrcoId() {
        return trcoId;
    }

    public void setTrcoId(String trcoId) {
        this.trcoId = trcoId;
    }

    public String getTrcodesc() {
        return trcodesc;
    }

    public void setTrcodesc(String trcodesc) {
        this.trcodesc = trcodesc;
    }

    public String getTrcouing() {
        return trcouing;
    }

    public void setTrcouing(String trcouing) {
        this.trcouing = trcouing;
    }

    public Date getTrcofing() {
        return trcofing;
    }

    public void setTrcofing(Date trcofing) {
        this.trcofing = trcofing;
    }

    public String getTrcoumod() {
        return trcoumod;
    }

    public void setTrcoumod(String trcoumod) {
        this.trcoumod = trcoumod;
    }

    public Date getTrcofmod() {
        return trcofmod;
    }

    public void setTrcofmod(Date trcofmod) {
        this.trcofmod = trcofmod;
    }

    public Prtr getPrtrId() {
        return prtrId;
    }

    public void setPrtrId(Prtr prtrId) {
        this.prtrId = prtrId;
    }

    public Prco getPrcoId() {
        return prcoId;
    }

    public void setPrcoId(Prco prcoId) {
        this.prcoId = prcoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trcoId != null ? trcoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trco)) {
            return false;
        }
        Trco other = (Trco) object;
        if ((this.trcoId == null && other.trcoId != null) || (this.trcoId != null && !this.trcoId.equals(other.trcoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Trco[ trcoId=" + trcoId + " ]";
    }
    
}
