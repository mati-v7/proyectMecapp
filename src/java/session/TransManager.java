/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Modelovehiculo;
import entity.Persona;
import entity.Tipousuario;
import entity.Usuario;
import entity.Vehiculo;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Windows10
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransManager {

    @EJB
    private UsuarioFacade uf;

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
        try {
            tu = em.find(Tipousuario.class, 1);
            if (tipo.equals("1")) {
                //Si el usuario eligio CI, tipo es igual a 1
                query = em.createNamedQuery("Persona.findByCedPersona").setParameter("cedPersona", doc);
                results = query.getResultList();

                if (!results.isEmpty()) {
                    p = (Persona) results.get(0);
                    addUsuario(pass, p, tu);
                } else {
                    Persona newPersona = addPersona(nombre, apellido, doc, direccion, telefono, email);
                    addUsuario(pass, newPersona, tu);
                    p = newPersona;
                }
            } else if (tipo.equals("2")) {
                //Si el usuario eligio RUC, tipo es igual a 2
                String[] parts = doc.split("-");
                query = em.createQuery("SELECT p FROM Persona p WHERE p.rucPersona = :rucPersona AND p.cedPersona = :cedPersona").setParameter("cedPersona", parts[0]).setParameter("rucPersona", parts[1]);
                results = query.getResultList();

                if (!results.isEmpty()) {
                    p = (Persona) results.get(0);
                    addUsuario(pass, p, tu);
                } else {
                    Persona newPersona = addPersona(nombre, apellido, parts[0], parts[1], direccion, telefono, email);
                    addUsuario(pass, newPersona, tu);
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

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Persona login(String email, String pass) {

        try {
            Persona p;
            if (!email.isEmpty() || !pass.isEmpty()) {
                p = getPersona(email);
                if (p != null) {
                    List result = uf.getUserForIdPersona(p);
                    Usuario u = (Usuario) result.get(0);
                    if (!u.getPassUsuario().equals(pass)) {
                        //Error de Password
                        return null;
                    }

                } else {
                    //Error de Email
                    return null;
                }
            } else {
                //Error de formulario vacio
                return null;
            }

            return p;
        } catch (Exception e) {
            return null;
        }
    }

    private Persona getPersona(String email) {
        Persona p = null;
        try {
            List l = em.createNamedQuery("Persona.findByEmailPersona").setParameter("emailPersona", email).getResultList();
            if (!l.isEmpty()) {
                p = (Persona) l.get(0);
            }
        } catch (NoResultException e) {
            return null;
        }
        return p;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Vehiculo registVehiculo(String chasis, String modelo, String chapa, String anho, String km, String color, Persona p) {
        Modelovehiculo m = getModelo(modelo);
        Vehiculo v = addVehiculo(chasis, m, chapa, anho, km, color, p);
        return v;
    }

    private Modelovehiculo getModelo(String modelo) {
        Modelovehiculo mv = null;
        try {
            List l = em.createNamedQuery("Modelovehiculo.findByIdmodeloVehiculo").setParameter("idmodeloVehiculo", modelo).getResultList();
            if (!l.isEmpty()) {
                mv = (Modelovehiculo) l.get(0);
            }
        } catch (Exception e) {
            return null;
        }
        return mv;
    }

    private Vehiculo addVehiculo(String chasis, Modelovehiculo m, String chapa, String anho, String km, String color, Persona p) {
        Vehiculo v = new Vehiculo();
        v.setChasisVehiculo(chasis);
        v.setChapaVehiculo(chapa);
        v.setAnhoVehiculo(anho);
        v.setKmVehiculo(Integer.parseInt(km));
        v.setColorVehiculo(color);
        v.setModeloVehiculoidmodeloVehiculo(m);
        v.setPersonaIdpersona(p);
        em.persist(v);
        return v;
    }

}
