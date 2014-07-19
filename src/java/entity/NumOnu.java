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
@Table(name = "num_onu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumOnu.findAll", query = "SELECT n FROM NumOnu n"),
    @NamedQuery(name = "NumOnu.findByIdNumOnu", query = "SELECT n FROM NumOnu n WHERE n.idNumOnu = :idNumOnu"),
    @NamedQuery(name = "NumOnu.findByNumOnu", query = "SELECT n FROM NumOnu n WHERE n.numOnu = :numOnu"),
    @NamedQuery(name = "NumOnu.findByEspecificacoes", query = "SELECT n FROM NumOnu n WHERE n.especificacoes = :especificacoes")})
public class NumOnu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_num_onu")
    private Integer idNumOnu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_onu")
    private int numOnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "especificacoes")
    private String especificacoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNumOnu")
    private Collection<Produto> produtoCollection;

    public NumOnu() {
    }

    public NumOnu(Integer idNumOnu) {
        this.idNumOnu = idNumOnu;
    }

    public NumOnu(Integer idNumOnu, int numOnu, String especificacoes) {
        this.idNumOnu = idNumOnu;
        this.numOnu = numOnu;
        this.especificacoes = especificacoes;
    }

    public Integer getIdNumOnu() {
        return idNumOnu;
    }

    public void setIdNumOnu(Integer idNumOnu) {
        this.idNumOnu = idNumOnu;
    }

    public int getNumOnu() {
        return numOnu;
    }

    public void setNumOnu(int numOnu) {
        this.numOnu = numOnu;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumOnu != null ? idNumOnu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumOnu)) {
            return false;
        }
        NumOnu other = (NumOnu) object;
        if ((this.idNumOnu == null && other.idNumOnu != null) || (this.idNumOnu != null && !this.idNumOnu.equals(other.idNumOnu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NumOnu[ idNumOnu=" + idNumOnu + " ]";
    }

}
