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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Diego
 */
@Entity
@Table(name = "cali", schema = "processed_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cali.findAll", query = "SELECT c FROM Cali c"),
    @NamedQuery(name = "Cali.findByCaliId", query = "SELECT c FROM Cali c WHERE c.caliId = :caliId"),
    @NamedQuery(name = "Cali.findByCalinomb", query = "SELECT c FROM Cali c WHERE c.calinomb = :calinomb"),
    @NamedQuery(name = "Cali.findByCaliuing", query = "SELECT c FROM Cali c WHERE c.caliuing = :caliuing"),
    @NamedQuery(name = "Cali.findByCalifing", query = "SELECT c FROM Cali c WHERE c.califing = :califing"),
    @NamedQuery(name = "Cali.findByCaliumod", query = "SELECT c FROM Cali c WHERE c.caliumod = :caliumod"),
    @NamedQuery(name = "Cali.findByCalifmod", query = "SELECT c FROM Cali c WHERE c.califmod = :califmod")})
public class Cali implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cali__id")
    private Integer caliId;
    @Size(max = 20)
    @Column(name = "calinomb")
    private String calinomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "caliuing")
    private String caliuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "califing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date califing;
    @Size(max = 20)
    @Column(name = "caliumod")
    private String caliumod;
    @Column(name = "califmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date califmod;
    @OneToMany(mappedBy = "caliId")
    private Collection<Data1h> data1hCollection;

    public Cali() {
    }

    public Cali(Integer caliId) {
        this.caliId = caliId;
    }

    public Cali(Integer caliId, String caliuing, Date califing) {
        this.caliId = caliId;
        this.caliuing = caliuing;
        this.califing = califing;
    }

    public Integer getCaliId() {
        return caliId;
    }

    public void setCaliId(Integer caliId) {
        this.caliId = caliId;
    }

    public String getCalinomb() {
        return calinomb;
    }

    public void setCalinomb(String calinomb) {
        this.calinomb = calinomb;
    }

    public String getCaliuing() {
        return caliuing;
    }

    public void setCaliuing(String caliuing) {
        this.caliuing = caliuing;
    }

    public Date getCalifing() {
        return califing;
    }

    public void setCalifing(Date califing) {
        this.califing = califing;
    }

    public String getCaliumod() {
        return caliumod;
    }

    public void setCaliumod(String caliumod) {
        this.caliumod = caliumod;
    }

    public Date getCalifmod() {
        return califmod;
    }

    public void setCalifmod(Date califmod) {
        this.califmod = califmod;
    }

    @XmlTransient
    public Collection<Data1h> getData1hCollection() {
        return data1hCollection;
    }

    public void setData1hCollection(Collection<Data1h> data1hCollection) {
        this.data1hCollection = data1hCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caliId != null ? caliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cali)) {
            return false;
        }
        Cali other = (Cali) object;
        if ((this.caliId == null && other.caliId != null) || (this.caliId != null && !this.caliId.equals(other.caliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cali[ caliId=" + caliId + " ]";
    }
}
