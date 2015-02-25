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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cpresta", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cpresta.findAll", query = "SELECT c FROM Cpresta c"),
    @NamedQuery(name = "Cpresta.findByCprestaId", query = "SELECT c FROM Cpresta c WHERE c.cprestaId = :cprestaId"),
    @NamedQuery(name = "Cpresta.findByCprestadesc", query = "SELECT c FROM Cpresta c WHERE c.cprestadesc = :cprestadesc"),
    @NamedQuery(name = "Cpresta.findByCprestauing", query = "SELECT c FROM Cpresta c WHERE c.cprestauing = :cprestauing"),
    @NamedQuery(name = "Cpresta.findByCprestafing", query = "SELECT c FROM Cpresta c WHERE c.cprestafing = :cprestafing"),
    @NamedQuery(name = "Cpresta.findByCprestaumod", query = "SELECT c FROM Cpresta c WHERE c.cprestaumod = :cprestaumod"),
    @NamedQuery(name = "Cpresta.findByCprestafmod", query = "SELECT c FROM Cpresta c WHERE c.cprestafmod = :cprestafmod")})
public class Cpresta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cpresta__id")
    private Integer cprestaId;
    @Size(max = 1000)
    @Column(name = "cprestadesc")
    private String cprestadesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cprestauing")
    private String cprestauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cprestafing", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cprestafing;
    @Size(max = 20)
    @Column(name = "cprestaumod")
    private String cprestaumod;
    @Column(name = "cprestafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cprestafmod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cprestaesta")
    private boolean cprestaesta;
    @JoinColumn(name = "esta__id", referencedColumnName = "esta__id")
    @ManyToOne
    private Esta estaId;
    @JoinColumn(name = "copa__id", referencedColumnName = "copa__id")
    @ManyToOne(optional = false)
    private Copa copaId;

    public Cpresta() {
    }

    public Cpresta(Integer cprestaId) {
        this.cprestaId = cprestaId;
    }

    public Cpresta(Integer cprestaId, String cprestauing, Date cprestafing) {
        this.cprestaId = cprestaId;
        this.cprestauing = cprestauing;
        this.cprestafing = cprestafing;
    }

    public Integer getCprestaId() {
        return cprestaId;
    }

    public void setCprestaId(Integer cprestaId) {
        this.cprestaId = cprestaId;
    }

    public String getCprestadesc() {
        return cprestadesc;
    }

    public void setCprestadesc(String cprestadesc) {
        this.cprestadesc = cprestadesc;
    }

    public String getCprestauing() {
        return cprestauing;
    }

    public void setCprestauing(String cprestauing) {
        this.cprestauing = cprestauing;
    }

    public Date getCprestafing() {
        return cprestafing;
    }

    public void setCprestafing(Date cprestafing) {
        this.cprestafing = cprestafing;
    }

    public String getCprestaumod() {
        return cprestaumod;
    }

    public void setCprestaumod(String cprestaumod) {
        this.cprestaumod = cprestaumod;
    }

    public Date getCprestafmod() {
        return cprestafmod;
    }

    public void setCprestafmod(Date cprestafmod) {
        this.cprestafmod = cprestafmod;
    }

    public boolean isCprestaesta() {
        return cprestaesta;
    }

    public void setCprestaesta(boolean cprestaesta) {
        this.cprestaesta = cprestaesta;
    }

   
    public Esta getEstaId() {
        return estaId;
    }

    public void setEstaId(Esta estaId) {
        this.estaId = estaId;
    }

    public Copa getCopaId() {
        return copaId;
    }

    public void setCopaId(Copa copaId) {
        this.copaId = copaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprestaId != null ? cprestaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpresta)) {
            return false;
        }
        Cpresta other = (Cpresta) object;
        if ((this.cprestaId == null && other.cprestaId != null) || (this.cprestaId != null && !this.cprestaId.equals(other.cprestaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.entidades.Cpresta[ cprestaId=" + cprestaId + " ]";
    }
}
