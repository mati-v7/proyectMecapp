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
@Table(name = "manodeobra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manodeobra.findAll", query = "SELECT m FROM Manodeobra m")
    , @NamedQuery(name = "Manodeobra.findByIdmanoDeObra", query = "SELECT m FROM Manodeobra m WHERE m.idmanoDeObra = :idmanoDeObra")
    , @NamedQuery(name = "Manodeobra.findByManoDeObra", query = "SELECT m FROM Manodeobra m WHERE m.manoDeObra = :manoDeObra")
    , @NamedQuery(name = "Manodeobra.findByPreciomanoDeObra", query = "SELECT m FROM Manodeobra m WHERE m.preciomanoDeObra = :preciomanoDeObra")
    , @NamedQuery(name = "Manodeobra.findByDescripcion", query = "SELECT m FROM Manodeobra m WHERE m.descripcion = :descripcion")})
public class Manodeobra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmanoDeObra")
    private Integer idmanoDeObra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "manoDeObra")
    private String manoDeObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_manoDeObra")
    private int preciomanoDeObra;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manoDeObraidmanoDeObra")
    private Collection<Insumos> insumosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manodeobra")
    private Collection<ReservaManodeobra> reservaManodeobraCollection;

    public Manodeobra() {
    }

    public Manodeobra(Integer idmanoDeObra) {
        this.idmanoDeObra = idmanoDeObra;
    }

    public Manodeobra(Integer idmanoDeObra, String manoDeObra, int preciomanoDeObra) {
        this.idmanoDeObra = idmanoDeObra;
        this.manoDeObra = manoDeObra;
        this.preciomanoDeObra = preciomanoDeObra;
    }

    public Integer getIdmanoDeObra() {
        return idmanoDeObra;
    }

    public void setIdmanoDeObra(Integer idmanoDeObra) {
        this.idmanoDeObra = idmanoDeObra;
    }

    public String getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(String manoDeObra) {
        this.manoDeObra = manoDeObra;
    }

    public int getPreciomanoDeObra() {
        return preciomanoDeObra;
    }

    public void setPreciomanoDeObra(int preciomanoDeObra) {
        this.preciomanoDeObra = preciomanoDeObra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Insumos> getInsumosCollection() {
        return insumosCollection;
    }

    public void setInsumosCollection(Collection<Insumos> insumosCollection) {
        this.insumosCollection = insumosCollection;
    }

    @XmlTransient
    public Collection<ReservaManodeobra> getReservaManodeobraCollection() {
        return reservaManodeobraCollection;
    }

    public void setReservaManodeobraCollection(Collection<ReservaManodeobra> reservaManodeobraCollection) {
        this.reservaManodeobraCollection = reservaManodeobraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmanoDeObra != null ? idmanoDeObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manodeobra)) {
            return false;
        }
        Manodeobra other = (Manodeobra) object;
        if ((this.idmanoDeObra == null && other.idmanoDeObra != null) || (this.idmanoDeObra != null && !this.idmanoDeObra.equals(other.idmanoDeObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Manodeobra[ idmanoDeObra=" + idmanoDeObra + " ]";
    }
    
}
