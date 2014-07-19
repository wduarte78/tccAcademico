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
@Table(name = "armazem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armazem.findAll", query = "SELECT a FROM Armazem a"),
    @NamedQuery(name = "Armazem.findByIdArmazem", query = "SELECT a FROM Armazem a WHERE a.idArmazem = :idArmazem"),
    @NamedQuery(name = "Armazem.findByTipo", query = "SELECT a FROM Armazem a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Armazem.findByCapacidade", query = "SELECT a FROM Armazem a WHERE a.capacidade = :capacidade"),
    @NamedQuery(name = "Armazem.findByEspecificacao", query = "SELECT a FROM Armazem a WHERE a.especificacao = :especificacao"),
    @NamedQuery(name = "Armazem.findByCertificacao", query = "SELECT a FROM Armazem a WHERE a.certificacao = :certificacao"),
    @NamedQuery(name = "Armazem.findByCor", query = "SELECT a FROM Armazem a WHERE a.cor = :cor"),
    @NamedQuery(name = "Armazem.findByRua", query = "SELECT a FROM Armazem a WHERE a.rua = :rua"),
    @NamedQuery(name = "Armazem.findByLado", query = "SELECT a FROM Armazem a WHERE a.lado = :lado"),
    @NamedQuery(name = "Armazem.findByNivel", query = "SELECT a FROM Armazem a WHERE a.nivel = :nivel"),
    @NamedQuery(name = "Armazem.findByPosicao", query = "SELECT a FROM Armazem a WHERE a.posicao = :posicao"),
    @NamedQuery(name = "Armazem.findByCompatibilidade", query = "SELECT a FROM Armazem a WHERE a.compatibilidade = :compatibilidade"),
    @NamedQuery(name = "Armazem.findByEstoqMax", query = "SELECT a FROM Armazem a WHERE a.estoqMax = :estoqMax"),
    @NamedQuery(name = "Armazem.findByEstoqMin", query = "SELECT a FROM Armazem a WHERE a.estoqMin = :estoqMin")})
public class Armazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_armazem")
    private Integer idArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidade")
    private int capacidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especificacao")
    private String especificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "certificacao")
    private String certificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "lado")
    private String lado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "posicao")
    private String posicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estoq_max")
    private String estoqMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estoq_min")
    private String estoqMin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armazemidArmazem")
    private Collection<StatusArmazem> statusArmazemCollection;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_enderecamento")
    @ManyToOne
    private EndArmazem idEndereco;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Classe idClasse;

    public Armazem() {
    }

    public Armazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public Armazem(Integer idArmazem, String tipo, int capacidade, String especificacao, String certificacao, String cor, String rua, String lado, String nivel, String posicao, String compatibilidade, String estoqMax, String estoqMin) {
        this.idArmazem = idArmazem;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.especificacao = especificacao;
        this.certificacao = certificacao;
        this.cor = cor;
        this.rua = rua;
        this.lado = lado;
        this.nivel = nivel;
        this.posicao = posicao;
        this.compatibilidade = compatibilidade;
        this.estoqMax = estoqMax;
        this.estoqMin = estoqMin;
    }

    public Integer getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public String getEstoqMax() {
        return estoqMax;
    }

    public void setEstoqMax(String estoqMax) {
        this.estoqMax = estoqMax;
    }

    public String getEstoqMin() {
        return estoqMin;
    }

    public void setEstoqMin(String estoqMin) {
        this.estoqMin = estoqMin;
    }

    @XmlTransient
    public Collection<StatusArmazem> getStatusArmazemCollection() {
        return statusArmazemCollection;
    }

    public void setStatusArmazemCollection(Collection<StatusArmazem> statusArmazemCollection) {
        this.statusArmazemCollection = statusArmazemCollection;
    }

    public EndArmazem getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(EndArmazem idEndereco) {
        this.idEndereco = idEndereco;
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
        hash += (idArmazem != null ? idArmazem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armazem)) {
            return false;
        }
        Armazem other = (Armazem) object;
        if ((this.idArmazem == null && other.idArmazem != null) || (this.idArmazem != null && !this.idArmazem.equals(other.idArmazem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Armazem[ idArmazem=" + idArmazem + " ]";
    }

}
