/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByNomegenerico", query = "SELECT p FROM Produto p WHERE p.nomegenerico = :nomegenerico"),
    @NamedQuery(name = "Produto.findByOrigem", query = "SELECT p FROM Produto p WHERE p.origem = :origem"),
    @NamedQuery(name = "Produto.findByNumcas", query = "SELECT p FROM Produto p WHERE p.numcas = :numcas"),
    @NamedQuery(name = "Produto.findByRotuloproduto", query = "SELECT p FROM Produto p WHERE p.rotuloproduto = :rotuloproduto"),
    @NamedQuery(name = "Produto.findByPainelseg", query = "SELECT p FROM Produto p WHERE p.painelseg = :painelseg"),
    @NamedQuery(name = "Produto.findByRisco", query = "SELECT p FROM Produto p WHERE p.risco = :risco"),
    @NamedQuery(name = "Produto.findByAcoesemergencia", query = "SELECT p FROM Produto p WHERE p.acoesemergencia = :acoesemergencia"),
    @NamedQuery(name = "Produto.findByNumlote", query = "SELECT p FROM Produto p WHERE p.numlote = :numlote"),
    @NamedQuery(name = "Produto.findByDtfabricacao", query = "SELECT p FROM Produto p WHERE p.dtfabricacao = :dtfabricacao"),
    @NamedQuery(name = "Produto.findByDtvalidade", query = "SELECT p FROM Produto p WHERE p.dtvalidade = :dtvalidade"),
    @NamedQuery(name = "Produto.findByClasseidClasse", query = "SELECT p FROM Produto p WHERE p.classeidClasse = :classeidClasse"),
    @NamedQuery(name = "Produto.findByComposprodutotipoproduto", query = "SELECT p FROM Produto p WHERE p.composprodutotipoproduto = :composprodutotipoproduto"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByCompatibilidade", query = "SELECT p FROM Produto p WHERE p.compatibilidade = :compatibilidade"),
    @NamedQuery(name = "Produto.findByFormulaproduto", query = "SELECT p FROM Produto p WHERE p.formulaproduto = :formulaproduto"),
    @NamedQuery(name = "Produto.findByFormaproduto", query = "SELECT p FROM Produto p WHERE p.formaproduto = :formaproduto"),
    @NamedQuery(name = "Produto.findByOdorproduto", query = "SELECT p FROM Produto p WHERE p.odorproduto = :odorproduto"),
    @NamedQuery(name = "Produto.findByPh", query = "SELECT p FROM Produto p WHERE p.ph = :ph"),
    @NamedQuery(name = "Produto.findByEstfisico", query = "SELECT p FROM Produto p WHERE p.estfisico = :estfisico"),
    @NamedQuery(name = "Produto.findBySolibilidadeagua", query = "SELECT p FROM Produto p WHERE p.solibilidadeagua = :solibilidadeagua"),
    @NamedQuery(name = "Produto.findByLimiteexplosivo", query = "SELECT p FROM Produto p WHERE p.limiteexplosivo = :limiteexplosivo"),
    @NamedQuery(name = "Produto.findByDensidade", query = "SELECT p FROM Produto p WHERE p.densidade = :densidade"),
    @NamedQuery(name = "Produto.findByPressavapor", query = "SELECT p FROM Produto p WHERE p.pressavapor = :pressavapor"),
    @NamedQuery(name = "Produto.findBySinonimos", query = "SELECT p FROM Produto p WHERE p.sinonimos = :sinonimos"),
    @NamedQuery(name = "Produto.findByTramentodisposicao", query = "SELECT p FROM Produto p WHERE p.tramentodisposicao = :tramentodisposicao"),
    @NamedQuery(name = "Produto.findByRegulamentacao", query = "SELECT p FROM Produto p WHERE p.regulamentacao = :regulamentacao"),
    @NamedQuery(name = "Produto.findByDecomposicao", query = "SELECT p FROM Produto p WHERE p.decomposicao = :decomposicao"),
    @NamedQuery(name = "Produto.findByTipodopoduto", query = "SELECT p FROM Produto p WHERE p.tipodopoduto = :tipodopoduto"),
    @NamedQuery(name = "Produto.findByIdComposi", query = "SELECT p FROM Produto p WHERE p.idComposi = :idComposi"),
    @NamedQuery(name = "Produto.findByNumOnu", query = "SELECT p FROM Produto p WHERE p.numOnu = :numOnu"),
    @NamedQuery(name = "Produto.findByIdPtEbulicao", query = "SELECT p FROM Produto p WHERE p.idPtEbulicao = :idPtEbulicao"),
    @NamedQuery(name = "Produto.findByPtEbuliMin", query = "SELECT p FROM Produto p WHERE p.ptEbuliMin = :ptEbuliMin"),
    @NamedQuery(name = "Produto.findByPtEbuliMax", query = "SELECT p FROM Produto p WHERE p.ptEbuliMax = :ptEbuliMax"),
    @NamedQuery(name = "Produto.findByIdPtFulgor", query = "SELECT p FROM Produto p WHERE p.idPtFulgor = :idPtFulgor"),
    @NamedQuery(name = "Produto.findByPtFulgMin", query = "SELECT p FROM Produto p WHERE p.ptFulgMin = :ptFulgMin"),
    @NamedQuery(name = "Produto.findByPtFulgMax", query = "SELECT p FROM Produto p WHERE p.ptFulgMax = :ptFulgMax"),
    @NamedQuery(name = "Produto.findByIdEnderecamento", query = "SELECT p FROM Produto p WHERE p.idEnderecamento = :idEnderecamento"),
    @NamedQuery(name = "Produto.findByRuaArmazem", query = "SELECT p FROM Produto p WHERE p.ruaArmazem = :ruaArmazem"),
    @NamedQuery(name = "Produto.findByLado", query = "SELECT p FROM Produto p WHERE p.lado = :lado"),
    @NamedQuery(name = "Produto.findByNivel", query = "SELECT p FROM Produto p WHERE p.nivel = :nivel"),
    @NamedQuery(name = "Produto.findByPosicao", query = "SELECT p FROM Produto p WHERE p.posicao = :posicao"),
    @NamedQuery(name = "Produto.findByQtdProduto", query = "SELECT p FROM Produto p WHERE p.qtdProduto = :qtdProduto"),
    @NamedQuery(name = "Produto.findByValorUnitario", query = "SELECT p FROM Produto p WHERE p.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Produto.findByNomefantasia", query = "SELECT p FROM Produto p WHERE p.nomefantasia = :nomefantasia"),
    @NamedQuery(name = "Produto.findByIdDetalheNota", query = "SELECT p FROM Produto p WHERE p.idDetalheNota = :idDetalheNota"),
    @NamedQuery(name = "Produto.findByNumNota", query = "SELECT p FROM Produto p WHERE p.numNota = :numNota")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Size(max = 120)
    @Column(name = "nomegenerico")
    private String nomegenerico;
    @Size(max = 120)
    @Column(name = "origem")
    private String origem;
    @Size(max = 10)
    @Column(name = "numcas")
    private String numcas;
    @Size(max = 30)
    @Column(name = "rotuloproduto")
    private String rotuloproduto;
    @Size(max = 30)
    @Column(name = "painelseg")
    private String painelseg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "risco")
    private String risco;
    @Size(max = 255)
    @Column(name = "acoesemergencia")
    private String acoesemergencia;
    @Size(max = 30)
    @Column(name = "numlote")
    private String numlote;
    @Column(name = "dtfabricacao")
    @Temporal(TemporalType.DATE)
    private Date dtfabricacao;
    @Column(name = "dtvalidade")
    @Temporal(TemporalType.DATE)
    private Date dtvalidade;
    @Column(name = "classeid_classe")
    private Integer classeidClasse;
    @Column(name = "composprodutotipoproduto")
    private Integer composprodutotipoproduto;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @Size(max = 45)
    @Column(name = "formulaproduto")
    private String formulaproduto;
    @Size(max = 45)
    @Column(name = "formaproduto")
    private String formaproduto;
    @Size(max = 45)
    @Column(name = "odorproduto")
    private String odorproduto;
    @Size(max = 45)
    @Column(name = "ph")
    private String ph;
    @Size(max = 35)
    @Column(name = "estfisico")
    private String estfisico;
    @Size(max = 35)
    @Column(name = "solibilidadeagua")
    private String solibilidadeagua;
    @Size(max = 35)
    @Column(name = "limiteexplosivo")
    private String limiteexplosivo;
    @Size(max = 35)
    @Column(name = "densidade")
    private String densidade;
    @Size(max = 35)
    @Column(name = "pressavapor")
    private String pressavapor;
    @Size(max = 30)
    @Column(name = "sinonimos")
    private String sinonimos;
    @Size(max = 255)
    @Column(name = "tramentodisposicao")
    private String tramentodisposicao;
    @Size(max = 100)
    @Column(name = "regulamentacao")
    private String regulamentacao;
    @Size(max = 100)
    @Column(name = "decomposicao")
    private String decomposicao;
    @Size(max = 30)
    @Column(name = "tipodopoduto")
    private String tipodopoduto;
    @Basic(optional = false)
    @Column(name = "id_composi")
    private int idComposi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_onu")
    private int numOnu;
    @Column(name = "id_pt_ebulicao")
    private Integer idPtEbulicao;
    @Column(name = "pt_ebuli_min")
    private Integer ptEbuliMin;
    @Column(name = "pt_ebuli_max")
    private Integer ptEbuliMax;
    @Column(name = "id_pt_fulgor")
    private Integer idPtFulgor;
    @Column(name = "pt_fulg_min")
    private Integer ptFulgMin;
    @Column(name = "pt_fulg_max")
    private Integer ptFulgMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_enderecamento")
    private int idEnderecamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "rua_armazem")
    private String ruaArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "lado")
    private String lado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "posicao")
    private String posicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_produto")
    private int qtdProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomefantasia")
    private String nomefantasia;
    @Column(name = "id_detalhe_nota")
    private Integer idDetalheNota;
    @Column(name = "num_nota")
    private Integer numNota;
    @JoinColumn(name = "id_num_onu", referencedColumnName = "id_num_onu")
    @ManyToOne(optional = false)
    private NumOnu idNumOnu;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne
    private Fornecedor idFornecedor;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne
    private Classe idClasse;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String nomeProduto, String risco, String compatibilidade, int idComposi, int numOnu, int idEnderecamento, String ruaArmazem, String lado, String nivel, String posicao, int qtdProduto, BigDecimal valorUnitario, String nomefantasia) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.risco = risco;
        this.compatibilidade = compatibilidade;
        this.idComposi = idComposi;
        this.numOnu = numOnu;
        this.idEnderecamento = idEnderecamento;
        this.ruaArmazem = ruaArmazem;
        this.lado = lado;
        this.nivel = nivel;
        this.posicao = posicao;
        this.qtdProduto = qtdProduto;
        this.valorUnitario = valorUnitario;
        this.nomefantasia = nomefantasia;
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

    public String getNomegenerico() {
        return nomegenerico;
    }

    public void setNomegenerico(String nomegenerico) {
        this.nomegenerico = nomegenerico;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getNumcas() {
        return numcas;
    }

    public void setNumcas(String numcas) {
        this.numcas = numcas;
    }

    public String getRotuloproduto() {
        return rotuloproduto;
    }

    public void setRotuloproduto(String rotuloproduto) {
        this.rotuloproduto = rotuloproduto;
    }

    public String getPainelseg() {
        return painelseg;
    }

    public void setPainelseg(String painelseg) {
        this.painelseg = painelseg;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getAcoesemergencia() {
        return acoesemergencia;
    }

    public void setAcoesemergencia(String acoesemergencia) {
        this.acoesemergencia = acoesemergencia;
    }

    public String getNumlote() {
        return numlote;
    }

    public void setNumlote(String numlote) {
        this.numlote = numlote;
    }

    public Date getDtfabricacao() {
        return dtfabricacao;
    }

    public void setDtfabricacao(Date dtfabricacao) {
        this.dtfabricacao = dtfabricacao;
    }

    public Date getDtvalidade() {
        return dtvalidade;
    }

    public void setDtvalidade(Date dtvalidade) {
        this.dtvalidade = dtvalidade;
    }

    public Integer getClasseidClasse() {
        return classeidClasse;
    }

    public void setClasseidClasse(Integer classeidClasse) {
        this.classeidClasse = classeidClasse;
    }

    public Integer getComposprodutotipoproduto() {
        return composprodutotipoproduto;
    }

    public void setComposprodutotipoproduto(Integer composprodutotipoproduto) {
        this.composprodutotipoproduto = composprodutotipoproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public String getFormulaproduto() {
        return formulaproduto;
    }

    public void setFormulaproduto(String formulaproduto) {
        this.formulaproduto = formulaproduto;
    }

    public String getFormaproduto() {
        return formaproduto;
    }

    public void setFormaproduto(String formaproduto) {
        this.formaproduto = formaproduto;
    }

    public String getOdorproduto() {
        return odorproduto;
    }

    public void setOdorproduto(String odorproduto) {
        this.odorproduto = odorproduto;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEstfisico() {
        return estfisico;
    }

    public void setEstfisico(String estfisico) {
        this.estfisico = estfisico;
    }

    public String getSolibilidadeagua() {
        return solibilidadeagua;
    }

    public void setSolibilidadeagua(String solibilidadeagua) {
        this.solibilidadeagua = solibilidadeagua;
    }

    public String getLimiteexplosivo() {
        return limiteexplosivo;
    }

    public void setLimiteexplosivo(String limiteexplosivo) {
        this.limiteexplosivo = limiteexplosivo;
    }

    public String getDensidade() {
        return densidade;
    }

    public void setDensidade(String densidade) {
        this.densidade = densidade;
    }

    public String getPressavapor() {
        return pressavapor;
    }

    public void setPressavapor(String pressavapor) {
        this.pressavapor = pressavapor;
    }

    public String getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(String sinonimos) {
        this.sinonimos = sinonimos;
    }

    public String getTramentodisposicao() {
        return tramentodisposicao;
    }

    public void setTramentodisposicao(String tramentodisposicao) {
        this.tramentodisposicao = tramentodisposicao;
    }

    public String getRegulamentacao() {
        return regulamentacao;
    }

    public void setRegulamentacao(String regulamentacao) {
        this.regulamentacao = regulamentacao;
    }

    public String getDecomposicao() {
        return decomposicao;
    }

    public void setDecomposicao(String decomposicao) {
        this.decomposicao = decomposicao;
    }

    public String getTipodopoduto() {
        return tipodopoduto;
    }

    public void setTipodopoduto(String tipodopoduto) {
        this.tipodopoduto = tipodopoduto;
    }

    public int getIdComposi() {
        return idComposi;
    }

    public void setIdComposi(int idComposi) {
        this.idComposi = idComposi;
    }

    public int getNumOnu() {
        return numOnu;
    }

    public void setNumOnu(int numOnu) {
        this.numOnu = numOnu;
    }

    public Integer getIdPtEbulicao() {
        return idPtEbulicao;
    }

    public void setIdPtEbulicao(Integer idPtEbulicao) {
        this.idPtEbulicao = idPtEbulicao;
    }

    public Integer getPtEbuliMin() {
        return ptEbuliMin;
    }

    public void setPtEbuliMin(Integer ptEbuliMin) {
        this.ptEbuliMin = ptEbuliMin;
    }

    public Integer getPtEbuliMax() {
        return ptEbuliMax;
    }

    public void setPtEbuliMax(Integer ptEbuliMax) {
        this.ptEbuliMax = ptEbuliMax;
    }

    public Integer getIdPtFulgor() {
        return idPtFulgor;
    }

    public void setIdPtFulgor(Integer idPtFulgor) {
        this.idPtFulgor = idPtFulgor;
    }

    public Integer getPtFulgMin() {
        return ptFulgMin;
    }

    public void setPtFulgMin(Integer ptFulgMin) {
        this.ptFulgMin = ptFulgMin;
    }

    public Integer getPtFulgMax() {
        return ptFulgMax;
    }

    public void setPtFulgMax(Integer ptFulgMax) {
        this.ptFulgMax = ptFulgMax;
    }

    public int getIdEnderecamento() {
        return idEnderecamento;
    }

    public void setIdEnderecamento(int idEnderecamento) {
        this.idEnderecamento = idEnderecamento;
    }

    public String getRuaArmazem() {
        return ruaArmazem;
    }

    public void setRuaArmazem(String ruaArmazem) {
        this.ruaArmazem = ruaArmazem;
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

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public Integer getIdDetalheNota() {
        return idDetalheNota;
    }

    public void setIdDetalheNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public Integer getNumNota() {
        return numNota;
    }

    public void setNumNota(Integer numNota) {
        this.numNota = numNota;
    }

    public NumOnu getIdNumOnu() {
        return idNumOnu;
    }

    public void setIdNumOnu(NumOnu idNumOnu) {
        this.idNumOnu = idNumOnu;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
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
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produto[ idProduto=" + idProduto + " ]";
    }

}
