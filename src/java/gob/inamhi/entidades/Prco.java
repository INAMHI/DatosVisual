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
@Table(name = "prco", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prco.findAll", query = "SELECT p FROM Prco p"),
    @NamedQuery(name = "Prco.findByPrcoId", query = "SELECT p FROM Prco p WHERE p.prcoId = :prcoId"),
    @NamedQuery(name = "Prco.findByPrconomb", query = "SELECT p FROM Prco p WHERE p.prconomb = :prconomb"),
    @NamedQuery(name = "Prco.findByPrcosigl", query = "SELECT p FROM Prco p WHERE p.prcosigl = :prcosigl"),
    @NamedQuery(name = "Prco.findByPrcodesc", query = "SELECT p FROM Prco p WHERE p.prcodesc = :prcodesc"),
    @NamedQuery(name = "Prco.findByPrcouing", query = "SELECT p FROM Prco p WHERE p.prcouing = :prcouing"),
    @NamedQuery(name = "Prco.findByPrcoumod", query = "SELECT p FROM Prco p WHERE p.prcoumod = :prcoumod"),
    @NamedQuery(name = "Prco.findByPrcofing", query = "SELECT p FROM Prco p WHERE p.prcofing = :prcofing"),
    @NamedQuery(name = "Prco.findByPrcofmod", query = "SELECT p FROM Prco p WHERE p.prcofmod = :prcofmod")})
public class Prco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prco__id")
    private Integer prcoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "prconomb")
    private String prconomb;
    @Size(max = 50)
    @Column(name = "prcosigl")
    private String prcosigl;
    @Size(max = 1000)
    @Column(name = "prcodesc")
    private String prcodesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prcouing")
    private String prcouing;
    @Size(max = 20)
    @Column(name = "prcoumod")
    private String prcoumod;
    @Column(name = "prcofing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prcofing;
    @Column(name = "prcofmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prcofmod;
    @OneToMany(mappedBy = "prcoId")
    private Collection<Trco> trcoCollection;

    public Prco() {
    }

    public Prco(Integer prcoId) {
        this.prcoId = prcoId;
    }

    public Prco(Integer prcoId, String prconomb, String prcouing) {
        this.prcoId = prcoId;
        this.prconomb = prconomb;
        this.prcouing = prcouing;
    }

    public Integer getPrcoId() {
        return prcoId;
    }

    public void setPrcoId(Integer prcoId) {
        this.prcoId = prcoId;
    }

    public String getPrconomb() {
        return prconomb;
    }

    public void setPrconomb(String prconomb) {
        this.prconomb = prconomb;
    }

    public String getPrcosigl() {
        return prcosigl;
    }

    public void setPrcosigl(String prcosigl) {
        this.prcosigl = prcosigl;
    }

    public String getPrcodesc() {
        return prcodesc;
    }

    public void setPrcodesc(String prcodesc) {
        this.prcodesc = prcodesc;
    }

    public String getPrcouing() {
        return prcouing;
    }

    public void setPrcouing(String prcouing) {
        this.prcouing = prcouing;
    }

    public String getPrcoumod() {
        return prcoumod;
    }

    public void setPrcoumod(String prcoumod) {
        this.prcoumod = prcoumod;
    }

    public Date getPrcofing() {
        return prcofing;
    }

    public void setPrcofing(Date prcofing) {
        this.prcofing = prcofing;
    }

    public Date getPrcofmod() {
        return prcofmod;
    }

    public void setPrcofmod(Date prcofmod) {
        this.prcofmod = prcofmod;
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
        hash += (prcoId != null ? prcoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prco)) {
            return false;
        }
        Prco other = (Prco) object;
        if ((this.prcoId == null && other.prcoId != null) || (this.prcoId != null && !this.prcoId.equals(other.prcoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prco[ prcoId=" + prcoId + " ]";
    }
    
}
