/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tecnico Superior
 */
@Embeddable
public class ReservaTiposervicioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "reserva_idreserva")
    private int reservaIdreserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoServicio_idtipoServicio")
    private int tipoServicioidtipoServicio;

    public ReservaTiposervicioPK() {
    }

    public ReservaTiposervicioPK(int reservaIdreserva, int tipoServicioidtipoServicio) {
        this.reservaIdreserva = reservaIdreserva;
        this.tipoServicioidtipoServicio = tipoServicioidtipoServicio;
    }

    public int getReservaIdreserva() {
        return reservaIdreserva;
    }

    public void setReservaIdreserva(int reservaIdreserva) {
        this.reservaIdreserva = reservaIdreserva;
    }

    public int getTipoServicioidtipoServicio() {
        return tipoServicioidtipoServicio;
    }

    public void setTipoServicioidtipoServicio(int tipoServicioidtipoServicio) {
        this.tipoServicioidtipoServicio = tipoServicioidtipoServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reservaIdreserva;
        hash += (int) tipoServicioidtipoServicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaTiposervicioPK)) {
            return false;
        }
        ReservaTiposervicioPK other = (ReservaTiposervicioPK) object;
        if (this.reservaIdreserva != other.reservaIdreserva) {
            return false;
        }
        if (this.tipoServicioidtipoServicio != other.tipoServicioidtipoServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReservaTiposervicioPK[ reservaIdreserva=" + reservaIdreserva + ", tipoServicioidtipoServicio=" + tipoServicioidtipoServicio + " ]";
    }
    
}
