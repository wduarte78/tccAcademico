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
@Table(name = "status_armazem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusArmazem.findAll", query = "SELECT s FROM StatusArmazem s"),
    @NamedQuery(name = "StatusArmazem.findByIdStatusArmazem", query = "SELECT s FROM StatusArmazem s WHERE s.idStatusArmazem = :idStatusArmazem"),
    @NamedQuery(name = "StatusArmazem.findByStatusArmazem", query = "SELECT s FROM StatusArmazem s WHERE s.statusArmazem = :statusArmazem"),
    @NamedQuery(name = "StatusArmazem.findByDescricao", query = "SELECT s FROM StatusArmazem s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "StatusArmazem.findByTipoCompatibilidadeidTipoCompatibilidade", query = "SELECT s FROM StatusArmazem s WHERE s.tipoCompatibilidadeidTipoCompatibilidade = :tipoCompatibilidadeidTipoCompatibilidade")})
public class StatusArmazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status_armazem")
    private Integer idStatusArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status_armazem")
    private String statusArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_compatibilidadeid_tipo_compatibilidade")
    private int tipoCompatibilidadeidTipoCompatibilidade;
    @JoinColumn(name = "movimentacaoid_movimentacao", referencedColumnName = "id_movimentacao")
    @ManyToOne(optional = false)
    private Movimentacao movimentacaoidMovimentacao;
    @JoinColumn(name = "armazemid_armazem", referencedColumnName = "id_armazem")
    @ManyToOne(optional = false)
    private Armazem armazemidArmazem;

    public StatusArmazem() {
    }

    public StatusArmazem(Integer idStatusArmazem) {
        this.idStatusArmazem = idStatusArmazem;
    }

    public StatusArmazem(Integer idStatusArmazem, String statusArmazem, String descricao, int tipoCompatibilidadeidTipoCompatibilidade) {
        this.idStatusArmazem = idStatusArmazem;
        this.statusArmazem = statusArmazem;
        this.descricao = descricao;
        this.tipoCompatibilidadeidTipoCompatibilidade = tipoCompatibilidadeidTipoCompatibilidade;
    }

    public Integer getIdStatusArmazem() {
        return idStatusArmazem;
    }

    public void setIdStatusArmazem(Integer idStatusArmazem) {
        this.idStatusArmazem = idStatusArmazem;
    }

    public String getStatusArmazem() {
        return statusArmazem;
    }

    public void setStatusArmazem(String statusArmazem) {
        this.statusArmazem = statusArmazem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipoCompatibilidadeidTipoCompatibilidade() {
        return tipoCompatibilidadeidTipoCompatibilidade;
    }

    public void setTipoCompatibilidadeidTipoCompatibilidade(int tipoCompatibilidadeidTipoCompatibilidade) {
        this.tipoCompatibilidadeidTipoCompatibilidade = tipoCompatibilidadeidTipoCompatibilidade;
    }

    public Movimentacao getMovimentacaoidMovimentacao() {
        return movimentacaoidMovimentacao;
    }

    public void setMovimentacaoidMovimentacao(Movimentacao movimentacaoidMovimentacao) {
        this.movimentacaoidMovimentacao = movimentacaoidMovimentacao;
    }

    public Armazem getArmazemidArmazem() {
        return armazemidArmazem;
    }

    public void setArmazemidArmazem(Armazem armazemidArmazem) {
        this.armazemidArmazem = armazemidArmazem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusArmazem != null ? idStatusArmazem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusArmazem)) {
            return false;
        }
        StatusArmazem other = (StatusArmazem) object;
        if ((this.idStatusArmazem == null && other.idStatusArmazem != null) || (this.idStatusArmazem != null && !this.idStatusArmazem.equals(other.idStatusArmazem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StatusArmazem[ idStatusArmazem=" + idStatusArmazem + " ]";
    }

}
