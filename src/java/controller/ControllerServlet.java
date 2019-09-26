/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        //Si se solicita la pagina de inicio de sesion
        if (userPath.equals("/login")) {
            // TODO: Implementar la solicitud de inicio de sesion
        }

        //Si se solicita la pagina del registro de usuario
        if (userPath.equals("/customer_record")) {
            // TODO: Implementar la solicitud de registro de usuario
        }

        //Si se solicita la pagina de registro vehicular
        if (userPath.equals("/car_record")) {
            // TODO: Implementar la solicitud de registro vehicular
        }

        //Si se solicita la pagina de agendamiento
        if (userPath.equals("/visit_registration")) {
            // TODO: Implementar la solicitud de agendamiento  
        }

        //Si se solicita la pagina para encontrar el vehiculo registrado
        if (userPath.equals("/find_car")) {
            // TODO: Implementar la solicitud de encontrar vehiculo
        }

        //Si se solicita la pagina de resumen de cita
        if (userPath.equals("/confirmation")) {
            // TODO: Implementar la solicitud de confirmacion de cita
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

        //Si se llama a la accion iniciar sesion
        if (userPath.equals("/iniciarSesion")) {
            // TODO: Implementar la solicitud de accion inicio de sesion
        }

        //Si se llama a la accion registar usuario
        if (userPath.equals("/registrarUsuario")) {
            // TODO: Implementar la solicitud de accion registro de usuario
        }

        //Si se llama a la accion registrar vehiculo
        if (userPath.equals("/registrarVehiculo")) {
            // TODO: Implementar la solicitud de acccion registro de vehiculo
        }

        //Si se llama a la accion encontrar vehiculo
        if (userPath.equals("/encontrarVehiculo")) {
            // TODO: Implementar la solicitud de accion encontrar vehiculo
        }

        //Si se llama a la accion confirmar cita
        if (userPath.equals("/confirmarCita")) {
            // TODO: Implementar la solicitud de accion confirmar cita
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
