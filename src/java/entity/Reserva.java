/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tecnico Superior
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva")
    , @NamedQuery(name = "Reserva.findByFechahoraReserva", query = "SELECT r FROM Reserva r WHERE r.fechahoraReserva = :fechahoraReserva")
    , @NamedQuery(name = "Reserva.findByEstadoReserva", query = "SELECT r FROM Reserva r WHERE r.estadoReserva = :estadoReserva")
    , @NamedQuery(name = "Reserva.findByCreadoReserva", query = "SELECT r FROM Reserva r WHERE r.creadoReserva = :creadoReserva")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreserva")
    private Integer idreserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahora_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahoraReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reserva")
    private short estadoReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creado_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoReserva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<ReservaManodeobra> reservaManodeobraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaIdreserva")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<ReservaTiposervicio> reservaTiposervicioCollection;
    @JoinColumn(name = "cliente_idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona clienteIdpersona;
    @JoinColumn(name = "empleado_idpersona1", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona empleadoIdpersona1;
    @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdvehiculo;
    

    public Reserva() {
    }

    public Reserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Reserva(Integer idreserva, Date fechahoraReserva, short estadoReserva, Date creadoReserva) {
        this.idreserva = idreserva;
        this.fechahoraReserva = fechahoraReserva;
        this.estadoReserva = estadoReserva;
        this.creadoReserva = creadoReserva;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechahoraReserva() {
        return fechahoraReserva;
    }

    public void setFechahoraReserva(Date fechahoraReserva) {
        this.fechahoraReserva = fechahoraReserva;
    }

    public short getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(short estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Date getCreadoReserva() {
        return creadoReserva;
    }

    public void setCreadoReserva(Date creadoReserva) {
        this.creadoReserva = creadoReserva;
    }

    @XmlTransient
    public Collection<ReservaManodeobra> getReservaManodeobraCollection() {
        return reservaManodeobraCollection;
    }

    public void setReservaManodeobraCollection(Collection<ReservaManodeobra> reservaManodeobraCollection) {
        this.reservaManodeobraCollection = reservaManodeobraCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<ReservaTiposervicio> getReservaTiposervicioCollection() {
        return reservaTiposervicioCollection;
    }

    public void setReservaTiposervicioCollection(Collection<ReservaTiposervicio> reservaTiposervicioCollection) {
        this.reservaTiposervicioCollection = reservaTiposervicioCollection;
    }

    public Persona getClienteIdpersona() {
        return clienteIdpersona;
    }

    public void setClienteIdpersona(Persona clienteIdpersona) {
        this.clienteIdpersona = clienteIdpersona;
    }

    public Persona getEmpleadoIdpersona1() {
        return empleadoIdpersona1;
    }

    public void setEmpleadoIdpersona1(Persona empleadoIdpersona1) {
        this.empleadoIdpersona1 = empleadoIdpersona1;
    }

    public Vehiculo getVehiculoIdvehiculo() {
        return vehiculoIdvehiculo;
    }

    public void setVehiculoIdvehiculo(Vehiculo vehiculoIdvehiculo) {
        this.vehiculoIdvehiculo = vehiculoIdvehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
