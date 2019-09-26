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
 * @author Tecnico Superior
 */
@Entity
@Table(name = "tiposervicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposervicio.findAll", query = "SELECT t FROM Tiposervicio t")
    , @NamedQuery(name = "Tiposervicio.findByIdtipoServicio", query = "SELECT t FROM Tiposervicio t WHERE t.idtipoServicio = :idtipoServicio")
    , @NamedQuery(name = "Tiposervicio.findByTipoServicio", query = "SELECT t FROM Tiposervicio t WHERE t.tipoServicio = :tipoServicio")
    , @NamedQuery(name = "Tiposervicio.findByDescripcion", query = "SELECT t FROM Tiposervicio t WHERE t.descripcion = :descripcion")})
public class Tiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoServicio")
    private Integer idtipoServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipoServicio")
    private String tipoServicio;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposervicio")
    private Collection<ReservaTiposervicio> reservaTiposervicioCollection;

    public Tiposervicio() {
    }

    public Tiposervicio(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public Tiposervicio(Integer idtipoServicio, String tipoServicio) {
        this.idtipoServicio = idtipoServicio;
        this.tipoServicio = tipoServicio;
    }

    public Integer getIdtipoServicio() {
        return idtipoServicio;
    }

    public void setIdtipoServicio(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ReservaTiposervicio> getReservaTiposervicioCollection() {
        return reservaTiposervicioCollection;
    }

    public void setReservaTiposervicioCollection(Collection<ReservaTiposervicio> reservaTiposervicioCollection) {
        this.reservaTiposervicioCollection = reservaTiposervicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoServicio != null ? idtipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposervicio)) {
            return false;
        }
        Tiposervicio other = (Tiposervicio) object;
        if ((this.idtipoServicio == null && other.idtipoServicio != null) || (this.idtipoServicio != null && !this.idtipoServicio.equals(other.idtipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tiposervicio[ idtipoServicio=" + idtipoServicio + " ]";
    }
    
}
