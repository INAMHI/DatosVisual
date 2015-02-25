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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "data1h", schema = "processed_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data1h.findAll", query = "SELECT d FROM Data1h d"),
    @NamedQuery(name = "Data1h.findByData1hId", query = "SELECT d FROM Data1h d WHERE d.data1hId = :data1hId"),
    @NamedQuery(name = "Data1h.findByData1hfetd", query = "SELECT d FROM Data1h d WHERE d.data1hfetd = :data1hfetd"),
    @NamedQuery(name = "Data1h.findByData1hvalo", query = "SELECT d FROM Data1h d WHERE d.data1hvalo = :data1hvalo"),
    @NamedQuery(name = "Data1h.findByData1hince", query = "SELECT d FROM Data1h d WHERE d.data1hince = :data1hince"),
    @NamedQuery(name = "Data1h.findByData1hnval", query = "SELECT d FROM Data1h d WHERE d.data1hnval = :data1hnval"),
    @NamedQuery(name = "Data1h.findByData1hobse", query = "SELECT d FROM Data1h d WHERE d.data1hobse = :data1hobse"),
    @NamedQuery(name = "Data1h.findByData1hctrl", query = "SELECT d FROM Data1h d WHERE d.data1hctrl = :data1hctrl"),
    @NamedQuery(name = "Data1h.findByData1hvers", query = "SELECT d FROM Data1h d WHERE d.data1hvers = :data1hvers"),
    @NamedQuery(name = "Data1h.findByData1hesta", query = "SELECT d FROM Data1h d WHERE d.data1hesta = :data1hesta"),
    @NamedQuery(name = "Data1h.findByData1huing", query = "SELECT d FROM Data1h d WHERE d.data1huing = :data1huing"),
    @NamedQuery(name = "Data1h.findByData1hfing", query = "SELECT d FROM Data1h d WHERE d.data1hfing = :data1hfing"),
    @NamedQuery(name = "Data1h.findByData1humod", query = "SELECT d FROM Data1h d WHERE d.data1humod = :data1humod"),
    @NamedQuery(name = "Data1h.findByData1hfmod", query = "SELECT d FROM Data1h d WHERE d.data1hfmod = :data1hfmod")})
public class Data1h implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "data1h__id")
    private String data1hId;
    @JoinColumn(name = "cfges__id", referencedColumnName = "cfges__id")
    @ManyToOne
    private Cfges cfgesId;
    @JoinColumn(name = "trco__id", referencedColumnName = "trco__id")
    @ManyToOne
    private Trco trcoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data1hfetd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data1hfetd;
    @Column(name = "data1hvalo", precision = 5, scale = 2)
    private Double data1hvalo;
    @Column(name = "data1hince")
    private BigInteger data1hince;
    @Column(name = "data1hnval")
    private Integer data1hnval;
    @Size(max = 2147483647)
    @Column(name = "data1hobse")
    private String data1hobse;
    @Column(name = "data1hctrl")
    private Boolean data1hctrl;
    @Column(name = "data1hvers")
    private Integer data1hvers;
    @Column(name = "data1hesta")
    private Boolean data1hesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "data1huing")
    private String data1huing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data1hfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data1hfing;
    @Size(max = 20)
    @Column(name = "data1humod")
    private String data1humod;
    @Column(name = "data1hfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data1hfmod;
    @JoinColumn(name = "esta__id", referencedColumnName = "esta__id")
    @ManyToOne
    private Esta estaId;
    @JoinColumn(name = "copa__id", referencedColumnName = "copa__id")
    @ManyToOne
    private Copa copaId;
    @JoinColumn(name = "cali__id", referencedColumnName = "cali__id")
    @ManyToOne
    private Cali caliId;
    @Transient
    @Column(name = "hora")
    private String hora;

    public Data1h() {
    }

    public Data1h(String data1hId) {
        this.data1hId = data1hId;
    }

    public Data1h(String data1hId, Date data1hfetd, String data1huing, Date data1hfing) {
        this.data1hId = data1hId;
        this.data1hfetd = data1hfetd;
        this.data1huing = data1huing;
        this.data1hfing = data1hfing;
    }

    public String getData1hId() {
        return data1hId;
    }

    public void setData1hId(String data1hId) {
        this.data1hId = data1hId;
    }

    public Cfges getCfgesId() {
        return cfgesId;
    }

    public void setCfgesId(Cfges cfgesId) {
        this.cfgesId = cfgesId;
    }

    public Trco getTrcoId() {
        return trcoId;
    }

    public void setCaptoId(Trco trcoId) {
        this.trcoId = trcoId;
    }

    public Date getData1hfetd() {
        return data1hfetd;
    }

    public void setData1hfetd(Date data1hfetd) {
        this.data1hfetd = data1hfetd;
    }

    public Double getData1hvalo() {
        return data1hvalo;
    }

    public void setData1hvalo(Double data1hvalo) {
        this.data1hvalo = data1hvalo;
    }

    public BigInteger getData1hince() {
        return data1hince;
    }

    public void setData1hince(BigInteger data1hince) {
        this.data1hince = data1hince;
    }

    public Integer getData1hnval() {
        return data1hnval;
    }

    public void setData1hnval(Integer data1hnval) {
        this.data1hnval = data1hnval;
    }

    public String getData1hobse() {
        return data1hobse;
    }

    public void setData1hobse(String data1hobse) {
        this.data1hobse = data1hobse;
    }

    public Boolean getData1hctrl() {
        return data1hctrl;
    }

    public void setData1hctrl(Boolean data1hctrl) {
        this.data1hctrl = data1hctrl;
    }

    public Integer getData1hvers() {
        return data1hvers;
    }

    public void setData1hvers(Integer data1hvers) {
        this.data1hvers = data1hvers;
    }

    public Boolean getData1hesta() {
        return data1hesta;
    }

    public void setData1hesta(Boolean data1hesta) {
        this.data1hesta = data1hesta;
    }

    public String getData1huing() {
        return data1huing;
    }

    public void setData1huing(String data1huing) {
        this.data1huing = data1huing;
    }

    public Date getData1hfing() {
        return data1hfing;
    }

    public void setData1hfing(Date data1hfing) {
        this.data1hfing = data1hfing;
    }

    public String getData1humod() {
        return data1humod;
    }

    public void setData1humod(String data1humod) {
        this.data1humod = data1humod;
    }

    public Date getData1hfmod() {
        return data1hfmod;
    }

    public void setData1hfmod(Date data1hfmod) {
        this.data1hfmod = data1hfmod;
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

    public Cali getCaliId() {
        return caliId;
    }

    public void setCaliId(Cali caliId) {
        this.caliId = caliId;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHora() {
        String aux = data1hfetd.toString().split(" ")[1];
        hora = aux.substring(0, 8);
        return hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (data1hId != null ? data1hId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data1h)) {
            return false;
        }
        Data1h other = (Data1h) object;
        if ((this.data1hId == null && other.data1hId != null) || (this.data1hId != null && !this.data1hId.equals(other.data1hId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Data1h[ data1hId=" + data1hId + " ]";
    }
}
