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
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCodCidade", query = "SELECT c FROM Cidade c WHERE c.codCidade = :codCidade"),
    @NamedQuery(name = "Cidade.findByNomCidade", query = "SELECT c FROM Cidade c WHERE c.nomCidade = :nomCidade")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cidade")
    private Integer codCidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_cidade")
    private String nomCidade;
    @JoinColumn(name = "cod_estado", referencedColumnName = "cod_estado")
    @ManyToOne(optional = false)
    private Estado codEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCidade")
    private Collection<Endereco> enderecoCollection;

    public Cidade() {
    }

    public Cidade(Integer codCidade) {
        this.codCidade = codCidade;
    }

    public Cidade(Integer codCidade, String nomCidade) {
        this.codCidade = codCidade;
        this.nomCidade = nomCidade;
    }

    public Integer getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Integer codCidade) {
        this.codCidade = codCidade;
    }

    public String getNomCidade() {
        return nomCidade;
    }

    public void setNomCidade(String nomCidade) {
        this.nomCidade = nomCidade;
    }

    public Estado getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Estado codEstado) {
        this.codEstado = codEstado;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCidade != null ? codCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.codCidade == null && other.codCidade != null) || (this.codCidade != null && !this.codCidade.equals(other.codCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cidade[ codCidade=" + codCidade + " ]";
    }

}
