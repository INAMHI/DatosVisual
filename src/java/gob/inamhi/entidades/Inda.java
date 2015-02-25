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
@Table(name = "inda", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inda.findAll", query = "SELECT i FROM Inda i"),
    @NamedQuery(name = "Inda.findByIndaId", query = "SELECT i FROM Inda i WHERE i.indaId = :indaId"),
    @NamedQuery(name = "Inda.findByIndanomb", query = "SELECT i FROM Inda i WHERE i.indanomb = :indanomb"),
    @NamedQuery(name = "Inda.findByIndauing", query = "SELECT i FROM Inda i WHERE i.indauing = :indauing"),
    @NamedQuery(name = "Inda.findByIndafing", query = "SELECT i FROM Inda i WHERE i.indafing = :indafing"),
    @NamedQuery(name = "Inda.findByIndaumod", query = "SELECT i FROM Inda i WHERE i.indaumod = :indaumod"),
    @NamedQuery(name = "Inda.findByIndafmod", query = "SELECT i FROM Inda i WHERE i.indafmod = :indafmod")})
public class Inda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "inda__id")
    private String indaId;
    @Size(max = 50)
    @Column(name = "indanomb")
    private String indanomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "indauing")
    private String indauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indafing;
    @Size(max = 20)
    @Column(name = "indaumod")
    private String indaumod;
    @Column(name = "indafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indafmod;

    public Inda() {
    }

    public Inda(String indaId) {
        this.indaId = indaId;
    }

    public Inda(String indaId, String indauing, Date indafing) {
        this.indaId = indaId;
        this.indauing = indauing;
        this.indafing = indafing;
    }

    public String getIndaId() {
        return indaId;
    }

    public void setIndaId(String indaId) {
        this.indaId = indaId;
    }

    public String getIndanomb() {
        return indanomb;
    }

    public void setIndanomb(String indanomb) {
        this.indanomb = indanomb;
    }

    public String getIndauing() {
        return indauing;
    }

    public void setIndauing(String indauing) {
        this.indauing = indauing;
    }

    public Date getIndafing() {
        return indafing;
    }

    public void setIndafing(Date indafing) {
        this.indafing = indafing;
    }

    public String getIndaumod() {
        return indaumod;
    }

    public void setIndaumod(String indaumod) {
        this.indaumod = indaumod;
    }

    public Date getIndafmod() {
        return indafmod;
    }

    public void setIndafmod(Date indafmod) {
        this.indafmod = indafmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indaId != null ? indaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inda)) {
            return false;
        }
        Inda other = (Inda) object;
        if ((this.indaId == null && other.indaId != null) || (this.indaId != null && !this.indaId.equals(other.indaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inda[ indaId=" + indaId + " ]";
    }
    
}
