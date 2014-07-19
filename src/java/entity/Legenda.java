/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "legenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Legenda.findAll", query = "SELECT l FROM Legenda l"),
    @NamedQuery(name = "Legenda.findByIdLegenda", query = "SELECT l FROM Legenda l WHERE l.idLegenda = :idLegenda"),
    @NamedQuery(name = "Legenda.findByLegDescricao", query = "SELECT l FROM Legenda l WHERE l.legDescricao = :legDescricao"),
    @NamedQuery(name = "Legenda.findByLegenda", query = "SELECT l FROM Legenda l WHERE l.legenda = :legenda")})
public class Legenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_legenda")
    private Integer idLegenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "leg_descricao")
    private String legDescricao;
    @Size(max = 1)
    @Column(name = "legenda")
    private String legenda;
    @OneToMany(mappedBy = "idLegenda")
    private Collection<Classe> classeCollection;

    public Legenda() {
    }

    public Legenda(Integer idLegenda) {
        this.idLegenda = idLegenda;
    }

    public Legenda(Integer idLegenda, String legDescricao) {
        this.idLegenda = idLegenda;
        this.legDescricao = legDescricao;
    }

    public Integer getIdLegenda() {
        return idLegenda;
    }

    public void setIdLegenda(Integer idLegenda) {
        this.idLegenda = idLegenda;
    }

    public String getLegDescricao() {
        return legDescricao;
    }

    public void setLegDescricao(String legDescricao) {
        this.legDescricao = legDescricao;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    @XmlTransient
    public Collection<Classe> getClasseCollection() {
        return classeCollection;
    }

    public void setClasseCollection(Collection<Classe> classeCollection) {
        this.classeCollection = classeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLegenda != null ? idLegenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Legenda)) {
            return false;
        }
        Legenda other = (Legenda) object;
        if ((this.idLegenda == null && other.idLegenda != null) || (this.idLegenda != null && !this.idLegenda.equals(other.idLegenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Legenda[ idLegenda=" + idLegenda + " ]";
    }

}
