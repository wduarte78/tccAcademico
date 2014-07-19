/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "tipo_movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimentacao.findAll", query = "SELECT t FROM TipoMovimentacao t"),
    @NamedQuery(name = "TipoMovimentacao.findByIdTipoMovimentacao", query = "SELECT t FROM TipoMovimentacao t WHERE t.idTipoMovimentacao = :idTipoMovimentacao"),
    @NamedQuery(name = "TipoMovimentacao.findByTipoMovimentacao", query = "SELECT t FROM TipoMovimentacao t WHERE t.tipoMovimentacao = :tipoMovimentacao"),
    @NamedQuery(name = "TipoMovimentacao.findByMatricula", query = "SELECT t FROM TipoMovimentacao t WHERE t.matricula = :matricula"),
    @NamedQuery(name = "TipoMovimentacao.findByTipoPedido", query = "SELECT t FROM TipoMovimentacao t WHERE t.tipoPedido = :tipoPedido"),
    @NamedQuery(name = "TipoMovimentacao.findByIdEspecPedido", query = "SELECT t FROM TipoMovimentacao t WHERE t.idEspecPedido = :idEspecPedido"),
    @NamedQuery(name = "TipoMovimentacao.findByEspecPedido", query = "SELECT t FROM TipoMovimentacao t WHERE t.especPedido = :especPedido"),
    @NamedQuery(name = "TipoMovimentacao.findByNomeFuncionario", query = "SELECT t FROM TipoMovimentacao t WHERE t.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "TipoMovimentacao.findByObservacoes", query = "SELECT t FROM TipoMovimentacao t WHERE t.observacoes = :observacoes")})
public class TipoMovimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_movimentacao")
    private Integer idTipoMovimentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_movimentacao")
    private int tipoMovimentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;
    @Size(max = 50)
    @Column(name = "tipo_pedido")
    private String tipoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_espec_pedido")
    private int idEspecPedido;
    @Size(max = 40)
    @Column(name = "espec_pedido")
    private String especPedido;
    @Size(max = 60)
    @Column(name = "nome_funcionario")
    private String nomeFuncionario;
    @Size(max = 150)
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "id_tipo_pedido", referencedColumnName = "id_tipo_pedido")
    @ManyToOne
    private TipoPedido idTipoPedido;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public TipoMovimentacao() {
    }

    public TipoMovimentacao(Integer idTipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
    }

    public TipoMovimentacao(Integer idTipoMovimentacao, int tipoMovimentacao, int matricula, int idEspecPedido) {
        this.idTipoMovimentacao = idTipoMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.matricula = matricula;
        this.idEspecPedido = idEspecPedido;
    }

    public Integer getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }

    public void setIdTipoMovimentacao(Integer idTipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
    }

    public int getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(int tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public int getIdEspecPedido() {
        return idEspecPedido;
    }

    public void setIdEspecPedido(int idEspecPedido) {
        this.idEspecPedido = idEspecPedido;
    }

    public String getEspecPedido() {
        return especPedido;
    }

    public void setEspecPedido(String especPedido) {
        this.especPedido = especPedido;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public TipoPedido getIdTipoPedido() {
        return idTipoPedido;
    }

    public void setIdTipoPedido(TipoPedido idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMovimentacao != null ? idTipoMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimentacao)) {
            return false;
        }
        TipoMovimentacao other = (TipoMovimentacao) object;
        if ((this.idTipoMovimentacao == null && other.idTipoMovimentacao != null) || (this.idTipoMovimentacao != null && !this.idTipoMovimentacao.equals(other.idTipoMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoMovimentacao[ idTipoMovimentacao=" + idTipoMovimentacao + " ]";
    }

}
