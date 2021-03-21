/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Enlaces;
import modelo.enlacesCRUD;

/**
 *
 * @author David Rebato
 */
public class servletEnlaces extends HttpServlet {
    private final int NUM_LINEAS_PAGINAS = 4;
    private int id;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEnlaces</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEnlaces at " + request.getContextPath() + "</h1>");
            if (op.equals("listar")){
                List<Enlaces> misEnlaces = enlacesCRUD.getEnlaces();
                int pagina = 1;
                int offset = 0;
                if (request.getParameter("pagina")!=null) {
                    pagina = Integer.parseInt(request.getParameter("pagina"));
                    offset = (pagina - 1) * NUM_LINEAS_PAGINAS;
                }
                int num_paginas = (int) Math.ceil(misEnlaces.size() / NUM_LINEAS_PAGINAS);
                misEnlaces = enlacesCRUD.getEnlacesPaginado(offset, NUM_LINEAS_PAGINAS);
                request.setAttribute("num_paginas", num_paginas);
                request.setAttribute("pagina", pagina);
                request.setAttribute("misEnlaces", misEnlaces);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
            }
            if (op.equals("insert1")) { //cuando le indicamos que vaya a insertar
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
            if (op.equals("insert2")) { //cuando le indicamos que vaya a insertar
                Enlaces miEnlace = new Enlaces();
                miEnlace.setNombre(request.getParameter("nombre"));
                miEnlace.setLink(request.getParameter("link"));
                miEnlace.setTipo(request.getParameter("tipo"));
                enlacesCRUD.insertaEnlace(miEnlace);
                response.sendRedirect("servletEnlaces?op=listar");
            }
            if (op.equals("borrar")) { //cuando le indicamos que vaya a borrar
                int id = Integer.parseInt(request.getParameter("id"));
                if (enlacesCRUD.destroyEnlace(id) > 0) {
                    response.sendRedirect("servletEnlaces?op=listar");
                } 
            }
            if (op.equals("update1")) { //cuando le indicamos que vaya a actualizar
                int id = Integer.parseInt(request.getParameter("id"));
                Enlaces miEnlace = enlacesCRUD.getEnlace(id);
                request.setAttribute("miEnlace", miEnlace);
                this.id = miEnlace.getId();
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            if (op.equals("update2")) { //cuando le indicamos que vaya a actualizar
                Enlaces miEnlace = new Enlaces();
                miEnlace.setId(this.id);
                miEnlace.setNombre(request.getParameter("nombre"));
                miEnlace.setLink(request.getParameter("link"));
                miEnlace.setTipo(request.getParameter("tipo"));
                enlacesCRUD.actualizaEnlace(miEnlace);
                String mensaje = "Enlace actualizado";
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("miEnlace", miEnlace);
                request.getRequestDispatcher("update.jsp").forward(request, response);
                response.sendRedirect("servletEnlaces?op=listar");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
