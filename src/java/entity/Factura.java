/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tecnico Superior
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByFechahoraFactura", query = "SELECT f FROM Factura f WHERE f.fechahoraFactura = :fechahoraFactura")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfactura")
    private Integer idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahora_factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahoraFactura;
    @JoinColumn(name = "reserva_idreserva", referencedColumnName = "idreserva")
    @ManyToOne(optional = false)
    private Reserva reservaIdreserva;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(Integer idfactura, Date fechahoraFactura) {
        this.idfactura = idfactura;
        this.fechahoraFactura = fechahoraFactura;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFechahoraFactura() {
        return fechahoraFactura;
    }

    public void setFechahoraFactura(Date fechahoraFactura) {
        this.fechahoraFactura = fechahoraFactura;
    }

    public Reserva getReservaIdreserva() {
        return reservaIdreserva;
    }

    public void setReservaIdreserva(Reserva reservaIdreserva) {
        this.reservaIdreserva = reservaIdreserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
