/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DataSourceFactory;

/**
 *
 * @author theogutierrez
 */
@WebServlet(name = "statAdmin", urlPatterns = {"/statAdmin"})
public class statAdmin extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        String type = request.getParameter("type");
        String dateDeb = request.getParameter("datedeb");
        String dateFin = request.getParameter("datefin");
        Properties resultat = new Properties();
        Map<String, Float> result = new HashMap<>();
            try {
                switch (type) {
                    case "categorie":
                        result=dao.priceByCategorie("1994-08-04", "1996-06-05");
                        resultat.put("records", result);
                        break;
                    case "pays":
                        resultat.put("records", dao.priceByCountry(dateDeb, dateFin));
                        break;
                    case "client":
                        resultat.put("records", dao.priceByClient(dateDeb, dateFin));
                        break;                       
                    default:
                        break;
                }

            } catch (SQLException ex) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    resultat.put("records", Collections.EMPTY_LIST);
                    resultat.put("message", ex.getMessage());
            }

            try (PrintWriter out = response.getWriter()) {
                    // On spécifie que la servlet va générer du JSON
                    response.setContentType("application/json;charset=UTF-8");
                    // Générer du JSON
                    // Gson gson = new Gson();
                    // setPrettyPrinting pour que le JSON généré soit plus lisible
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    out.println(gson.toJson(resultat));
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
