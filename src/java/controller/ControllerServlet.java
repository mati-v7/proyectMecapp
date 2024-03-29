/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Modelovehiculo;
import entity.Persona;
import entity.Vehiculo;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.MarcavehiculoFacade;
import session.ModelovehiculoFacade;
import session.TransManager;
import session.VehiculoFacade;

/**
 *
 * @author Windows10
 */
@WebServlet(name = "ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {
            "/login",
            "/customer_record",
            "/car_record",
            "/visit_registration",
            "/profile",
            "/confirmation",
            "/iniciarSesion",
            "/registrarUsuario",
            "/registrarVehiculo",
            "/encontrarVehiculo",
            "/confirmarCita",
            "/updatemodelo",
            "/cerrarsesion"
        })
public class ControllerServlet extends HttpServlet {

    @EJB
    private MarcavehiculoFacade mf;
    @EJB
    private ModelovehiculoFacade modf;
    @EJB
    private TransManager transManager;
    @EJB
    private VehiculoFacade vehiculoFacade;

    boolean flag = false;
    boolean added = false;

    @Override
    public void init() throws ServletException {
        //getServletContext().setAttribute("tipos", tuf.find(1));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        switch (userPath) {

            //Si se solicita la pagina de inicio de sesion
            case "/login":
                // TODO: Implementar la solicitud de registro de usuario

                break;

            //Si se solicita la pagina del registro de usuario
            case "/customer_record":

                break;

            //Si se solicita la pagina de registro vehicular
            case "/car_record":
                // TODO: Implementar la solicitud de registro vehicular
                request.setAttribute("marcas", mf.findAll());
                break;

            //Si se solicita la pagina de agendamiento
            case "/visit_registration":
                // TODO: Implementar la solicitud de agendamiento 
                break;

            //Si se solicita la pagina para encontrar el vehiculo registrado
            case "/profile":
                // TODO: Implementar la solicitud de encontrar vehiculo
                HttpSession session = request.getSession(false);
                Persona p = (Persona)session.getAttribute("user");
                if (session != null) {
                    request.setAttribute("vehiculos", vehiculoFacade.getVehiculoForPersona(p));
                } else {
                    userPath = "/login";
                }
                break;

            case "/cerrarsesion":
                session = request.getSession(false);
                session.invalidate();
                response.sendRedirect("");
                return;

            //Si se solicita la pagina de resumen de cita
            case "/confirmation":
                // TODO: Implementar la solicitud de confirmacion de cita

                break;
            case "/updatemodelo":
                String targetId = request.getParameter("id");
                StringBuilder sb = new StringBuilder();
                Modelovehiculo modelo;
                if (!targetId.equals("")) {
                    List result = modf.getModeloForMarca(Integer.parseInt(targetId));
                    if (!result.isEmpty()) {
                        for (int i = 0; i < result.size(); i++) {
                            modelo = (Modelovehiculo) result.get(i);
                            sb.append("<modelovehiculo>");
                            sb.append("<idmodelovehiculo>").append(modelo.getIdmodeloVehiculo()).append("</idmodelovehiculo>");
                            sb.append("<modelo>").append(modelo.getModeloVehiculo()).append("</modelo>");
                            sb.append("</modelovehiculo>");
                        }
                        added = true;
                    }
                    if (added) {
                        response.setContentType("text/xml");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getWriter().write("<modelos>" + sb.toString() + "</modelos>");
                        return;

                    } else {
                        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    }
                }
                break;
        }

        //Usa RequestDispatcher para reenviar la solicitud internamente
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);

        } catch (IOException | ServletException e) {

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email, pass;
        String userPath = request.getServletPath();

        switch (userPath) {
            //Si se llama a la accion iniciar sesion
            case "/iniciarSesion":
                // TODO: Implementar la solicitud de accion inicio de sesion
                email = request.getParameter("txtEmail");
                pass = request.getParameter("txtPass");

                Persona profile = transManager.login(email, pass);
                if (profile != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", profile);
                    request.setAttribute("info", session.getAttribute("user"));
                    response.sendRedirect("profile");
                } else {
                    response.sendRedirect("login");
                }
                return;

            //Si se llama a la accion registar usuario
            case "/registrarUsuario":

                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String tipodoc = request.getParameter("combDoc");
                String doc = request.getParameter("txtDoc");
                String direccion = request.getParameter("txtDireccion");
                String telefono = request.getParameter("txtTelefono");
                email = request.getParameter("txtEmail");
                pass = request.getParameter("txtPass");
                Persona result = transManager.registOrder(nombre, apellido, doc, direccion, telefono, email, tipodoc, pass);

                userPath = "/login";
                break;

            //Si se llama a la accion registrar vehiculo
            case "/registrarVehiculo":
                // TODO: Implementar la solicitud de acccion registro de vehiculo
                String chasis = request.getParameter("txtChasis");
                String chapa = request.getParameter("txtChapa");
                String modelo = request.getParameter("model");
                String anho = request.getParameter("txtAnho");
                String km = request.getParameter("txtKm");
                String color = request.getParameter("txtColor");

                HttpSession session = request.getSession(false);
                Persona p = (Persona) session.getAttribute("user");
                Vehiculo v = transManager.registVehiculo(chasis, modelo, chapa, anho, km, color, p);
                if (v != null) {
                    session.setAttribute("vehiculo", v);
                    request.setAttribute("info", session.getAttribute("vehiculo"));
                    response.sendRedirect("profile");
                    return;
                }else{
                    userPath = "/profile";
                }


            //Si se llama a la accion encontrar vehiculo
            case "/encontrarVehiculo":
                // TODO: Implementar la solicitud de accion encontrar vehiculo

                break;

            //Si se llama a la accion confirmar cita
            case "/confirmarCita":
                // TODO: Implementar la solicitud de accion confirmar cita

                break;
        }

        //Usa RequestDispatcher para reenviar la solicitud internamente
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (IOException | ServletException e) {

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
