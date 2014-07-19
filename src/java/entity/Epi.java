/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "epi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epi.findAll", query = "SELECT e FROM Epi e"),
    @NamedQuery(name = "Epi.findByIdEpi", query = "SELECT e FROM Epi e WHERE e.idEpi = :idEpi"),
    @NamedQuery(name = "Epi.findByEspecificacao", query = "SELECT e FROM Epi e WHERE e.especificacao = :especificacao"),
    @NamedQuery(name = "Epi.findByGrupoEpi", query = "SELECT e FROM Epi e WHERE e.grupoEpi = :grupoEpi")})
public class Epi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_epi")
    private Integer idEpi;
    @Size(max = 250)
    @Column(name = "especificacao")
    private String especificacao;
    @Size(max = 250)
    @Column(name = "grupo_epi")
    private String grupoEpi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epiidEpi")
    private Collection<TipoEquipamento> tipoEquipamentoCollection;

    public Epi() {
    }

    public Epi(Integer idEpi) {
        this.idEpi = idEpi;
    }

    public Integer getIdEpi() {
        return idEpi;
    }

    public void setIdEpi(Integer idEpi) {
        this.idEpi = idEpi;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getGrupoEpi() {
        return grupoEpi;
    }

    public void setGrupoEpi(String grupoEpi) {
        this.grupoEpi = grupoEpi;
    }

    @XmlTransient
    public Collection<TipoEquipamento> getTipoEquipamentoCollection() {
        return tipoEquipamentoCollection;
    }

    public void setTipoEquipamentoCollection(Collection<TipoEquipamento> tipoEquipamentoCollection) {
        this.tipoEquipamentoCollection = tipoEquipamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEpi != null ? idEpi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epi)) {
            return false;
        }
        Epi other = (Epi) object;
        if ((this.idEpi == null && other.idEpi != null) || (this.idEpi != null && !this.idEpi.equals(other.idEpi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Epi[ idEpi=" + idEpi + " ]";
    }

}
