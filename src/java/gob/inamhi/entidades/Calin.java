/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "calin", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calin.findAll", query = "SELECT c FROM Calin c"),
    @NamedQuery(name = "Calin.findByCalinId", query = "SELECT c FROM Calin c WHERE c.calinId = :calinId"),
    @NamedQuery(name = "Calin.findByCalinnomb", query = "SELECT c FROM Calin c WHERE c.calinnomb = :calinnomb"),
    @NamedQuery(name = "Calin.findByCalinuing", query = "SELECT c FROM Calin c WHERE c.calinuing = :calinuing"),
    @NamedQuery(name = "Calin.findByCalinfing", query = "SELECT c FROM Calin c WHERE c.calinfing = :calinfing"),
    @NamedQuery(name = "Calin.findByCalinumod", query = "SELECT c FROM Calin c WHERE c.calinumod = :calinumod"),
    @NamedQuery(name = "Calin.findByCalinfmod", query = "SELECT c FROM Calin c WHERE c.calinfmod = :calinfmod"),
    @NamedQuery(name = "Calin.findByCalindesc", query = "SELECT c FROM Calin c WHERE c.calindesc = :calindesc")})
public class Calin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "calin__id")
    private String calinId;
    @Size(max = 50)
    @Column(name = "calinnomb")
    private String calinnomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "calinuing")
    private String calinuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calinfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calinfing;
    @Size(max = 20)
    @Column(name = "calinumod")
    private String calinumod;
    @Column(name = "calinfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calinfmod;
    @Size(max = 2147483647)
    @Column(name = "calindesc")
    private String calindesc;
    @OneToMany(mappedBy = "calinId")
    private Collection<Cadt> cadtCollection;

    public Calin() {
    }

    public Calin(String calinId) {
        this.calinId = calinId;
    }

    public Calin(String calinId, String calinuing, Date calinfing) {
        this.calinId = calinId;
        this.calinuing = calinuing;
        this.calinfing = calinfing;
    }

    public String getCalinId() {
        return calinId;
    }

    public void setCalinId(String calinId) {
        this.calinId = calinId;
    }

    public String getCalinnomb() {
        return calinnomb;
    }

    public void setCalinnomb(String calinnomb) {
        this.calinnomb = calinnomb;
    }

    public String getCalinuing() {
        return calinuing;
    }

    public void setCalinuing(String calinuing) {
        this.calinuing = calinuing;
    }

    public Date getCalinfing() {
        return calinfing;
    }

    public void setCalinfing(Date calinfing) {
        this.calinfing = calinfing;
    }

    public String getCalinumod() {
        return calinumod;
    }

    public void setCalinumod(String calinumod) {
        this.calinumod = calinumod;
    }

    public Date getCalinfmod() {
        return calinfmod;
    }

    public void setCalinfmod(Date calinfmod) {
        this.calinfmod = calinfmod;
    }

    public String getCalindesc() {
        return calindesc;
    }

    public void setCalindesc(String calindesc) {
        this.calindesc = calindesc;
    }

    @XmlTransient
    public Collection<Cadt> getCadtCollection() {
        return cadtCollection;
    }

    public void setCadtCollection(Collection<Cadt> cadtCollection) {
        this.cadtCollection = cadtCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calinId != null ? calinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calin)) {
            return false;
        }
        Calin other = (Calin) object;
        if ((this.calinId == null && other.calinId != null) || (this.calinId != null && !this.calinId.equals(other.calinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Calin[ calinId=" + calinId + " ]";
    }
    
}
