/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Tareas;
import Modelo.TareasDAL;

/**
 *
 * @author jc997
 */

@WebServlet(name = "TareasController", urlPatterns = {"/TareasController"})
public class TareasController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TareasDAL tareasDAL = new TareasDAL();
        String accion;
        RequestDispatcher dispatcher;
        dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("Tareas/Index.jsp");
            List<Tareas> listaTareas = tareasDAL.listarTareas();
            request.setAttribute("lista", listaTareas);
            
        } else if (accion.equals("Nuevo")) {
            dispatcher = request.getRequestDispatcher("Tareas/Nuevo.jsp");
            
        } else if (accion.equals("Insertar")) {
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String hora = request.getParameter("hora");
            
            
            Tareas tarea = new Tareas(0, titulo, descripcion, hora);
            tareasDAL.Insertar(tarea);

            dispatcher = request.getRequestDispatcher("Tareas/Index.jsp");
            List<Tareas> listaTareas = tareasDAL.listarTareas();
            request.setAttribute("lista", listaTareas);
            
        } else if (accion.equals("Modificar")) {
            dispatcher = request.getRequestDispatcher("Tareas/Modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Tareas tarea = tareasDAL.MostarTareas(id);
            request.setAttribute("tarea", tarea);
            
        } else if (accion.equals("Actualizar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String hora = request.getParameter("hora");

            
            Tareas tarea = new Tareas(id, titulo, descripcion, hora);
            tareasDAL.Actualizar(tarea);

            dispatcher = request.getRequestDispatcher("Tareas/Index.jsp");
            List<Tareas> listaTareas = tareasDAL.listarTareas();
            request.setAttribute("lista", listaTareas);
            
        } else if (accion.equals("Eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));

            tareasDAL.Eliminar(id);
            dispatcher = request.getRequestDispatcher("Tareas/Index.jsp");
            List<Tareas> listaTareas = tareasDAL.listarTareas();
            request.setAttribute("lista", listaTareas);
        } else {
            dispatcher = request.getRequestDispatcher("Tareas/Index.jsp");
            var listaTareas = tareasDAL.listarTareas();
            request.setAttribute("lista", listaTareas);
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}





    