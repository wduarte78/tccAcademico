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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "tipo_embalagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmbalagem.findAll", query = "SELECT t FROM TipoEmbalagem t"),
    @NamedQuery(name = "TipoEmbalagem.findByIdTipoEmbalagem", query = "SELECT t FROM TipoEmbalagem t WHERE t.idTipoEmbalagem = :idTipoEmbalagem"),
    @NamedQuery(name = "TipoEmbalagem.findByNometipo", query = "SELECT t FROM TipoEmbalagem t WHERE t.nometipo = :nometipo")})
public class TipoEmbalagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_embalagem")
    private Integer idTipoEmbalagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nometipo")
    private String nometipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEmbalagemidTipoEmbalagem")
    private Collection<Embalagem> embalagemCollection;

    public TipoEmbalagem() {
    }

    public TipoEmbalagem(Integer idTipoEmbalagem) {
        this.idTipoEmbalagem = idTipoEmbalagem;
    }

    public TipoEmbalagem(Integer idTipoEmbalagem, String nometipo) {
        this.idTipoEmbalagem = idTipoEmbalagem;
        this.nometipo = nometipo;
    }

    public Integer getIdTipoEmbalagem() {
        return idTipoEmbalagem;
    }

    public void setIdTipoEmbalagem(Integer idTipoEmbalagem) {
        this.idTipoEmbalagem = idTipoEmbalagem;
    }

    public String getNometipo() {
        return nometipo;
    }

    public void setNometipo(String nometipo) {
        this.nometipo = nometipo;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEmbalagem != null ? idTipoEmbalagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmbalagem)) {
            return false;
        }
        TipoEmbalagem other = (TipoEmbalagem) object;
        if ((this.idTipoEmbalagem == null && other.idTipoEmbalagem != null) || (this.idTipoEmbalagem != null && !this.idTipoEmbalagem.equals(other.idTipoEmbalagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoEmbalagem[ idTipoEmbalagem=" + idTipoEmbalagem + " ]";
    }

}
