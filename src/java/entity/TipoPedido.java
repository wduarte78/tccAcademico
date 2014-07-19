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
@Table(name = "tipo_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPedido.findAll", query = "SELECT t FROM TipoPedido t"),
    @NamedQuery(name = "TipoPedido.findByIdTipoPedido", query = "SELECT t FROM TipoPedido t WHERE t.idTipoPedido = :idTipoPedido"),
    @NamedQuery(name = "TipoPedido.findByTipoPedido", query = "SELECT t FROM TipoPedido t WHERE t.tipoPedido = :tipoPedido"),
    @NamedQuery(name = "TipoPedido.findByEspecifTipopedido", query = "SELECT t FROM TipoPedido t WHERE t.especifTipopedido = :especifTipopedido"),
    @NamedQuery(name = "TipoPedido.findByUsuarioidUsuario", query = "SELECT t FROM TipoPedido t WHERE t.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "TipoPedido.findByNumNota", query = "SELECT t FROM TipoPedido t WHERE t.numNota = :numNota"),
    @NamedQuery(name = "TipoPedido.findBySolicitante", query = "SELECT t FROM TipoPedido t WHERE t.solicitante = :solicitante")})
public class TipoPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_pedido")
    private Integer idTipoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_pedido")
    private String tipoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especif_tipopedido")
    private String especifTipopedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioid_usuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_nota")
    private int numNota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "solicitante")
    private String solicitante;
    @OneToMany(mappedBy = "idTipoPedido")
    private Collection<TipoMovimentacao> tipoMovimentacaoCollection;
    @JoinColumn(name = "id_detalhe_nota", referencedColumnName = "id_detalhe_nota")
    @ManyToOne
    private DetalheNota idDetalheNota;
    @JoinColumn(name = "detalhe_notaid_detalhe_nota", referencedColumnName = "id_detalhe_nota")
    @ManyToOne(optional = false)
    private DetalheNota detalheNotaidDetalheNota;

    public TipoPedido() {
    }

    public TipoPedido(Integer idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public TipoPedido(Integer idTipoPedido, String tipoPedido, String especifTipopedido, int usuarioidUsuario, int numNota, String solicitante) {
        this.idTipoPedido = idTipoPedido;
        this.tipoPedido = tipoPedido;
        this.especifTipopedido = especifTipopedido;
        this.usuarioidUsuario = usuarioidUsuario;
        this.numNota = numNota;
        this.solicitante = solicitante;
    }

    public Integer getIdTipoPedido() {
        return idTipoPedido;
    }

    public void setIdTipoPedido(Integer idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getEspecifTipopedido() {
        return especifTipopedido;
    }

    public void setEspecifTipopedido(String especifTipopedido) {
        this.especifTipopedido = especifTipopedido;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getNumNota() {
        return numNota;
    }

    public void setNumNota(int numNota) {
        this.numNota = numNota;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    @XmlTransient
    public Collection<TipoMovimentacao> getTipoMovimentacaoCollection() {
        return tipoMovimentacaoCollection;
    }

    public void setTipoMovimentacaoCollection(Collection<TipoMovimentacao> tipoMovimentacaoCollection) {
        this.tipoMovimentacaoCollection = tipoMovimentacaoCollection;
    }

    public DetalheNota getIdDetalheNota() {
        return idDetalheNota;
    }

    public void setIdDetalheNota(DetalheNota idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public DetalheNota getDetalheNotaidDetalheNota() {
        return detalheNotaidDetalheNota;
    }

    public void setDetalheNotaidDetalheNota(DetalheNota detalheNotaidDetalheNota) {
        this.detalheNotaidDetalheNota = detalheNotaidDetalheNota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPedido != null ? idTipoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPedido)) {
            return false;
        }
        TipoPedido other = (TipoPedido) object;
        if ((this.idTipoPedido == null && other.idTipoPedido != null) || (this.idTipoPedido != null && !this.idTipoPedido.equals(other.idTipoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoPedido[ idTipoPedido=" + idTipoPedido + " ]";
    }

}
