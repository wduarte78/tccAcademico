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
@Table(name = "local_operacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalOperacao.findAll", query = "SELECT l FROM LocalOperacao l"),
    @NamedQuery(name = "LocalOperacao.findByIdLocalOperacao", query = "SELECT l FROM LocalOperacao l WHERE l.idLocalOperacao = :idLocalOperacao"),
    @NamedQuery(name = "LocalOperacao.findByLocal", query = "SELECT l FROM LocalOperacao l WHERE l.local = :local"),
    @NamedQuery(name = "LocalOperacao.findByLocDescricao", query = "SELECT l FROM LocalOperacao l WHERE l.locDescricao = :locDescricao"),
    @NamedQuery(name = "LocalOperacao.findByCompatibilidade", query = "SELECT l FROM LocalOperacao l WHERE l.compatibilidade = :compatibilidade")})
public class LocalOperacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_local_operacao")
    private Integer idLocalOperacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "local")
    private String local;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "loc_descricao")
    private String locDescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localOperacaoidLocalOperacao")
    private Collection<Movimentacao> movimentacaoCollection;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Classe idClasse;

    public LocalOperacao() {
    }

    public LocalOperacao(Integer idLocalOperacao) {
        this.idLocalOperacao = idLocalOperacao;
    }

    public LocalOperacao(Integer idLocalOperacao, String local, String locDescricao, String compatibilidade) {
        this.idLocalOperacao = idLocalOperacao;
        this.local = local;
        this.locDescricao = locDescricao;
        this.compatibilidade = compatibilidade;
    }

    public Integer getIdLocalOperacao() {
        return idLocalOperacao;
    }

    public void setIdLocalOperacao(Integer idLocalOperacao) {
        this.idLocalOperacao = idLocalOperacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocDescricao() {
        return locDescricao;
    }

    public void setLocDescricao(String locDescricao) {
        this.locDescricao = locDescricao;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalOperacao != null ? idLocalOperacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalOperacao)) {
            return false;
        }
        LocalOperacao other = (LocalOperacao) object;
        if ((this.idLocalOperacao == null && other.idLocalOperacao != null) || (this.idLocalOperacao != null && !this.idLocalOperacao.equals(other.idLocalOperacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LocalOperacao[ idLocalOperacao=" + idLocalOperacao + " ]";
    }

}
