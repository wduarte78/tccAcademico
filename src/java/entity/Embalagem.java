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
@Table(name = "embalagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Embalagem.findAll", query = "SELECT e FROM Embalagem e"),
    @NamedQuery(name = "Embalagem.findByIdEmbalgem", query = "SELECT e FROM Embalagem e WHERE e.idEmbalgem = :idEmbalgem"),
    @NamedQuery(name = "Embalagem.findByCapacidade", query = "SELECT e FROM Embalagem e WHERE e.capacidade = :capacidade"),
    @NamedQuery(name = "Embalagem.findByEspeceficacao", query = "SELECT e FROM Embalagem e WHERE e.especeficacao = :especeficacao"),
    @NamedQuery(name = "Embalagem.findByCondicoes", query = "SELECT e FROM Embalagem e WHERE e.condicoes = :condicoes"),
    @NamedQuery(name = "Embalagem.findByDtfabricacao", query = "SELECT e FROM Embalagem e WHERE e.dtfabricacao = :dtfabricacao"),
    @NamedQuery(name = "Embalagem.findByCertificado", query = "SELECT e FROM Embalagem e WHERE e.certificado = :certificado"),
    @NamedQuery(name = "Embalagem.findByValidadecert", query = "SELECT e FROM Embalagem e WHERE e.validadecert = :validadecert"),
    @NamedQuery(name = "Embalagem.findByValorunitario", query = "SELECT e FROM Embalagem e WHERE e.valorunitario = :valorunitario"),
    @NamedQuery(name = "Embalagem.findByCompatibilidade", query = "SELECT e FROM Embalagem e WHERE e.compatibilidade = :compatibilidade"),
    @NamedQuery(name = "Embalagem.findByGrupo", query = "SELECT e FROM Embalagem e WHERE e.grupo = :grupo"),
    @NamedQuery(name = "Embalagem.findByTipoMaterial", query = "SELECT e FROM Embalagem e WHERE e.tipoMaterial = :tipoMaterial")})
public class Embalagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_embalgem")
    private Integer idEmbalgem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "capacidade")
    private String capacidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especeficacao")
    private String especeficacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "condicoes")
    private String condicoes;
    @Column(name = "dtfabricacao")
    @Temporal(TemporalType.DATE)
    private Date dtfabricacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "certificado")
    private String certificado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validadecert")
    @Temporal(TemporalType.DATE)
    private Date validadecert;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorunitario")
    private BigDecimal valorunitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "compatibilidade")
    private String compatibilidade;
    @Size(max = 3)
    @Column(name = "grupo")
    private String grupo;
    @Size(max = 30)
    @Column(name = "tipo_material")
    private String tipoMaterial;
    @JoinColumn(name = "tipo_embalagemid_tipo_embalagem", referencedColumnName = "id_tipo_embalagem")
    @ManyToOne(optional = false)
    private TipoEmbalagem tipoEmbalagemidTipoEmbalagem;
    @JoinColumn(name = "materialid_material", referencedColumnName = "id_material")
    @ManyToOne(optional = false)
    private Material materialidMaterial;
    @JoinColumn(name = "grupoembalagemid_grupoembalagem", referencedColumnName = "id_grupoembalagem")
    @ManyToOne(optional = false)
    private Grupoembalagem grupoembalagemidGrupoembalagem;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Classe idClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "embalagemidEmbalgem")
    private Collection<DetalheNota> detalheNotaCollection;

    public Embalagem() {
    }

    public Embalagem(Integer idEmbalgem) {
        this.idEmbalgem = idEmbalgem;
    }

    public Embalagem(Integer idEmbalgem, String capacidade, String especeficacao, String condicoes, String certificado, Date validadecert, BigDecimal valorunitario, String compatibilidade) {
        this.idEmbalgem = idEmbalgem;
        this.capacidade = capacidade;
        this.especeficacao = especeficacao;
        this.condicoes = condicoes;
        this.certificado = certificado;
        this.validadecert = validadecert;
        this.valorunitario = valorunitario;
        this.compatibilidade = compatibilidade;
    }

    public Integer getIdEmbalgem() {
        return idEmbalgem;
    }

    public void setIdEmbalgem(Integer idEmbalgem) {
        this.idEmbalgem = idEmbalgem;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getEspeceficacao() {
        return especeficacao;
    }

    public void setEspeceficacao(String especeficacao) {
        this.especeficacao = especeficacao;
    }

    public String getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(String condicoes) {
        this.condicoes = condicoes;
    }

    public Date getDtfabricacao() {
        return dtfabricacao;
    }

    public void setDtfabricacao(Date dtfabricacao) {
        this.dtfabricacao = dtfabricacao;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public Date getValidadecert() {
        return validadecert;
    }

    public void setValidadecert(Date validadecert) {
        this.validadecert = validadecert;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public TipoEmbalagem getTipoEmbalagemidTipoEmbalagem() {
        return tipoEmbalagemidTipoEmbalagem;
    }

    public void setTipoEmbalagemidTipoEmbalagem(TipoEmbalagem tipoEmbalagemidTipoEmbalagem) {
        this.tipoEmbalagemidTipoEmbalagem = tipoEmbalagemidTipoEmbalagem;
    }

    public Material getMaterialidMaterial() {
        return materialidMaterial;
    }

    public void setMaterialidMaterial(Material materialidMaterial) {
        this.materialidMaterial = materialidMaterial;
    }

    public Grupoembalagem getGrupoembalagemidGrupoembalagem() {
        return grupoembalagemidGrupoembalagem;
    }

    public void setGrupoembalagemidGrupoembalagem(Grupoembalagem grupoembalagemidGrupoembalagem) {
        this.grupoembalagemidGrupoembalagem = grupoembalagemidGrupoembalagem;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @XmlTransient
    public Collection<DetalheNota> getDetalheNotaCollection() {
        return detalheNotaCollection;
    }

    public void setDetalheNotaCollection(Collection<DetalheNota> detalheNotaCollection) {
        this.detalheNotaCollection = detalheNotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmbalgem != null ? idEmbalgem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Embalagem)) {
            return false;
        }
        Embalagem other = (Embalagem) object;
        if ((this.idEmbalgem == null && other.idEmbalgem != null) || (this.idEmbalgem != null && !this.idEmbalgem.equals(other.idEmbalgem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Embalagem[ idEmbalgem=" + idEmbalgem + " ]";
    }

}
