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
@Table(name = "mdtl", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdtl.findAll", query = "SELECT m FROM Mdtl m"),
    @NamedQuery(name = "Mdtl.findByMdtlId", query = "SELECT m FROM Mdtl m WHERE m.mdtlId = :mdtlId"),
    @NamedQuery(name = "Mdtl.findByMarcId", query = "SELECT m FROM Mdtl m WHERE m.marcId = :marcId"),
    @NamedQuery(name = "Mdtl.findByMdtlnomb", query = "SELECT m FROM Mdtl m WHERE m.mdtlnomb = :mdtlnomb"),
    @NamedQuery(name = "Mdtl.findByMdtldesc", query = "SELECT m FROM Mdtl m WHERE m.mdtldesc = :mdtldesc"),
    @NamedQuery(name = "Mdtl.findByMdtluing", query = "SELECT m FROM Mdtl m WHERE m.mdtluing = :mdtluing"),
    @NamedQuery(name = "Mdtl.findByMdtlfing", query = "SELECT m FROM Mdtl m WHERE m.mdtlfing = :mdtlfing"),
    @NamedQuery(name = "Mdtl.findByMdtlumod", query = "SELECT m FROM Mdtl m WHERE m.mdtlumod = :mdtlumod"),
    @NamedQuery(name = "Mdtl.findByMdtlfmod", query = "SELECT m FROM Mdtl m WHERE m.mdtlfmod = :mdtlfmod")})
public class Mdtl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mdtl__id")
    private Integer mdtlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marc__id")
    private int marcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mdtlnomb")
    private String mdtlnomb;
    @Size(max = 100)
    @Column(name = "mdtldesc")
    private String mdtldesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mdtluing")
    private String mdtluing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdtlfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdtlfing;
    @Size(max = 20)
    @Column(name = "mdtlumod")
    private String mdtlumod;
    @Column(name = "mdtlfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdtlfmod;
    @OneToMany(mappedBy = "mdtlId")
    private Collection<Cadt> cadtCollection;

    public Mdtl() {
    }

    public Mdtl(Integer mdtlId) {
        this.mdtlId = mdtlId;
    }

    public Mdtl(Integer mdtlId, int marcId, String mdtlnomb, String mdtluing, Date mdtlfing) {
        this.mdtlId = mdtlId;
        this.marcId = marcId;
        this.mdtlnomb = mdtlnomb;
        this.mdtluing = mdtluing;
        this.mdtlfing = mdtlfing;
    }

    public Integer getMdtlId() {
        return mdtlId;
    }

    public void setMdtlId(Integer mdtlId) {
        this.mdtlId = mdtlId;
    }

    public int getMarcId() {
        return marcId;
    }

    public void setMarcId(int marcId) {
        this.marcId = marcId;
    }

    public String getMdtlnomb() {
        return mdtlnomb;
    }

    public void setMdtlnomb(String mdtlnomb) {
        this.mdtlnomb = mdtlnomb;
    }

    public String getMdtldesc() {
        return mdtldesc;
    }

    public void setMdtldesc(String mdtldesc) {
        this.mdtldesc = mdtldesc;
    }

    public String getMdtluing() {
        return mdtluing;
    }

    public void setMdtluing(String mdtluing) {
        this.mdtluing = mdtluing;
    }

    public Date getMdtlfing() {
        return mdtlfing;
    }

    public void setMdtlfing(Date mdtlfing) {
        this.mdtlfing = mdtlfing;
    }

    public String getMdtlumod() {
        return mdtlumod;
    }

    public void setMdtlumod(String mdtlumod) {
        this.mdtlumod = mdtlumod;
    }

    public Date getMdtlfmod() {
        return mdtlfmod;
    }

    public void setMdtlfmod(Date mdtlfmod) {
        this.mdtlfmod = mdtlfmod;
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
        hash += (mdtlId != null ? mdtlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdtl)) {
            return false;
        }
        Mdtl other = (Mdtl) object;
        if ((this.mdtlId == null && other.mdtlId != null) || (this.mdtlId != null && !this.mdtlId.equals(other.mdtlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mdtl[ mdtlId=" + mdtlId + " ]";
    }
    
}
