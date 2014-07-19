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
@Table(name = "espcif_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspcifPedido.findAll", query = "SELECT e FROM EspcifPedido e"),
    @NamedQuery(name = "EspcifPedido.findByIdEspecPedido", query = "SELECT e FROM EspcifPedido e WHERE e.idEspecPedido = :idEspecPedido"),
    @NamedQuery(name = "EspcifPedido.findByEspecPedido", query = "SELECT e FROM EspcifPedido e WHERE e.especPedido = :especPedido")})
public class EspcifPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_espec_pedido")
    private Integer idEspecPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "espec_pedido")
    private String especPedido;

    public EspcifPedido() {
    }

    public EspcifPedido(Integer idEspecPedido) {
        this.idEspecPedido = idEspecPedido;
    }

    public EspcifPedido(Integer idEspecPedido, String especPedido) {
        this.idEspecPedido = idEspecPedido;
        this.especPedido = especPedido;
    }

    public Integer getIdEspecPedido() {
        return idEspecPedido;
    }

    public void setIdEspecPedido(Integer idEspecPedido) {
        this.idEspecPedido = idEspecPedido;
    }

    public String getEspecPedido() {
        return especPedido;
    }

    public void setEspecPedido(String especPedido) {
        this.especPedido = especPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecPedido != null ? idEspecPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspcifPedido)) {
            return false;
        }
        EspcifPedido other = (EspcifPedido) object;
        if ((this.idEspecPedido == null && other.idEspecPedido != null) || (this.idEspecPedido != null && !this.idEspecPedido.equals(other.idEspecPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EspcifPedido[ idEspecPedido=" + idEspecPedido + " ]";
    }

}
