/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "hisda", schema = "storage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hisda.findAll", query = "SELECT h FROM Hisda h"),
    @NamedQuery(name = "Hisda.findByHisdaId", query = "SELECT h FROM Hisda h WHERE h.hisdaId = :hisdaId"),
    @NamedQuery(name = "Hisda.findByDataId", query = "SELECT h FROM Hisda h WHERE h.dataId = :dataId"),
    @NamedQuery(name = "Hisda.findByHisdaval", query = "SELECT h FROM Hisda h WHERE h.hisdaval = :hisdaval"),
    @NamedQuery(name = "Hisda.findByHisdaobs", query = "SELECT h FROM Hisda h WHERE h.hisdaobs = :hisdaobs"),
    @NamedQuery(name = "Hisda.findByHisdaorig", query = "SELECT h FROM Hisda h WHERE h.hisdaorig = :hisdaorig"),
    @NamedQuery(name = "Hisda.findByHisdaidor", query = "SELECT h FROM Hisda h WHERE h.hisdaidor = :hisdaidor"),
    @NamedQuery(name = "Hisda.findByHisdadesc", query = "SELECT h FROM Hisda h WHERE h.hisdadesc = :hisdadesc"),
    @NamedQuery(name = "Hisda.findByHisdauing", query = "SELECT h FROM Hisda h WHERE h.hisdauing = :hisdauing"),
    @NamedQuery(name = "Hisda.findByHisdafing", query = "SELECT h FROM Hisda h WHERE h.hisdafing = :hisdafing"),
    @NamedQuery(name = "Hisda.findByHisdaumod", query = "SELECT h FROM Hisda h WHERE h.hisdaumod = :hisdaumod"),
    @NamedQuery(name = "Hisda.findByHisdafmod", query = "SELECT h FROM Hisda h WHERE h.hisdafmod = :hisdafmod")})
public class Hisda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hisda__id")
    private Integer hisdaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data__id")
    private int dataId;
    @Column(name = "hisdaval")
    private BigInteger hisdaval;
    @Size(max = 50)
    @Column(name = "hisdaobs")
    private String hisdaobs;
    @Size(max = 50)
    @Column(name = "hisdaorig")
    private String hisdaorig;
    @Column(name = "hisdaidor")
    private Integer hisdaidor;
    @Size(max = 20)
    @Column(name = "hisdadesc")
    private String hisdadesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "hisdauing")
    private String hisdauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hisdafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hisdafing;
    @Size(max = 20)
    @Column(name = "hisdaumod")
    private String hisdaumod;
    @Column(name = "hisdafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hisdafmod;
    @JoinColumn(name = "meto__id", referencedColumnName = "meto__id")
    @ManyToOne(optional = false)
    private Meto metoId;
    @JoinColumn(name = "cali1__id", referencedColumnName = "cali1__id")
    @ManyToOne
    private Cali1 cali1Id;

    public Hisda() {
    }

    public Hisda(Integer hisdaId) {
        this.hisdaId = hisdaId;
    }

    public Hisda(Integer hisdaId, int dataId, String hisdauing, Date hisdafing) {
        this.hisdaId = hisdaId;
        this.dataId = dataId;
        this.hisdauing = hisdauing;
        this.hisdafing = hisdafing;
    }

    public Integer getHisdaId() {
        return hisdaId;
    }

    public void setHisdaId(Integer hisdaId) {
        this.hisdaId = hisdaId;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public BigInteger getHisdaval() {
        return hisdaval;
    }

    public void setHisdaval(BigInteger hisdaval) {
        this.hisdaval = hisdaval;
    }

    public String getHisdaobs() {
        return hisdaobs;
    }

    public void setHisdaobs(String hisdaobs) {
        this.hisdaobs = hisdaobs;
    }

    public String getHisdaorig() {
        return hisdaorig;
    }

    public void setHisdaorig(String hisdaorig) {
        this.hisdaorig = hisdaorig;
    }

    public Integer getHisdaidor() {
        return hisdaidor;
    }

    public void setHisdaidor(Integer hisdaidor) {
        this.hisdaidor = hisdaidor;
    }

    public String getHisdadesc() {
        return hisdadesc;
    }

    public void setHisdadesc(String hisdadesc) {
        this.hisdadesc = hisdadesc;
    }

    public String getHisdauing() {
        return hisdauing;
    }

    public void setHisdauing(String hisdauing) {
        this.hisdauing = hisdauing;
    }

    public Date getHisdafing() {
        return hisdafing;
    }

    public void setHisdafing(Date hisdafing) {
        this.hisdafing = hisdafing;
    }

    public String getHisdaumod() {
        return hisdaumod;
    }

    public void setHisdaumod(String hisdaumod) {
        this.hisdaumod = hisdaumod;
    }

    public Date getHisdafmod() {
        return hisdafmod;
    }

    public void setHisdafmod(Date hisdafmod) {
        this.hisdafmod = hisdafmod;
    }

    public Meto getMetoId() {
        return metoId;
    }

    public void setMetoId(Meto metoId) {
        this.metoId = metoId;
    }

    public Cali1 getCali1Id() {
        return cali1Id;
    }

    public void setCali1Id(Cali1 cali1Id) {
        this.cali1Id = cali1Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisdaId != null ? hisdaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hisda)) {
            return false;
        }
        Hisda other = (Hisda) object;
        if ((this.hisdaId == null && other.hisdaId != null) || (this.hisdaId != null && !this.hisdaId.equals(other.hisdaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Hisda[ hisdaId=" + hisdaId + " ]";
    }
    
}
