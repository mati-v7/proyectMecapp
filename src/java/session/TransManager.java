/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Persona;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Windows10
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransManager {
    
    @PersistenceContext(unitName = "proyectMecappPU")
    private EntityManager em;
    
    @Resource
    private SessionContext context;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int registOrder(String nombre, String apellido, String doc, String direccion, String telefono, String email) {
        try {
            Persona p = addPersona(nombre, apellido, doc, direccion, telefono, email);
            return p.getIdpersona();
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        } 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Persona addPersona(String nombre, String apellido, String doc, String direccion, String telefono, String email) {
        Persona persona = new Persona();
        persona.setNombrePersona(nombre);
        persona.setApellidoPersona(apellido);
        persona.setCedPersona(doc);
        persona.setDireccionPersona(direccion);
        persona.setTelefonoPersona(telefono);
        persona.setEmailPersona(email);
        em.persist(persona);
        em.flush();
        return persona;
    }
}
