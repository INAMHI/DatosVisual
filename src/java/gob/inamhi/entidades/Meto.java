/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "meto", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meto.findAll", query = "SELECT m FROM Meto m"),
    @NamedQuery(name = "Meto.findByMetoId", query = "SELECT m FROM Meto m WHERE m.metoId = :metoId"),
    @NamedQuery(name = "Meto.findByMetocodi", query = "SELECT m FROM Meto m WHERE m.metocodi = :metocodi"),
    @NamedQuery(name = "Meto.findByMetonomb", query = "SELECT m FROM Meto m WHERE m.metonomb = :metonomb"),
    @NamedQuery(name = "Meto.findByMetoobse", query = "SELECT m FROM Meto m WHERE m.metoobse = :metoobse"),
    @NamedQuery(name = "Meto.findByMetouing", query = "SELECT m FROM Meto m WHERE m.metouing = :metouing"),
    @NamedQuery(name = "Meto.findByMetofing", query = "SELECT m FROM Meto m WHERE m.metofing = :metofing"),
    @NamedQuery(name = "Meto.findByMetoumod", query = "SELECT m FROM Meto m WHERE m.metoumod = :metoumod"),
    @NamedQuery(name = "Meto.findByMetofmod", query = "SELECT m FROM Meto m WHERE m.metofmod = :metofmod")})
public class Meto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meto__id")
    private Integer metoId;
    @Size(max = 8)
    @Column(name = "metocodi")
    private String metocodi;
    @Size(max = 50)
    @Column(name = "metonomb")
    private String metonomb;
    @Size(max = 100)
    @Column(name = "metoobse")
    private String metoobse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "metouing")
    private String metouing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metofing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date metofing;
    @Size(max = 20)
    @Column(name = "metoumod")
    private String metoumod;
    @Column(name = "metofmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date metofmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metoId")
    private Collection<Hisda> hisdaCollection;

    public Meto() {
    }

    public Meto(Integer metoId) {
        this.metoId = metoId;
    }

    public Meto(Integer metoId, String metouing, Date metofing) {
        this.metoId = metoId;
        this.metouing = metouing;
        this.metofing = metofing;
    }

    public Integer getMetoId() {
        return metoId;
    }

    public void setMetoId(Integer metoId) {
        this.metoId = metoId;
    }

    public String getMetocodi() {
        return metocodi;
    }

    public void setMetocodi(String metocodi) {
        this.metocodi = metocodi;
    }

    public String getMetonomb() {
        return metonomb;
    }

    public void setMetonomb(String metonomb) {
        this.metonomb = metonomb;
    }

    public String getMetoobse() {
        return metoobse;
    }

    public void setMetoobse(String metoobse) {
        this.metoobse = metoobse;
    }

    public String getMetouing() {
        return metouing;
    }

    public void setMetouing(String metouing) {
        this.metouing = metouing;
    }

    public Date getMetofing() {
        return metofing;
    }

    public void setMetofing(Date metofing) {
        this.metofing = metofing;
    }

    public String getMetoumod() {
        return metoumod;
    }

    public void setMetoumod(String metoumod) {
        this.metoumod = metoumod;
    }

    public Date getMetofmod() {
        return metofmod;
    }

    public void setMetofmod(Date metofmod) {
        this.metofmod = metofmod;
    }

    @XmlTransient
    public Collection<Hisda> getHisdaCollection() {
        return hisdaCollection;
    }

    public void setHisdaCollection(Collection<Hisda> hisdaCollection) {
        this.hisdaCollection = hisdaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metoId != null ? metoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meto)) {
            return false;
        }
        Meto other = (Meto) object;
        if ((this.metoId == null && other.metoId != null) || (this.metoId != null && !this.metoId.equals(other.metoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Meto[ metoId=" + metoId + " ]";
    }
    
}
