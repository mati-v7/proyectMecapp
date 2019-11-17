/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Persona;
import entity.Vehiculo;
import entity.Vehiculo_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Aida
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "proyectMecappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
    public List<Vehiculo> getVehiculoForPersona(Persona p){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <Vehiculo> cq = cb.createQuery(Vehiculo.class);
        Root <Vehiculo> v = cq.from(Vehiculo.class);
        cq.select(v);
        cq.where(v.get(Vehiculo_.personaIdpersona).in(p.getIdpersona()));
        TypedQuery <Vehiculo> tq = em.createQuery(cq);
        return tq.getResultList();
    }
    
}
