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
 * @author dhinojosa
 */
@Entity
@Table(name = "frmt", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frmt.findAll", query = "SELECT f FROM Frmt f"),
    @NamedQuery(name = "Frmt.findByFrmtId", query = "SELECT f FROM Frmt f WHERE f.frmtId = :frmtId"),
    @NamedQuery(name = "Frmt.findByFrmtcodi", query = "SELECT f FROM Frmt f WHERE f.frmtcodi = :frmtcodi"),
    @NamedQuery(name = "Frmt.findByFrmtdesc", query = "SELECT f FROM Frmt f WHERE f.frmtdesc = :frmtdesc"),
    @NamedQuery(name = "Frmt.findByFrmtdocm", query = "SELECT f FROM Frmt f WHERE f.frmtdocm = :frmtdocm"),
    @NamedQuery(name = "Frmt.findByFrmtdeco", query = "SELECT f FROM Frmt f WHERE f.frmtdeco = :frmtdeco"),
    @NamedQuery(name = "Frmt.findByFrmtuing", query = "SELECT f FROM Frmt f WHERE f.frmtuing = :frmtuing"),
    @NamedQuery(name = "Frmt.findByFrmtfing", query = "SELECT f FROM Frmt f WHERE f.frmtfing = :frmtfing"),
    @NamedQuery(name = "Frmt.findByFrmtumod", query = "SELECT f FROM Frmt f WHERE f.frmtumod = :frmtumod"),
    @NamedQuery(name = "Frmt.findByFrmtfmod", query = "SELECT f FROM Frmt f WHERE f.frmtfmod = :frmtfmod")})
public class Frmt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "frmt__id")
    private Integer frmtId;
    @Size(max = 1000)
    @Column(name = "frmtcodi")
    private String frmtcodi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "frmtdesc")
    private String frmtdesc;
    @Size(max = 3000)
    @Column(name = "frmtdocm")
    private String frmtdocm;
    @Size(max = 3000)
    @Column(name = "frmtdeco")
    private String frmtdeco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "frmtuing")
    private String frmtuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frmtfing")
    @Temporal(TemporalType.DATE)
    private Date frmtfing;
    @Size(max = 20)
    @Column(name = "frmtumod")
    private String frmtumod;
    @Column(name = "frmtfmod")
    @Temporal(TemporalType.DATE)
    private Date frmtfmod;
    @OneToMany(mappedBy = "frmtId")
    private Collection<Dataf> datafCollection;

    public Frmt() {
    }

    public Frmt(Integer frmtId) {
        this.frmtId = frmtId;
    }

    public Frmt(Integer frmtId, String frmtdesc, String frmtuing, Date frmtfing) {
        this.frmtId = frmtId;
        this.frmtdesc = frmtdesc;
        this.frmtuing = frmtuing;
        this.frmtfing = frmtfing;
    }

    public Integer getFrmtId() {
        return frmtId;
    }

    public void setFrmtId(Integer frmtId) {
        this.frmtId = frmtId;
    }

    public String getFrmtcodi() {
        return frmtcodi;
    }

    public void setFrmtcodi(String frmtcodi) {
        this.frmtcodi = frmtcodi;
    }

    public String getFrmtdesc() {
        return frmtdesc;
    }

    public void setFrmtdesc(String frmtdesc) {
        this.frmtdesc = frmtdesc;
    }

    public String getFrmtdocm() {
        return frmtdocm;
    }

    public void setFrmtdocm(String frmtdocm) {
        this.frmtdocm = frmtdocm;
    }

    public String getFrmtdeco() {
        return frmtdeco;
    }

    public void setFrmtdeco(String frmtdeco) {
        this.frmtdeco = frmtdeco;
    }

    public String getFrmtuing() {
        return frmtuing;
    }

    public void setFrmtuing(String frmtuing) {
        this.frmtuing = frmtuing;
    }

    public Date getFrmtfing() {
        return frmtfing;
    }

    public void setFrmtfing(Date frmtfing) {
        this.frmtfing = frmtfing;
    }

    public String getFrmtumod() {
        return frmtumod;
    }

    public void setFrmtumod(String frmtumod) {
        this.frmtumod = frmtumod;
    }

    public Date getFrmtfmod() {
        return frmtfmod;
    }

    public void setFrmtfmod(Date frmtfmod) {
        this.frmtfmod = frmtfmod;
    }

    @XmlTransient
    public Collection<Dataf> getDatafCollection() {
        return datafCollection;
    }

    public void setDatafCollection(Collection<Dataf> datafCollection) {
        this.datafCollection = datafCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frmtId != null ? frmtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frmt)) {
            return false;
        }
        Frmt other = (Frmt) object;
        if ((this.frmtId == null && other.frmtId != null) || (this.frmtId != null && !this.frmtId.equals(other.frmtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Frmt[ frmtId=" + frmtId + " ]";
    }
    
}
