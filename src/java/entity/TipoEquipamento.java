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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "tipo_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipamento.findAll", query = "SELECT t FROM TipoEquipamento t"),
    @NamedQuery(name = "TipoEquipamento.findByIdTipoEquipamento", query = "SELECT t FROM TipoEquipamento t WHERE t.idTipoEquipamento = :idTipoEquipamento")})
public class TipoEquipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_equipamento")
    private Integer idTipoEquipamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipamentoidTipoEquipamento")
    private Collection<DetalheNota> detalheNotaCollection;
    @JoinColumn(name = "veiculoid_veiculo", referencedColumnName = "id_veiculo")
    @ManyToOne(optional = false)
    private Veiculo veiculoidVeiculo;
    @JoinColumn(name = "epiid_epi", referencedColumnName = "id_epi")
    @ManyToOne(optional = false)
    private Epi epiidEpi;
    @JoinColumn(name = "epeid_epe", referencedColumnName = "id_epe")
    @ManyToOne(optional = false)
    private Epe epeidEpe;

    public TipoEquipamento() {
    }

    public TipoEquipamento(Integer idTipoEquipamento) {
        this.idTipoEquipamento = idTipoEquipamento;
    }

    public Integer getIdTipoEquipamento() {
        return idTipoEquipamento;
    }

    public void setIdTipoEquipamento(Integer idTipoEquipamento) {
        this.idTipoEquipamento = idTipoEquipamento;
    }

    @XmlTransient
    public Collection<DetalheNota> getDetalheNotaCollection() {
        return detalheNotaCollection;
    }

    public void setDetalheNotaCollection(Collection<DetalheNota> detalheNotaCollection) {
        this.detalheNotaCollection = detalheNotaCollection;
    }

    public Veiculo getVeiculoidVeiculo() {
        return veiculoidVeiculo;
    }

    public void setVeiculoidVeiculo(Veiculo veiculoidVeiculo) {
        this.veiculoidVeiculo = veiculoidVeiculo;
    }

    public Epi getEpiidEpi() {
        return epiidEpi;
    }

    public void setEpiidEpi(Epi epiidEpi) {
        this.epiidEpi = epiidEpi;
    }

    public Epe getEpeidEpe() {
        return epeidEpe;
    }

    public void setEpeidEpe(Epe epeidEpe) {
        this.epeidEpe = epeidEpe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEquipamento != null ? idTipoEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipamento)) {
            return false;
        }
        TipoEquipamento other = (TipoEquipamento) object;
        if ((this.idTipoEquipamento == null && other.idTipoEquipamento != null) || (this.idTipoEquipamento != null && !this.idTipoEquipamento.equals(other.idTipoEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoEquipamento[ idTipoEquipamento=" + idTipoEquipamento + " ]";
    }

}
