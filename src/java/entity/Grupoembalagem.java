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
@Table(name = "grupoembalagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoembalagem.findAll", query = "SELECT g FROM Grupoembalagem g"),
    @NamedQuery(name = "Grupoembalagem.findByIdGrupoembalagem", query = "SELECT g FROM Grupoembalagem g WHERE g.idGrupoembalagem = :idGrupoembalagem"),
    @NamedQuery(name = "Grupoembalagem.findByGrupo", query = "SELECT g FROM Grupoembalagem g WHERE g.grupo = :grupo"),
    @NamedQuery(name = "Grupoembalagem.findByRisco", query = "SELECT g FROM Grupoembalagem g WHERE g.risco = :risco")})
public class Grupoembalagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupoembalagem")
    private Integer idGrupoembalagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "grupo")
    private String grupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "risco")
    private String risco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoembalagemidGrupoembalagem")
    private Collection<Embalagem> embalagemCollection;

    public Grupoembalagem() {
    }

    public Grupoembalagem(Integer idGrupoembalagem) {
        this.idGrupoembalagem = idGrupoembalagem;
    }

    public Grupoembalagem(Integer idGrupoembalagem, String grupo, String risco) {
        this.idGrupoembalagem = idGrupoembalagem;
        this.grupo = grupo;
        this.risco = risco;
    }

    public Integer getIdGrupoembalagem() {
        return idGrupoembalagem;
    }

    public void setIdGrupoembalagem(Integer idGrupoembalagem) {
        this.idGrupoembalagem = idGrupoembalagem;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoembalagem != null ? idGrupoembalagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoembalagem)) {
            return false;
        }
        Grupoembalagem other = (Grupoembalagem) object;
        if ((this.idGrupoembalagem == null && other.idGrupoembalagem != null) || (this.idGrupoembalagem != null && !this.idGrupoembalagem.equals(other.idGrupoembalagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Grupoembalagem[ idGrupoembalagem=" + idGrupoembalagem + " ]";
    }

}
