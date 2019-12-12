/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.DAOException;
import model.DataSourceFactory;

/**
 *
 * @author theogutierrez
 */
@WebServlet(name = "connexion", urlPatterns = {"/connexion"})
public class connexionController extends HttpServlet {
    //Création du DAO
    DAO dao = new DAO(DataSourceFactory.getDataSource());
    
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
        		String action = request.getParameter("action");
        if (null != action) {
                switch (action) {
                        case "login":
                                checkLogin(request);
                                break;
                }
        }
        String userName = findUserInSession(request);
        String jspView;
        if (null == userName) { // L'utilisateur n'est pas connecté
            // On choisit la page de login
            jspView = "/views/connexion.jsp";
            request.getRequestDispatcher(jspView).forward(request, response);
        } else { // L'utilisateur est connecté
            //cas admin
            if("admin".equals(userName)) {
                jspView = "protected/admin";
            } else {
                // On choisit la page d'affichage
                jspView = "/Amazonia";               
            }
            response.sendRedirect(jspView);
        }
        
    }
    private void checkLogin(HttpServletRequest request) {
        // Les paramètres transmis dans la requête
        String contact = request.getParameter("login");
        String mdp = request.getParameter("password");

        String login = "admin";
        String password = "admin";
        try {
            if (dao.mdp(contact,mdp)) {
                // On a trouvé la combinaison login / password
                // On stocke l'information dans la session
                HttpSession session = request.getSession(true); // démarre la session
                session.setAttribute("userName", contact);
            } else { 
                // cas d'admin
                if(login.equals(contact) && mdp.equals(password)) {
                    // On a trouvé la combinaison login / password
                    // On stocke l'information dans la session
                    HttpSession session = request.getSession(true); // démarre la session
                    session.setAttribute("userName", contact);           
                // On positionne un message d'erreur pour l'afficher dans la JSP
                } else {
                    request.setAttribute("errorMessage", "Login/Password incorrect");
                } 
            }
        } catch (DAOException ex) {
            Logger.getLogger(connexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String findUserInSession(HttpServletRequest request) {
            HttpSession session = request.getSession(false);
            return (session == null) ? null : (String) session.getAttribute("userName");
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
