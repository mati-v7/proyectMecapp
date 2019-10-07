/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Persona;
import entity.Tipousuario;
import entity.Usuario;
import java.util.Date;
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
    public int registOrder(String nombre, String apellido, String doc, String direccion, String telefono, String email, String tipo, String pass) {
        Persona p;
        Tipousuario tu;
        try {
            if (tipo.equals(1)) {
                //Si el usuario eligio CI, tipo es igual a 1
                p = em.createNamedQuery("Persona.findByCedPersona", Persona.class).setParameter("cedPersona", doc).getSingleResult();
                if (p.getIdpersona() == null) {
                    p = addPersona(nombre, apellido, doc, direccion, telefono, email);
                    tu = em.find(Tipousuario.class, 1);
                    addUsuario(pass, p, tu);
                }else{
                    tu = em.find(Tipousuario.class, 1);
                    addUsuario(pass, p, tu);
                }
            }else if(tipo.equals(2)){
                //Si el usuario eligio RUC, tipo es igual a 2
 
            }
            return 1;

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
    

    private void addUsuario(String pass, Persona p, Tipousuario tipoUsuarioidtipoUsuario) {
        Usuario u = new Usuario();
        u.setPassUsuario(pass);
        u.setPersonaIdpersona(p);
        u.setTipoUsuarioidtipoUsuario(tipoUsuarioidtipoUsuario);
        Date d = null;
        u.setCreadoUsuario(d);
        em.persist(u);
    }
}
