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
 * @author Tecnico Superior
 */
@Entity
@Table(name = "modelovehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelovehiculo.findAll", query = "SELECT m FROM Modelovehiculo m")
    , @NamedQuery(name = "Modelovehiculo.findByIdmodeloVehiculo", query = "SELECT m FROM Modelovehiculo m WHERE m.idmodeloVehiculo = :idmodeloVehiculo")
    , @NamedQuery(name = "Modelovehiculo.findByModeloVehiculo", query = "SELECT m FROM Modelovehiculo m WHERE m.modeloVehiculo = :modeloVehiculo")
    , @NamedQuery(name = "Modelovehiculo.findByDescripcion", query = "SELECT m FROM Modelovehiculo m WHERE m.descripcion = :descripcion")})
public class Modelovehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodeloVehiculo")
    private Integer idmodeloVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "modeloVehiculo")
    private String modeloVehiculo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloVehiculoidmodeloVehiculo")
    private Collection<Vehiculo> vehiculoCollection;
    @JoinColumn(name = "marcaVehiculo_idmarcaVehiculo", referencedColumnName = "idmarcaVehiculo")
    @ManyToOne(optional = false)
    private Marcavehiculo marcaVehiculoidmarcaVehiculo;

    public Modelovehiculo() {
    }

    public Modelovehiculo(Integer idmodeloVehiculo) {
        this.idmodeloVehiculo = idmodeloVehiculo;
    }

    public Modelovehiculo(Integer idmodeloVehiculo, String modeloVehiculo) {
        this.idmodeloVehiculo = idmodeloVehiculo;
        this.modeloVehiculo = modeloVehiculo;
    }

    public Integer getIdmodeloVehiculo() {
        return idmodeloVehiculo;
    }

    public void setIdmodeloVehiculo(Integer idmodeloVehiculo) {
        this.idmodeloVehiculo = idmodeloVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    public Marcavehiculo getMarcaVehiculoidmarcaVehiculo() {
        return marcaVehiculoidmarcaVehiculo;
    }

    public void setMarcaVehiculoidmarcaVehiculo(Marcavehiculo marcaVehiculoidmarcaVehiculo) {
        this.marcaVehiculoidmarcaVehiculo = marcaVehiculoidmarcaVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodeloVehiculo != null ? idmodeloVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelovehiculo)) {
            return false;
        }
        Modelovehiculo other = (Modelovehiculo) object;
        if ((this.idmodeloVehiculo == null && other.idmodeloVehiculo != null) || (this.idmodeloVehiculo != null && !this.idmodeloVehiculo.equals(other.idmodeloVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Modelovehiculo[ idmodeloVehiculo=" + idmodeloVehiculo + " ]";
    }
    
}
