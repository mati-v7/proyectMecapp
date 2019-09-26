/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tecnico Superior
 */
@Entity
@Table(name = "reserva_tiposervicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaTiposervicio.findAll", query = "SELECT r FROM ReservaTiposervicio r")
    , @NamedQuery(name = "ReservaTiposervicio.findByReservaIdreserva", query = "SELECT r FROM ReservaTiposervicio r WHERE r.reservaTiposervicioPK.reservaIdreserva = :reservaIdreserva")
    , @NamedQuery(name = "ReservaTiposervicio.findByTipoServicioidtipoServicio", query = "SELECT r FROM ReservaTiposervicio r WHERE r.reservaTiposervicioPK.tipoServicioidtipoServicio = :tipoServicioidtipoServicio")
    , @NamedQuery(name = "ReservaTiposervicio.findByDescripcion", query = "SELECT r FROM ReservaTiposervicio r WHERE r.descripcion = :descripcion")})
public class ReservaTiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaTiposervicioPK reservaTiposervicioPK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "reserva_idreserva", referencedColumnName = "idreserva", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;
    @JoinColumn(name = "tipoServicio_idtipoServicio", referencedColumnName = "idtipoServicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tiposervicio tiposervicio;

    public ReservaTiposervicio() {
    }

    public ReservaTiposervicio(ReservaTiposervicioPK reservaTiposervicioPK) {
        this.reservaTiposervicioPK = reservaTiposervicioPK;
    }

    public ReservaTiposervicio(int reservaIdreserva, int tipoServicioidtipoServicio) {
        this.reservaTiposervicioPK = new ReservaTiposervicioPK(reservaIdreserva, tipoServicioidtipoServicio);
    }

    public ReservaTiposervicioPK getReservaTiposervicioPK() {
        return reservaTiposervicioPK;
    }

    public void setReservaTiposervicioPK(ReservaTiposervicioPK reservaTiposervicioPK) {
        this.reservaTiposervicioPK = reservaTiposervicioPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Tiposervicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(Tiposervicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaTiposervicioPK != null ? reservaTiposervicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaTiposervicio)) {
            return false;
        }
        ReservaTiposervicio other = (ReservaTiposervicio) object;
        if ((this.reservaTiposervicioPK == null && other.reservaTiposervicioPK != null) || (this.reservaTiposervicioPK != null && !this.reservaTiposervicioPK.equals(other.reservaTiposervicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReservaTiposervicio[ reservaTiposervicioPK=" + reservaTiposervicioPK + " ]";
    }
    
}
