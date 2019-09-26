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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIdvehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idvehiculo = :idvehiculo")
    , @NamedQuery(name = "Vehiculo.findByChasisVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.chasisVehiculo = :chasisVehiculo")
    , @NamedQuery(name = "Vehiculo.findByChapaVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.chapaVehiculo = :chapaVehiculo")
    , @NamedQuery(name = "Vehiculo.findByAnhoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.anhoVehiculo = :anhoVehiculo")
    , @NamedQuery(name = "Vehiculo.findByKmVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.kmVehiculo = :kmVehiculo")
    , @NamedQuery(name = "Vehiculo.findByColorVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.colorVehiculo = :colorVehiculo")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvehiculo")
    private Integer idvehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "chasis_vehiculo")
    private String chasisVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "chapa_vehiculo")
    private String chapaVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "anho_vehiculo")
    private String anhoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "km_vehiculo")
    private int kmVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "color_vehiculo")
    private String colorVehiculo;
    @JoinColumn(name = "modeloVehiculo_idmodeloVehiculo", referencedColumnName = "idmodeloVehiculo")
    @ManyToOne(optional = false)
    private Modelovehiculo modeloVehiculoidmodeloVehiculo;
    @JoinColumn(name = "persona_idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona personaIdpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdvehiculo")
    private Collection<Reserva> reservaCollection;

    public Vehiculo() {
    }

    public Vehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Vehiculo(Integer idvehiculo, String chasisVehiculo, String chapaVehiculo, String anhoVehiculo, int kmVehiculo, String colorVehiculo) {
        this.idvehiculo = idvehiculo;
        this.chasisVehiculo = chasisVehiculo;
        this.chapaVehiculo = chapaVehiculo;
        this.anhoVehiculo = anhoVehiculo;
        this.kmVehiculo = kmVehiculo;
        this.colorVehiculo = colorVehiculo;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getChasisVehiculo() {
        return chasisVehiculo;
    }

    public void setChasisVehiculo(String chasisVehiculo) {
        this.chasisVehiculo = chasisVehiculo;
    }

    public String getChapaVehiculo() {
        return chapaVehiculo;
    }

    public void setChapaVehiculo(String chapaVehiculo) {
        this.chapaVehiculo = chapaVehiculo;
    }

    public String getAnhoVehiculo() {
        return anhoVehiculo;
    }

    public void setAnhoVehiculo(String anhoVehiculo) {
        this.anhoVehiculo = anhoVehiculo;
    }

    public int getKmVehiculo() {
        return kmVehiculo;
    }

    public void setKmVehiculo(int kmVehiculo) {
        this.kmVehiculo = kmVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public Modelovehiculo getModeloVehiculoidmodeloVehiculo() {
        return modeloVehiculoidmodeloVehiculo;
    }

    public void setModeloVehiculoidmodeloVehiculo(Modelovehiculo modeloVehiculoidmodeloVehiculo) {
        this.modeloVehiculoidmodeloVehiculo = modeloVehiculoidmodeloVehiculo;
    }

    public Persona getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(Persona personaIdpersona) {
        this.personaIdpersona = personaIdpersona;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehiculo != null ? idvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idvehiculo == null && other.idvehiculo != null) || (this.idvehiculo != null && !this.idvehiculo.equals(other.idvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vehiculo[ idvehiculo=" + idvehiculo + " ]";
    }
    
}
