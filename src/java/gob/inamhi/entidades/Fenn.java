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
import javax.persistence.Lob;
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
@Table(name = "fenn", schema = "raw_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fenn.findAll", query = "SELECT f FROM Fenn f"),
    @NamedQuery(name = "Fenn.findByFennId", query = "SELECT f FROM Fenn f WHERE f.fennId = :fennId"),
    @NamedQuery(name = "Fenn.findByFenncodi", query = "SELECT f FROM Fenn f WHERE f.fenncodi = :fenncodi"),
    @NamedQuery(name = "Fenn.findByFennnomb", query = "SELECT f FROM Fenn f WHERE f.fennnomb = :fennnomb"),
    @NamedQuery(name = "Fenn.findByFenndesc", query = "SELECT f FROM Fenn f WHERE f.fenndesc = :fenndesc"),
    @NamedQuery(name = "Fenn.findByFennuing", query = "SELECT f FROM Fenn f WHERE f.fennuing = :fennuing"),
    @NamedQuery(name = "Fenn.findByFennfing", query = "SELECT f FROM Fenn f WHERE f.fennfing = :fennfing"),
    @NamedQuery(name = "Fenn.findByFennumod", query = "SELECT f FROM Fenn f WHERE f.fennumod = :fennumod"),
    @NamedQuery(name = "Fenn.findByFennfmod", query = "SELECT f FROM Fenn f WHERE f.fennfmod = :fennfmod")})
public class Fenn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fenn__id")
    private Integer fennId;
    @Size(max = 20)
    @Column(name = "fenncodi")
    private String fenncodi;
    @Size(max = 110)
    @Column(name = "fennnomb")
    private String fennnomb;
    @Lob
    @Column(name = "fennimg")
    private byte[] fennimg;
    @Size(max = 2147483647)
    @Column(name = "fenndesc")
    private String fenndesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fennuing")
    private String fennuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fennfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fennfing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fennumod")
    private String fennumod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fennfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fennfmod;

    public Fenn() {
    }

    public Fenn(Integer fennId) {
        this.fennId = fennId;
    }

    public Fenn(Integer fennId, String fennuing, Date fennfing, String fennumod, Date fennfmod) {
        this.fennId = fennId;
        this.fennuing = fennuing;
        this.fennfing = fennfing;
        this.fennumod = fennumod;
        this.fennfmod = fennfmod;
    }

    public Integer getFennId() {
        return fennId;
    }

    public void setFennId(Integer fennId) {
        this.fennId = fennId;
    }

    public String getFenncodi() {
        return fenncodi;
    }

    public void setFenncodi(String fenncodi) {
        this.fenncodi = fenncodi;
    }

    public String getFennnomb() {
        return fennnomb;
    }

    public void setFennnomb(String fennnomb) {
        this.fennnomb = fennnomb;
    }

    public byte[] getFennimg() {
        return fennimg;
    }

    public void setFennimg(byte[] fennimg) {
        this.fennimg = fennimg;
    }

    public String getFenndesc() {
        return fenndesc;
    }

    public void setFenndesc(String fenndesc) {
        this.fenndesc = fenndesc;
    }

    public String getFennuing() {
        return fennuing;
    }

    public void setFennuing(String fennuing) {
        this.fennuing = fennuing;
    }

    public Date getFennfing() {
        return fennfing;
    }

    public void setFennfing(Date fennfing) {
        this.fennfing = fennfing;
    }

    public String getFennumod() {
        return fennumod;
    }

    public void setFennumod(String fennumod) {
        this.fennumod = fennumod;
    }

    public Date getFennfmod() {
        return fennfmod;
    }

    public void setFennfmod(Date fennfmod) {
        this.fennfmod = fennfmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fennId != null ? fennId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fenn)) {
            return false;
        }
        Fenn other = (Fenn) object;
        if ((this.fennId == null && other.fennId != null) || (this.fennId != null && !this.fennId.equals(other.fennId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Fenn[ fennId=" + fennId + " ]";
    }
    
}
