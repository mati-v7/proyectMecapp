/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aida
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "proyectMecappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
        
    }
    
    public List<Persona> findForCedula (Persona p){
        return em.createQuery("SELECT p FROM Persona p WHERE p.cedPersona = :cedPersona").setParameter("cedPersona", p.getCedPersona()).getResultList();          
    }
     
}
