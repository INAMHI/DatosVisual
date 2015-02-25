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
@Table(name = "prtr", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prtr.findAll", query = "SELECT p FROM Prtr p"),
    @NamedQuery(name = "Prtr.findByPrtrId", query = "SELECT p FROM Prtr p WHERE p.prtrId = :prtrId"),
    @NamedQuery(name = "Prtr.findByPrtrnomb", query = "SELECT p FROM Prtr p WHERE p.prtrnomb = :prtrnomb"),
    @NamedQuery(name = "Prtr.findByPrtrsigl", query = "SELECT p FROM Prtr p WHERE p.prtrsigl = :prtrsigl"),
    @NamedQuery(name = "Prtr.findByPrtrdesc", query = "SELECT p FROM Prtr p WHERE p.prtrdesc = :prtrdesc"),
    @NamedQuery(name = "Prtr.findByPrtruing", query = "SELECT p FROM Prtr p WHERE p.prtruing = :prtruing"),
    @NamedQuery(name = "Prtr.findByPrtrumod", query = "SELECT p FROM Prtr p WHERE p.prtrumod = :prtrumod"),
    @NamedQuery(name = "Prtr.findByPrtrfing", query = "SELECT p FROM Prtr p WHERE p.prtrfing = :prtrfing"),
    @NamedQuery(name = "Prtr.findByPrtrfmod", query = "SELECT p FROM Prtr p WHERE p.prtrfmod = :prtrfmod")})
public class Prtr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prtr__id")
    private Integer prtrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "prtrnomb")
    private String prtrnomb;
    @Size(max = 50)
    @Column(name = "prtrsigl")
    private String prtrsigl;
    @Size(max = 1000)
    @Column(name = "prtrdesc")
    private String prtrdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prtruing")
    private String prtruing;
    @Size(max = 20)
    @Column(name = "prtrumod")
    private String prtrumod;
    @Column(name = "prtrfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prtrfing;
    @Column(name = "prtrfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prtrfmod;
    @OneToMany(mappedBy = "prtrId")
    private Collection<Trco> trcoCollection;

    public Prtr() {
    }

    public Prtr(Integer prtrId) {
        this.prtrId = prtrId;
    }

    public Prtr(Integer prtrId, String prtrnomb, String prtruing) {
        this.prtrId = prtrId;
        this.prtrnomb = prtrnomb;
        this.prtruing = prtruing;
    }

    public Integer getPrtrId() {
        return prtrId;
    }

    public void setPrtrId(Integer prtrId) {
        this.prtrId = prtrId;
    }

    public String getPrtrnomb() {
        return prtrnomb;
    }

    public void setPrtrnomb(String prtrnomb) {
        this.prtrnomb = prtrnomb;
    }

    public String getPrtrsigl() {
        return prtrsigl;
    }

    public void setPrtrsigl(String prtrsigl) {
        this.prtrsigl = prtrsigl;
    }

    public String getPrtrdesc() {
        return prtrdesc;
    }

    public void setPrtrdesc(String prtrdesc) {
        this.prtrdesc = prtrdesc;
    }

    public String getPrtruing() {
        return prtruing;
    }

    public void setPrtruing(String prtruing) {
        this.prtruing = prtruing;
    }

    public String getPrtrumod() {
        return prtrumod;
    }

    public void setPrtrumod(String prtrumod) {
        this.prtrumod = prtrumod;
    }

    public Date getPrtrfing() {
        return prtrfing;
    }

    public void setPrtrfing(Date prtrfing) {
        this.prtrfing = prtrfing;
    }

    public Date getPrtrfmod() {
        return prtrfmod;
    }

    public void setPrtrfmod(Date prtrfmod) {
        this.prtrfmod = prtrfmod;
    }

    @XmlTransient
    public Collection<Trco> getTrcoCollection() {
        return trcoCollection;
    }

    public void setTrcoCollection(Collection<Trco> trcoCollection) {
        this.trcoCollection = trcoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prtrId != null ? prtrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prtr)) {
            return false;
        }
        Prtr other = (Prtr) object;
        if ((this.prtrId == null && other.prtrId != null) || (this.prtrId != null && !this.prtrId.equals(other.prtrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prtr[ prtrId=" + prtrId + " ]";
    }
    
}
