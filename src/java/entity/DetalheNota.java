/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "detalhe_nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalheNota.findAll", query = "SELECT d FROM DetalheNota d"),
    @NamedQuery(name = "DetalheNota.findByIdDetalheNota", query = "SELECT d FROM DetalheNota d WHERE d.idDetalheNota = :idDetalheNota"),
    @NamedQuery(name = "DetalheNota.findByNumNota", query = "SELECT d FROM DetalheNota d WHERE d.numNota = :numNota"),
    @NamedQuery(name = "DetalheNota.findByDtPedido", query = "SELECT d FROM DetalheNota d WHERE d.dtPedido = :dtPedido"),
    @NamedQuery(name = "DetalheNota.findByValorTotal", query = "SELECT d FROM DetalheNota d WHERE d.valorTotal = :valorTotal"),
    @NamedQuery(name = "DetalheNota.findByValorUnitario", query = "SELECT d FROM DetalheNota d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalheNota.findByQtdProduto", query = "SELECT d FROM DetalheNota d WHERE d.qtdProduto = :qtdProduto"),
    @NamedQuery(name = "DetalheNota.findByIdProduto", query = "SELECT d FROM DetalheNota d WHERE d.idProduto = :idProduto"),
    @NamedQuery(name = "DetalheNota.findByNomeProduto", query = "SELECT d FROM DetalheNota d WHERE d.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "DetalheNota.findByCompatibilidade", query = "SELECT d FROM DetalheNota d WHERE d.compatibilidade = :compatibilidade")})
public class DetalheNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalhe_nota")
    private Integer idDetalheNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_nota")
    private int numNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_pedido")
    @Temporal(TemporalType.DATE)
    private Date dtPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_produto")
    private int qtdProduto;
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Size(max = 200)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @JoinColumn(name = "tipo_equipamentoid_tipo_equipamento", referencedColumnName = "id_tipo_equipamento")
    @ManyToOne(optional = false)
    private TipoEquipamento tipoEquipamentoidTipoEquipamento;
    @JoinColumn(name = "fornecedorid_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedoridFornecedor;
    @JoinColumn(name = "embalagemid_embalgem", referencedColumnName = "id_embalgem")
    @ManyToOne(optional = false)
    private Embalagem embalagemidEmbalgem;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne
    private Classe idClasse;
    @OneToMany(mappedBy = "idDetalheNota")
    private Collection<TipoPedido> tipoPedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalheNotaidDetalheNota")
    private Collection<TipoPedido> tipoPedidoCollection1;

    public DetalheNota() {
    }

    public DetalheNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public DetalheNota(Integer idDetalheNota, int numNota, Date dtPedido, BigDecimal valorTotal, BigDecimal valorUnitario, int qtdProduto, String nomeProduto) {
        this.idDetalheNota = idDetalheNota;
        this.numNota = numNota;
        this.dtPedido = dtPedido;
        this.valorTotal = valorTotal;
        this.valorUnitario = valorUnitario;
        this.qtdProduto = qtdProduto;
        this.nomeProduto = nomeProduto;
    }

    public Integer getIdDetalheNota() {
        return idDetalheNota;
    }

    public void setIdDetalheNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public int getNumNota() {
        return numNota;
    }

    public void setNumNota(int numNota) {
        this.numNota = numNota;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public TipoEquipamento getTipoEquipamentoidTipoEquipamento() {
        return tipoEquipamentoidTipoEquipamento;
    }

    public void setTipoEquipamentoidTipoEquipamento(TipoEquipamento tipoEquipamentoidTipoEquipamento) {
        this.tipoEquipamentoidTipoEquipamento = tipoEquipamentoidTipoEquipamento;
    }

    public Fornecedor getFornecedoridFornecedor() {
        return fornecedoridFornecedor;
    }

    public void setFornecedoridFornecedor(Fornecedor fornecedoridFornecedor) {
        this.fornecedoridFornecedor = fornecedoridFornecedor;
    }

    public Embalagem getEmbalagemidEmbalgem() {
        return embalagemidEmbalgem;
    }

    public void setEmbalagemidEmbalgem(Embalagem embalagemidEmbalgem) {
        this.embalagemidEmbalgem = embalagemidEmbalgem;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @XmlTransient
    public Collection<TipoPedido> getTipoPedidoCollection() {
        return tipoPedidoCollection;
    }

    public void setTipoPedidoCollection(Collection<TipoPedido> tipoPedidoCollection) {
        this.tipoPedidoCollection = tipoPedidoCollection;
    }

    @XmlTransient
    public Collection<TipoPedido> getTipoPedidoCollection1() {
        return tipoPedidoCollection1;
    }

    public void setTipoPedidoCollection1(Collection<TipoPedido> tipoPedidoCollection1) {
        this.tipoPedidoCollection1 = tipoPedidoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalheNota != null ? idDetalheNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalheNota)) {
            return false;
        }
        DetalheNota other = (DetalheNota) object;
        if ((this.idDetalheNota == null && other.idDetalheNota != null) || (this.idDetalheNota != null && !this.idDetalheNota.equals(other.idDetalheNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetalheNota[ idDetalheNota=" + idDetalheNota + " ]";
    }

}
