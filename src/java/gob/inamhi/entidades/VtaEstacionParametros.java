/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "vta__estacion_parametros", schema = "processed_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaEstacionParametros.findAll", query = "SELECT v FROM VtaEstacionParametros v"),
    @NamedQuery(name = "VtaEstacionParametros.findByEstaId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.estaId = :estaId"),
    @NamedQuery(name = "VtaEstacionParametros.findByParmId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.parmId = :parmId"),
    @NamedQuery(name = "VtaEstacionParametros.findByCopaId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.copaId = :copaId"),
    @NamedQuery(name = "VtaEstacionParametros.findByEstdId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.estdId = :estdId"),
    @NamedQuery(name = "VtaEstacionParametros.findByIntetiemp", query = "SELECT v FROM VtaEstacionParametros v WHERE v.intetiemp = :intetiemp"),
    @NamedQuery(name = "VtaEstacionParametros.findByUmetId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.umetId = :umetId"),
    @NamedQuery(name = "VtaEstacionParametros.findByUmetnomb", query = "SELECT v FROM VtaEstacionParametros v WHERE v.umetnomb = :umetnomb"),
    @NamedQuery(name = "VtaEstacionParametros.findByInteId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.inteId = :inteId"),
    @NamedQuery(name = "VtaEstacionParametros.findByCpsenId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.cpsenId = :cpsenId"),
    @NamedQuery(name = "VtaEstacionParametros.findByInutId", query = "SELECT v FROM VtaEstacionParametros v WHERE v.inutId = :inutId"),
    @NamedQuery(name = "VtaEstacionParametros.findByParmdesc", query = "SELECT v FROM VtaEstacionParametros v WHERE v.parmdesc = :parmdesc"),
    @NamedQuery(name = "VtaEstacionParametros.findByUmepnomb", query = "SELECT v FROM VtaEstacionParametros v WHERE v.umepnomb = :umepnomb"),
    @NamedQuery(name = "VtaEstacionParametros.findByUmepsimb", query = "SELECT v FROM VtaEstacionParametros v WHERE v.umepsimb = :umepsimb"),
    @NamedQuery(name = "VtaEstacionParametros.findByEstddesc", query = "SELECT v FROM VtaEstacionParametros v WHERE v.estddesc = :estddesc"),
    @NamedQuery(name = "VtaEstacionParametros.findByEstacodi", query = "SELECT v FROM VtaEstacionParametros v WHERE v.estacodi = :estacodi"),
    @NamedQuery(name = "VtaEstacionParametros.findByEstanomb", query = "SELECT v FROM VtaEstacionParametros v WHERE v.estanomb = :estanomb")})
public class VtaEstacionParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "esta__id")
    private Integer estaId;
    @Column(name = "parm__id")
    private Integer parmId;
    @Id
    @Column(name = "copa__id")
    private Integer copaId;
    @Column(name = "estd__id")
    private Integer estdId;
    @Column(name = "intetiemp")
    private BigInteger intetiemp;
    @Size(max = 5)
    @Column(name = "umet__id")
    private String umetId;
    @Size(max = 50)
    @Column(name = "umetnomb")
    private String umetnomb;
    @Column(name = "inte__id")
    private Integer inteId;
    @Column(name = "cpsen__id")
    private Integer cpsenId;
    @Column(name = "inut__id")
    private Integer inutId;
    @Size(max = 1000)
    @Column(name = "parmdesc")
    private String parmdesc;
    @Size(max = 100)
    @Column(name = "umepnomb")
    private String umepnomb;
    @Size(max = 20)
    @Column(name = "umepsimb")
    private String umepsimb;
    @Size(max = 1000)
    @Column(name = "estddesc")
    private String estddesc;
    @Size(max = 8)
    @Column(name = "estacodi")
    private String estacodi;
    @Size(max = 100)
    @Column(name = "estanomb")
    private String estanomb;
    @Column(name = "cpestaesta")
    private boolean cpestaesta;

    public VtaEstacionParametros() {
    }

    public Integer getEstaId() {
        return estaId;
    }

    public void setEstaId(Integer estaId) {
        this.estaId = estaId;
    }

    public Integer getParmId() {
        return parmId;
    }

    public void setParmId(Integer parmId) {
        this.parmId = parmId;
    }

    public Integer getCopaId() {
        return copaId;
    }

    public void setCopaId(Integer copaId) {
        this.copaId = copaId;
    }

    public Integer getEstdId() {
        return estdId;
    }

    public void setEstdId(Integer estdId) {
        this.estdId = estdId;
    }

    public BigInteger getIntetiemp() {
        return intetiemp;
    }

    public void setIntetiemp(BigInteger intetiemp) {
        this.intetiemp = intetiemp;
    }

    public String getUmetId() {
        return umetId;
    }

    public void setUmetId(String umetId) {
        this.umetId = umetId;
    }

    public String getUmetnomb() {
        return umetnomb;
    }

    public void setUmetnomb(String umetnomb) {
        this.umetnomb = umetnomb;
    }

    public Integer getInteId() {
        return inteId;
    }

    public void setInteId(Integer inteId) {
        this.inteId = inteId;
    }

    public Integer getCpsenId() {
        return cpsenId;
    }

    public void setCpsenId(Integer cpsenId) {
        this.cpsenId = cpsenId;
    }

    public Integer getInutId() {
        return inutId;
    }

    public void setInutId(Integer inutId) {
        this.inutId = inutId;
    }

    public String getParmdesc() {
        return parmdesc;
    }

    public void setParmdesc(String parmdesc) {
        this.parmdesc = parmdesc;
    }

    public String getUmepnomb() {
        return umepnomb;
    }

    public void setUmepnomb(String umepnomb) {
        this.umepnomb = umepnomb;
    }

    public String getUmepsimb() {
        return umepsimb;
    }

    public void setUmepsimb(String umepsimb) {
        this.umepsimb = umepsimb;
    }

    public String getEstddesc() {
        return estddesc;
    }

    public void setEstddesc(String estddesc) {
        this.estddesc = estddesc;
    }

    public String getEstacodi() {
        return estacodi;
    }

    public void setEstacodi(String estacodi) {
        this.estacodi = estacodi;
    }

    public String getEstanomb() {
        return estanomb;
    }

    public void setEstanomb(String estanomb) {
        this.estanomb = estanomb;
    }

    public void setCpestaesta(boolean cpestaesta) {
        this.cpestaesta = cpestaesta;
    }

    public boolean getCpestaesta() {
        return cpestaesta;
    }
}
