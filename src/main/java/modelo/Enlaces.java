/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
 * @author David Rebato
 */
@Entity
@Table(name = "enlaces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enlaces.findAll", query = "SELECT e FROM Enlaces e"),
    @NamedQuery(name = "Enlaces.findById", query = "SELECT e FROM Enlaces e WHERE e.id = :id"),
    @NamedQuery(name = "Enlaces.findByNombre", query = "SELECT e FROM Enlaces e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Enlaces.findByLink", query = "SELECT e FROM Enlaces e WHERE e.link = :link"),
    @NamedQuery(name = "Enlaces.findByTipo", query = "SELECT e FROM Enlaces e WHERE e.tipo = :tipo")})
public class Enlaces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tipo")
    private String tipo;

    public Enlaces() {
    }

    public Enlaces(Integer id) {
        this.id = id;
    }

    public Enlaces(Integer id, String nombre, String link, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enlaces)) {
            return false;
        }
        Enlaces other = (Enlaces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Enlaces[ id=" + id + " ]";
    }
    
}
