/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ClientEntity;
import model.DAO;
import model.DAOException;
import model.DataSourceFactory;


/**
 *
 * @author theogutierrez
 */
@WebServlet(name = "profil", urlPatterns = {"/protected/profil"})
public class profilController extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws model.DAOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
        //UTF-8
        request.setCharacterEncoding("UTF-8");
        
        String jspView = "../views/protected/profil.jsp";
        
        String userName = findUserInSession(request);
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        ClientEntity result = dao.findClient(userName);
        
        // Affiche les données du client lors du lancement de la page
        request.setAttribute("client", result);
        request.setAttribute("nom", result.name);
        
        // Si je clique sur le bouton valider
        String valider = request.getParameter("valider");
        
        if (null != valider) {
            switch (valider) {
                case "login":
                    checkprofil(request, dao, result);
                    break;
            }
        }
        
        request.getRequestDispatcher(jspView).forward(request, response);
    }
    
    private void checkprofil(HttpServletRequest request, DAO dao, ClientEntity result) throws DAOException {
        //Je regarde ce que j'ai mis dans le input
        
        // same pour tous les input
        String ville = request.getParameter("ville");
        dao.updateCustomer("VILLE", ville , result.name );
        
        String societe = request.getParameter("societe");
        dao.updateCustomer("SOCIETE", societe , result.name );
        
        String adresse = request.getParameter("adresse");
        dao.updateCustomer("ADRESSE", adresse , result.name  );
        
        String fonction = request.getParameter("fonction");
        dao.updateCustomer("FONCTION", fonction , result.name  );
        
        String region = request.getParameter("region");
        dao.updateCustomer("REGION", region , result.name );
        
        String cp = request.getParameter("cp");
        dao.updateCustomer("CODE_POSTAL", cp ,result.name  );
        
        String pays = request.getParameter("pays");
        dao.updateCustomer("PAYS", pays , result.name  );
        
        String tel = request.getParameter("tel");
        dao.updateCustomer("TELEPHONE", tel ,result.name );
        
        String fax = request.getParameter("fax");
        dao.updateCustomer("FAX", fax ,result.name );
        
        //Nouvelles données pour empêcher de réafficher l'ancienne après validation
        ClientEntity result1 = dao.findClient(result.name);
        request.setAttribute("nom", result1.name);
        request.setAttribute("client", result1);

        
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
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(profilController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(profilController.class.getName()).log(Level.SEVERE, null, ex);
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
    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }
}
