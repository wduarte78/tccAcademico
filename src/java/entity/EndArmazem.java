/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "end_armazem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EndArmazem.findAll", query = "SELECT e FROM EndArmazem e"),
    @NamedQuery(name = "EndArmazem.findByIdEnderecamento", query = "SELECT e FROM EndArmazem e WHERE e.idEnderecamento = :idEnderecamento"),
    @NamedQuery(name = "EndArmazem.findByIdentificacao", query = "SELECT e FROM EndArmazem e WHERE e.identificacao = :identificacao"),
    @NamedQuery(name = "EndArmazem.findByCor", query = "SELECT e FROM EndArmazem e WHERE e.cor = :cor"),
    @NamedQuery(name = "EndArmazem.findByRuaArmazem", query = "SELECT e FROM EndArmazem e WHERE e.ruaArmazem = :ruaArmazem"),
    @NamedQuery(name = "EndArmazem.findByLado", query = "SELECT e FROM EndArmazem e WHERE e.lado = :lado"),
    @NamedQuery(name = "EndArmazem.findByNivel", query = "SELECT e FROM EndArmazem e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "EndArmazem.findByPosicao", query = "SELECT e FROM EndArmazem e WHERE e.posicao = :posicao")})
public class EndArmazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enderecamento")
    private Integer idEnderecamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "identificacao")
    private String identificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cor")
    private String cor;
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
    @OneToMany(mappedBy = "idEndereco")
    private Collection<Armazem> armazemCollection;

    public EndArmazem() {
    }

    public EndArmazem(Integer idEnderecamento) {
        this.idEnderecamento = idEnderecamento;
    }

    public EndArmazem(Integer idEnderecamento, String identificacao, String cor, String ruaArmazem, String lado, String nivel, String posicao) {
        this.idEnderecamento = idEnderecamento;
        this.identificacao = identificacao;
        this.cor = cor;
        this.ruaArmazem = ruaArmazem;
        this.lado = lado;
        this.nivel = nivel;
        this.posicao = posicao;
    }

    public Integer getIdEnderecamento() {
        return idEnderecamento;
    }

    public void setIdEnderecamento(Integer idEnderecamento) {
        this.idEnderecamento = idEnderecamento;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
        hash += (idEnderecamento != null ? idEnderecamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EndArmazem)) {
            return false;
        }
        EndArmazem other = (EndArmazem) object;
        if ((this.idEnderecamento == null && other.idEnderecamento != null) || (this.idEnderecamento != null && !this.idEnderecamento.equals(other.idEnderecamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EndArmazem[ idEnderecamento=" + idEnderecamento + " ]";
    }

}
