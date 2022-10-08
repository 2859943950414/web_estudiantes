/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estudent;

/**
 *
 * @author lglui
 */
public class sr_student extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Estudent estudent;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_student</title>");            
            out.println("</head>");
            out.println("<body>");
            estudent= new Estudent(request.getParameter("txt_key1"),Integer.parseInt(request.getParameter("drop_blood")),Integer.parseInt(request.getParameter("txt_id")),request.getParameter("txt_names1"),request.getParameter("txt_lastnames"),request.getParameter("txt_address"),request.getParameter("txt_phone"),request.getParameter("txt_dbo"));
             
             if ("add".equals(request.getParameter("btn_add"))){
             if (estudent.create1()>0){
             response.sendRedirect("index.jsp");

             }else{
             out.println("<h1> xxxxxxx Mistake xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Return...</a>");
             }
             }
             
             if ("modify".equals(request.getParameter("btn_modify"))){
             if (estudent.modify()>0){
             response.sendRedirect("index.jsp");

             }else{
             out.println("<h1> xxxxxxx Not Modified xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Return...</a>");
             }
             }
             
             if ("delete".equals(request.getParameter("btn_delete"))){
             if (estudent.delete1()>0){
             response.sendRedirect("index.jsp");

             }else{
             out.println("<h1> xxxxxxx Not Deleted xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Return...</a>");
             }
             }


            out.println("</body>");
            out.println("</html>");
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
