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
@Table(name = "marcavehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcavehiculo.findAll", query = "SELECT m FROM Marcavehiculo m")
    , @NamedQuery(name = "Marcavehiculo.findByIdmarcaVehiculo", query = "SELECT m FROM Marcavehiculo m WHERE m.idmarcaVehiculo = :idmarcaVehiculo")
    , @NamedQuery(name = "Marcavehiculo.findByMarcaVehiculo", query = "SELECT m FROM Marcavehiculo m WHERE m.marcaVehiculo = :marcaVehiculo")
    , @NamedQuery(name = "Marcavehiculo.findByDescripcion", query = "SELECT m FROM Marcavehiculo m WHERE m.descripcion = :descripcion")})
public class Marcavehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmarcaVehiculo")
    private Integer idmarcaVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "marcaVehiculo")
    private String marcaVehiculo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaVehiculoidmarcaVehiculo")
    private Collection<Modelovehiculo> modelovehiculoCollection;

    public Marcavehiculo() {
    }

    public Marcavehiculo(Integer idmarcaVehiculo) {
        this.idmarcaVehiculo = idmarcaVehiculo;
    }

    public Marcavehiculo(Integer idmarcaVehiculo, String marcaVehiculo) {
        this.idmarcaVehiculo = idmarcaVehiculo;
        this.marcaVehiculo = marcaVehiculo;
    }

    public Integer getIdmarcaVehiculo() {
        return idmarcaVehiculo;
    }

    public void setIdmarcaVehiculo(Integer idmarcaVehiculo) {
        this.idmarcaVehiculo = idmarcaVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Modelovehiculo> getModelovehiculoCollection() {
        return modelovehiculoCollection;
    }

    public void setModelovehiculoCollection(Collection<Modelovehiculo> modelovehiculoCollection) {
        this.modelovehiculoCollection = modelovehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarcaVehiculo != null ? idmarcaVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcavehiculo)) {
            return false;
        }
        Marcavehiculo other = (Marcavehiculo) object;
        if ((this.idmarcaVehiculo == null && other.idmarcaVehiculo != null) || (this.idmarcaVehiculo != null && !this.idmarcaVehiculo.equals(other.idmarcaVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Marcavehiculo[ idmarcaVehiculo=" + idmarcaVehiculo + " ]";
    }
    
}
