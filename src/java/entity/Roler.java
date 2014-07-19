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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "roler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roler.findAll", query = "SELECT r FROM Roler r"),
    @NamedQuery(name = "Roler.findByIdRole", query = "SELECT r FROM Roler r WHERE r.idRole = :idRole"),
    @NamedQuery(name = "Roler.findByNomerole", query = "SELECT r FROM Roler r WHERE r.nomerole = :nomerole")})
public class Roler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_role")
    private Integer idRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nomerole")
    private String nomerole;
    @JoinTable(name = "user_rolers", joinColumns = {
        @JoinColumn(name = "id_role", referencedColumnName = "id_role")}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @OneToMany(mappedBy = "idRole")
    private Collection<Funcionario> funcionarioCollection;

    public Roler() {
    }

    public Roler(Integer idRole) {
        this.idRole = idRole;
    }

    public Roler(Integer idRole, String nomerole) {
        this.idRole = idRole;
        this.nomerole = nomerole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNomerole() {
        return nomerole;
    }

    public void setNomerole(String nomerole) {
        this.nomerole = nomerole;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roler)) {
            return false;
        }
        Roler other = (Roler) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roler[ idRole=" + idRole + " ]";
    }

}
