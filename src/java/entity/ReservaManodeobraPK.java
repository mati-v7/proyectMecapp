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
public class ReservaManodeobraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "reserva_idreserva")
    private int reservaIdreserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manoDeObra_idmanoDeObra")
    private int manoDeObraidmanoDeObra;

    public ReservaManodeobraPK() {
    }

    public ReservaManodeobraPK(int reservaIdreserva, int manoDeObraidmanoDeObra) {
        this.reservaIdreserva = reservaIdreserva;
        this.manoDeObraidmanoDeObra = manoDeObraidmanoDeObra;
    }

    public int getReservaIdreserva() {
        return reservaIdreserva;
    }

    public void setReservaIdreserva(int reservaIdreserva) {
        this.reservaIdreserva = reservaIdreserva;
    }

    public int getManoDeObraidmanoDeObra() {
        return manoDeObraidmanoDeObra;
    }

    public void setManoDeObraidmanoDeObra(int manoDeObraidmanoDeObra) {
        this.manoDeObraidmanoDeObra = manoDeObraidmanoDeObra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reservaIdreserva;
        hash += (int) manoDeObraidmanoDeObra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaManodeobraPK)) {
            return false;
        }
        ReservaManodeobraPK other = (ReservaManodeobraPK) object;
        if (this.reservaIdreserva != other.reservaIdreserva) {
            return false;
        }
        if (this.manoDeObraidmanoDeObra != other.manoDeObraidmanoDeObra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReservaManodeobraPK[ reservaIdreserva=" + reservaIdreserva + ", manoDeObraidmanoDeObra=" + manoDeObraidmanoDeObra + " ]";
    }
    
}
