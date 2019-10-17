/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Persona;
import entity.Tipousuario;
import entity.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public Persona registOrder(String nombre, String apellido, String doc, String direccion, String telefono, String email, String tipo, String pass) {
        Persona p = null;
        Tipousuario tu;
        final Query query;
        List results;
        String cript;
        try {
            cript = encriptPass(pass);
            tu = em.find(Tipousuario.class, 1);
            if (tipo.equals("1")) {
                //Si el usuario eligio CI, tipo es igual a 1
                query = em.createNamedQuery("Persona.findByCedPersona").setParameter("cedPersona", doc);
                results = query.getResultList();

                if (!results.isEmpty()) {
                    p = (Persona) results.get(0);
                    addUsuario(cript, p, tu);
                } else {
                    Persona newPersona = addPersona(nombre, apellido, doc, direccion, telefono, email);
                    addUsuario(cript, newPersona, tu);
                    p = newPersona;
                }
            } else if (tipo.equals("2")) {
                //Si el usuario eligio RUC, tipo es igual a 2
                String[] parts = doc.split("-");
                query = em.createQuery("SELECT p FROM Persona p WHERE p.rucPersona = :rucPersona AND p.cedPersona = :cedPersona").setParameter("cedPersona", parts[0]).setParameter("rucPersona", parts[1]);
                results = query.getResultList();

                if (!results.isEmpty()) {
                    p = (Persona) results.get(0);
                    addUsuario(cript, p, tu);
                } else {
                    Persona newPersona = addPersona(nombre, apellido, parts[0], parts[1], direccion, telefono, email);
                    addUsuario(cript, newPersona, tu);
                    p = newPersona;
                }
            }
            return p;

        } catch (Exception e) {
            context.setRollbackOnly();
            return p;
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

    private Persona addPersona(String nombre, String apellido, String ced, String ruc, String direccion, String telefono, String email) {
        Persona persona = new Persona();
        persona.setNombrePersona(nombre);
        persona.setApellidoPersona(apellido);
        persona.setCedPersona(ced);
        persona.setRucPersona(ruc);
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

    private String encriptPass(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bs = md.digest(pass.getBytes());
            BigInteger integer = new BigInteger(1, bs);
            String s = integer.toString(16);
            while (s.length() < 32) {
                s = "0" + s;
            }
            return s;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Boolean login(String email, String pass) {
        try {
            Persona p;
            List result;
            Query query;
            if(!email.isEmpty() || pass.isEmpty()){
                p  = getUser(email);
                if(p != null){
                    
                }else{
                 
                }
            }else{
            
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Persona getUser(String email) {
        try {
            Persona p = (Persona) em.createNamedQuery("Persona.findByEmailPersona").setParameter("emailPersona", email).getSingleResult();
            return p;
        } catch (NoResultException e) {
            return null;
        } 
    }
    
    
}
