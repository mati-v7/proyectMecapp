/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Persona;
import entity.Usuario;
import entity.Usuario_;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "proyectMecappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> getUserForIdPersona(Persona p){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> user = cq.from(Usuario.class);
        cq.select(user);
        cq.where(user.get(Usuario_.personaIdpersona).in(p.getIdpersona()));
        TypedQuery <Usuario> tq = em.createQuery(cq);
        return  tq.getResultList();
    }
}
