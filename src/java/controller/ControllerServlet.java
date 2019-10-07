/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.MarcavehiculoFacade;
import session.ModelovehiculoFacade;
import session.TipousuarioFacade;
import session.TransManager;

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
            "/find_car",
            "/confirmation",
            "/iniciarSesion",
            "/registrarUsuario",
            "/registrarVehiculo",
            "/encontrarVehiculo",
            "/confirmarCita"
        })
public class ControllerServlet extends HttpServlet {

    @EJB
    private MarcavehiculoFacade mf;
    @EJB
    private ModelovehiculoFacade facade;
    @EJB
    private TransManager transManager;
    @EJB
    private TipousuarioFacade tuf;

    @Override
    public void init() throws ServletException {
         getServletContext().setAttribute("tipos", tuf.find(1));
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
                request.setAttribute("modelos", facade.getModeloForMarca(1));
                break;

            //Si se solicita la pagina de agendamiento
            case "/visit_registration":
                // TODO: Implementar la solicitud de agendamiento 
                break;

            //Si se solicita la pagina para encontrar el vehiculo registrado
            case "/find_car":
                // TODO: Implementar la solicitud de encontrar vehiculo

                break;

            //Si se solicita la pagina de resumen de cita
            case "/confirmation":
                // TODO: Implementar la solicitud de confirmacion de cita

                break;
        }

        //Usa RequestDispatcher para reenviar la solicitud internamente
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
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
        String userPath = request.getServletPath();

        switch (userPath) {
            //Si se llama a la accion iniciar sesion
            case "/iniciarSesion":
                // TODO: Implementar la solicitud de accion inicio de sesion

                break;

            //Si se llama a la accion registar usuario
            case "/registrarUsuario":

                //1 paso -- Recuperar datos del formulario
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String tipodoc = request.getParameter("combDoc");
                String doc = request.getParameter("txtDoc");
                String direccion = request.getParameter("txtDireccion");
                String telefono = request.getParameter("txtTelefono");
                String email = request.getParameter("txtEmail");
                String pass = request.getParameter("txtPass");
                //2 paso -- Validar CI o RUC
                //3 paso -- Consultar si la persona con CI o RUC existe
                //4 paso -- Crear Manager EJB con un contenedor para las transacciones
                int result = transManager.registOrder(nombre, apellido, doc, direccion, telefono, email, tipodoc, pass);
                //5 paso -- Crear un metodo dentro del contenedor que nos permita hacer las acciones de persistencia
                //6 paso -- Implementar dentro los metodos Helper
                //7 paso -- 
                userPath = "/login";

                break;

            //Si se llama a la accion registrar vehiculo
            case "/registrarVehiculo":
                // TODO: Implementar la solicitud de acccion registro de vehiculo

                break;

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
            e.printStackTrace();
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
