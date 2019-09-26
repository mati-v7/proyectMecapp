/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tecnico Superior
 */
@Entity
@Table(name = "reserva_manodeobra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaManodeobra.findAll", query = "SELECT r FROM ReservaManodeobra r")
    , @NamedQuery(name = "ReservaManodeobra.findByReservaIdreserva", query = "SELECT r FROM ReservaManodeobra r WHERE r.reservaManodeobraPK.reservaIdreserva = :reservaIdreserva")
    , @NamedQuery(name = "ReservaManodeobra.findByManoDeObraidmanoDeObra", query = "SELECT r FROM ReservaManodeobra r WHERE r.reservaManodeobraPK.manoDeObraidmanoDeObra = :manoDeObraidmanoDeObra")
    , @NamedQuery(name = "ReservaManodeobra.findByEstado", query = "SELECT r FROM ReservaManodeobra r WHERE r.estado = :estado")})
public class ReservaManodeobra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaManodeobraPK reservaManodeobraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @JoinColumn(name = "manoDeObra_idmanoDeObra", referencedColumnName = "idmanoDeObra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Manodeobra manodeobra;
    @JoinColumn(name = "reserva_idreserva", referencedColumnName = "idreserva", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;

    public ReservaManodeobra() {
    }

    public ReservaManodeobra(ReservaManodeobraPK reservaManodeobraPK) {
        this.reservaManodeobraPK = reservaManodeobraPK;
    }

    public ReservaManodeobra(ReservaManodeobraPK reservaManodeobraPK, short estado) {
        this.reservaManodeobraPK = reservaManodeobraPK;
        this.estado = estado;
    }

    public ReservaManodeobra(int reservaIdreserva, int manoDeObraidmanoDeObra) {
        this.reservaManodeobraPK = new ReservaManodeobraPK(reservaIdreserva, manoDeObraidmanoDeObra);
    }

    public ReservaManodeobraPK getReservaManodeobraPK() {
        return reservaManodeobraPK;
    }

    public void setReservaManodeobraPK(ReservaManodeobraPK reservaManodeobraPK) {
        this.reservaManodeobraPK = reservaManodeobraPK;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Manodeobra getManodeobra() {
        return manodeobra;
    }

    public void setManodeobra(Manodeobra manodeobra) {
        this.manodeobra = manodeobra;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaManodeobraPK != null ? reservaManodeobraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaManodeobra)) {
            return false;
        }
        ReservaManodeobra other = (ReservaManodeobra) object;
        if ((this.reservaManodeobraPK == null && other.reservaManodeobraPK != null) || (this.reservaManodeobraPK != null && !this.reservaManodeobraPK.equals(other.reservaManodeobraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReservaManodeobra[ reservaManodeobraPK=" + reservaManodeobraPK + " ]";
    }
    
}
