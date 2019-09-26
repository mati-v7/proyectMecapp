/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tecnico Superior
 */
@Entity
@Table(name = "insumos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i")
    , @NamedQuery(name = "Insumos.findByIdinsumos", query = "SELECT i FROM Insumos i WHERE i.idinsumos = :idinsumos")
    , @NamedQuery(name = "Insumos.findByInsumo", query = "SELECT i FROM Insumos i WHERE i.insumo = :insumo")
    , @NamedQuery(name = "Insumos.findByPrecioInsumo", query = "SELECT i FROM Insumos i WHERE i.precioInsumo = :precioInsumo")
    , @NamedQuery(name = "Insumos.findByDescripcion", query = "SELECT i FROM Insumos i WHERE i.descripcion = :descripcion")})
public class Insumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinsumos")
    private Integer idinsumos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "insumo")
    private String insumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_insumo")
    private int precioInsumo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "manoDeObra_idmanoDeObra", referencedColumnName = "idmanoDeObra")
    @ManyToOne(optional = false)
    private Manodeobra manoDeObraidmanoDeObra;

    public Insumos() {
    }

    public Insumos(Integer idinsumos) {
        this.idinsumos = idinsumos;
    }

    public Insumos(Integer idinsumos, String insumo, int precioInsumo) {
        this.idinsumos = idinsumos;
        this.insumo = insumo;
        this.precioInsumo = precioInsumo;
    }

    public Integer getIdinsumos() {
        return idinsumos;
    }

    public void setIdinsumos(Integer idinsumos) {
        this.idinsumos = idinsumos;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public int getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(int precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Manodeobra getManoDeObraidmanoDeObra() {
        return manoDeObraidmanoDeObra;
    }

    public void setManoDeObraidmanoDeObra(Manodeobra manoDeObraidmanoDeObra) {
        this.manoDeObraidmanoDeObra = manoDeObraidmanoDeObra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinsumos != null ? idinsumos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.idinsumos == null && other.idinsumos != null) || (this.idinsumos != null && !this.idinsumos.equals(other.idinsumos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Insumos[ idinsumos=" + idinsumos + " ]";
    }
    
}
