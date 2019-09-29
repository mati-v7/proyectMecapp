/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Marcavehiculo;
import entity.Modelovehiculo;
import entity.Modelovehiculo_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author Aida
 */
@Stateless
public class ModelovehiculoFacade extends AbstractFacade<Modelovehiculo> {

    @PersistenceContext(unitName = "proyectMecappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModelovehiculoFacade() {
        super(Modelovehiculo.class);
    }
    
    public List<Modelovehiculo> getModeloForMarca() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <Modelovehiculo> cq = cb.createQuery(Modelovehiculo.class);
        Root <Modelovehiculo> model = cq.from(Modelovehiculo.class);
        cq.select(model);
        cq.where(model.get(Modelovehiculo_.marcaVehiculoidmarcaVehiculo).in(1));
        //Join<Modelovehiculo,Marcavehiculo> join = model.join(Modelovehiculo_.marcaVehiculoidmarcaVehiculo);
        TypedQuery <Modelovehiculo> q = em.createQuery(cq);
        return q.getResultList();
    }
    
}
