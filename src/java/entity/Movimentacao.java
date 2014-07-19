/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idMovimentacao = :idMovimentacao"),
    @NamedQuery(name = "Movimentacao.findByDtPrevista", query = "SELECT m FROM Movimentacao m WHERE m.dtPrevista = :dtPrevista"),
    @NamedQuery(name = "Movimentacao.findByDtRealizacao", query = "SELECT m FROM Movimentacao m WHERE m.dtRealizacao = :dtRealizacao"),
    @NamedQuery(name = "Movimentacao.findByQtdFuncionario", query = "SELECT m FROM Movimentacao m WHERE m.qtdFuncionario = :qtdFuncionario"),
    @NamedQuery(name = "Movimentacao.findByHorario", query = "SELECT m FROM Movimentacao m WHERE m.horario = :horario"),
    @NamedQuery(name = "Movimentacao.findByDuracaoPrevista", query = "SELECT m FROM Movimentacao m WHERE m.duracaoPrevista = :duracaoPrevista"),
    @NamedQuery(name = "Movimentacao.findByCompatibilidade", query = "SELECT m FROM Movimentacao m WHERE m.compatibilidade = :compatibilidade")})
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimentacao")
    private Integer idMovimentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_prevista")
    @Temporal(TemporalType.DATE)
    private Date dtPrevista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_realizacao")
    @Temporal(TemporalType.DATE)
    private Date dtRealizacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_funcionario")
    private BigInteger qtdFuncionario;
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @Column(name = "duracao_prevista")
    @Temporal(TemporalType.TIME)
    private Date duracaoPrevista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @JoinColumn(name = "local_operacaoid_local_operacao", referencedColumnName = "id_local_operacao")
    @ManyToOne(optional = false)
    private LocalOperacao localOperacaoidLocalOperacao;
    @JoinColumn(name = "responsavel", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario responsavel;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Classe idClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimentacaoidMovimentacao")
    private Collection<StatusArmazem> statusArmazemCollection;

    public Movimentacao() {
    }

    public Movimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Movimentacao(Integer idMovimentacao, Date dtPrevista, Date dtRealizacao, BigInteger qtdFuncionario, String compatibilidade) {
        this.idMovimentacao = idMovimentacao;
        this.dtPrevista = dtPrevista;
        this.dtRealizacao = dtRealizacao;
        this.qtdFuncionario = qtdFuncionario;
        this.compatibilidade = compatibilidade;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Date getDtPrevista() {
        return dtPrevista;
    }

    public void setDtPrevista(Date dtPrevista) {
        this.dtPrevista = dtPrevista;
    }

    public Date getDtRealizacao() {
        return dtRealizacao;
    }

    public void setDtRealizacao(Date dtRealizacao) {
        this.dtRealizacao = dtRealizacao;
    }

    public BigInteger getQtdFuncionario() {
        return qtdFuncionario;
    }

    public void setQtdFuncionario(BigInteger qtdFuncionario) {
        this.qtdFuncionario = qtdFuncionario;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Date getDuracaoPrevista() {
        return duracaoPrevista;
    }

    public void setDuracaoPrevista(Date duracaoPrevista) {
        this.duracaoPrevista = duracaoPrevista;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public LocalOperacao getLocalOperacaoidLocalOperacao() {
        return localOperacaoidLocalOperacao;
    }

    public void setLocalOperacaoidLocalOperacao(LocalOperacao localOperacaoidLocalOperacao) {
        this.localOperacaoidLocalOperacao = localOperacaoidLocalOperacao;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @XmlTransient
    public Collection<StatusArmazem> getStatusArmazemCollection() {
        return statusArmazemCollection;
    }

    public void setStatusArmazemCollection(Collection<StatusArmazem> statusArmazemCollection) {
        this.statusArmazemCollection = statusArmazemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentacao != null ? idMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.idMovimentacao == null && other.idMovimentacao != null) || (this.idMovimentacao != null && !this.idMovimentacao.equals(other.idMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movimentacao[ idMovimentacao=" + idMovimentacao + " ]";
    }

}
