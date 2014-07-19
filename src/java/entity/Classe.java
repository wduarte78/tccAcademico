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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdClasse", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.findByClasse", query = "SELECT c FROM Classe c WHERE c.classe = :classe"),
    @NamedQuery(name = "Classe.findByLegenda", query = "SELECT c FROM Classe c WHERE c.legenda = :legenda"),
    @NamedQuery(name = "Classe.findByCompatibilidade", query = "SELECT c FROM Classe c WHERE c.compatibilidade = :compatibilidade"),
    @NamedQuery(name = "Classe.findBySubclasse", query = "SELECT c FROM Classe c WHERE c.subclasse = :subclasse"),
    @NamedQuery(name = "Classe.findByDescricao", query = "SELECT c FROM Classe c WHERE c.descricao = :descricao")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_classe")
    private Integer idClasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "classe")
    private String classe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "legenda")
    private String legenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "subclasse")
    private String subclasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idClasse")
    private Collection<Produto> produtoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<Embalagem> embalagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<Movimentacao> movimentacaoCollection;
    @OneToMany(mappedBy = "idClasse")
    private Collection<DetalheNota> detalheNotaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<LocalOperacao> localOperacaoCollection;
    @JoinColumn(name = "id_legenda", referencedColumnName = "id_legenda")
    @ManyToOne
    private Legenda idLegenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<Armazem> armazemCollection;

    public Classe() {
    }

    public Classe(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Classe(Integer idClasse, String classe, String legenda, String compatibilidade, String subclasse, String descricao) {
        this.idClasse = idClasse;
        this.classe = classe;
        this.legenda = legenda;
        this.compatibilidade = compatibilidade;
        this.subclasse = subclasse;
        this.descricao = descricao;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public String getSubclasse() {
        return subclasse;
    }

    public void setSubclasse(String subclasse) {
        this.subclasse = subclasse;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    @XmlTransient
    public Collection<DetalheNota> getDetalheNotaCollection() {
        return detalheNotaCollection;
    }

    public void setDetalheNotaCollection(Collection<DetalheNota> detalheNotaCollection) {
        this.detalheNotaCollection = detalheNotaCollection;
    }

    @XmlTransient
    public Collection<LocalOperacao> getLocalOperacaoCollection() {
        return localOperacaoCollection;
    }

    public void setLocalOperacaoCollection(Collection<LocalOperacao> localOperacaoCollection) {
        this.localOperacaoCollection = localOperacaoCollection;
    }

    public Legenda getIdLegenda() {
        return idLegenda;
    }

    public void setIdLegenda(Legenda idLegenda) {
        this.idLegenda = idLegenda;
    }

    @XmlTransient
    public Collection<Armazem> getArmazemCollection() {
        return armazemCollection;
    }

    public void setArmazemCollection(Collection<Armazem> armazemCollection) {
        this.armazemCollection = armazemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Classe[ idClasse=" + idClasse + " ]";
    }

}
