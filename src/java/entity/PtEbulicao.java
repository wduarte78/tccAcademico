/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "pt_ebulicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtEbulicao.findAll", query = "SELECT p FROM PtEbulicao p"),
    @NamedQuery(name = "PtEbulicao.findByIdPtEbulicao", query = "SELECT p FROM PtEbulicao p WHERE p.idPtEbulicao = :idPtEbulicao"),
    @NamedQuery(name = "PtEbulicao.findByPtEbuliMin", query = "SELECT p FROM PtEbulicao p WHERE p.ptEbuliMin = :ptEbuliMin"),
    @NamedQuery(name = "PtEbulicao.findByPtEbuliMax", query = "SELECT p FROM PtEbulicao p WHERE p.ptEbuliMax = :ptEbuliMax"),
    @NamedQuery(name = "PtEbulicao.findByDescricao", query = "SELECT p FROM PtEbulicao p WHERE p.descricao = :descricao")})
public class PtEbulicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pt_ebulicao")
    private Integer idPtEbulicao;
    @Column(name = "pt_ebuli_min")
    private Integer ptEbuliMin;
    @Column(name = "pt_ebuli_max")
    private Integer ptEbuliMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "descricao")
    private String descricao;

    public PtEbulicao() {
    }

    public PtEbulicao(Integer idPtEbulicao) {
        this.idPtEbulicao = idPtEbulicao;
    }

    public PtEbulicao(Integer idPtEbulicao, String descricao) {
        this.idPtEbulicao = idPtEbulicao;
        this.descricao = descricao;
    }

    public Integer getIdPtEbulicao() {
        return idPtEbulicao;
    }

    public void setIdPtEbulicao(Integer idPtEbulicao) {
        this.idPtEbulicao = idPtEbulicao;
    }

    public Integer getPtEbuliMin() {
        return ptEbuliMin;
    }

    public void setPtEbuliMin(Integer ptEbuliMin) {
        this.ptEbuliMin = ptEbuliMin;
    }

    public Integer getPtEbuliMax() {
        return ptEbuliMax;
    }

    public void setPtEbuliMax(Integer ptEbuliMax) {
        this.ptEbuliMax = ptEbuliMax;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPtEbulicao != null ? idPtEbulicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtEbulicao)) {
            return false;
        }
        PtEbulicao other = (PtEbulicao) object;
        if ((this.idPtEbulicao == null && other.idPtEbulicao != null) || (this.idPtEbulicao != null && !this.idPtEbulicao.equals(other.idPtEbulicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PtEbulicao[ idPtEbulicao=" + idPtEbulicao + " ]";
    }

}
