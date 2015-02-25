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
@Table(name = "cali1", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cali1.findAll", query = "SELECT c FROM Cali1 c"),
    @NamedQuery(name = "Cali1.findByCali1Id", query = "SELECT c FROM Cali1 c WHERE c.cali1Id = :cali1Id"),
    @NamedQuery(name = "Cali1.findByCali1nomb", query = "SELECT c FROM Cali1 c WHERE c.cali1nomb = :cali1nomb"),
    @NamedQuery(name = "Cali1.findByCali1uing", query = "SELECT c FROM Cali1 c WHERE c.cali1uing = :cali1uing"),
    @NamedQuery(name = "Cali1.findByCali1fing", query = "SELECT c FROM Cali1 c WHERE c.cali1fing = :cali1fing"),
    @NamedQuery(name = "Cali1.findByCali1umod", query = "SELECT c FROM Cali1 c WHERE c.cali1umod = :cali1umod"),
    @NamedQuery(name = "Cali1.findByCali1fmod", query = "SELECT c FROM Cali1 c WHERE c.cali1fmod = :cali1fmod")})
public class Cali1 implements Serializable {
    @OneToMany(mappedBy = "cali1Id")
    private Collection<Hisda> hisdaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cali1__id")
    private Integer cali1Id;
    @Size(max = 20)
    @Column(name = "cali1nomb")
    private String cali1nomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cali1uing")
    private String cali1uing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cali1fing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cali1fing;
    @Size(max = 20)
    @Column(name = "cali1umod")
    private String cali1umod;
    @Column(name = "cali1fmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cali1fmod;

    public Cali1() {
    }

    public Cali1(Integer cali1Id) {
        this.cali1Id = cali1Id;
    }

    public Cali1(Integer cali1Id, String cali1uing, Date cali1fing) {
        this.cali1Id = cali1Id;
        this.cali1uing = cali1uing;
        this.cali1fing = cali1fing;
    }

    public Integer getCali1Id() {
        return cali1Id;
    }

    public void setCali1Id(Integer cali1Id) {
        this.cali1Id = cali1Id;
    }

    public String getCali1nomb() {
        return cali1nomb;
    }

    public void setCali1nomb(String cali1nomb) {
        this.cali1nomb = cali1nomb;
    }

    public String getCali1uing() {
        return cali1uing;
    }

    public void setCali1uing(String cali1uing) {
        this.cali1uing = cali1uing;
    }

    public Date getCali1fing() {
        return cali1fing;
    }

    public void setCali1fing(Date cali1fing) {
        this.cali1fing = cali1fing;
    }

    public String getCali1umod() {
        return cali1umod;
    }

    public void setCali1umod(String cali1umod) {
        this.cali1umod = cali1umod;
    }

    public Date getCali1fmod() {
        return cali1fmod;
    }

    public void setCali1fmod(Date cali1fmod) {
        this.cali1fmod = cali1fmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cali1Id != null ? cali1Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cali1)) {
            return false;
        }
        Cali1 other = (Cali1) object;
        if ((this.cali1Id == null && other.cali1Id != null) || (this.cali1Id != null && !this.cali1Id.equals(other.cali1Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cali1[ cali1Id=" + cali1Id + " ]";
    }

    @XmlTransient
    public Collection<Hisda> getHisdaCollection() {
        return hisdaCollection;
    }

    public void setHisdaCollection(Collection<Hisda> hisdaCollection) {
        this.hisdaCollection = hisdaCollection;
    }
    
}
