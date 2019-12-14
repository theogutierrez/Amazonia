/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.DataSourceFactory;

/**
 *
 * @author theogutierrez
 */
@WebServlet(name = "Amazonia", urlPatterns = {"/Amazonia"})
public class IndexController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Quelle action a appelé cette servlet ?
        String action = request.getParameter("action");
        String categorie = request.getParameter("categorie");
        String nom = request.getParameter("nom");
        if (null != action) {
            switch (action) {
                case "login":
                    checkLogin(request);
                    break;
                case "logout":
                    doLogout(request);
                    break;
            }
        }

        // Est-ce que l'utilisateur est connecté ?
        // On cherche l'attribut userName dans la session
        String userName = findUserInSession(request);
        String jspView;
        if (null == userName) { // L'utilisateur n'est pas connecté
            // On choisit la page de login
            jspView = "views/index.jsp";

        } else { // L'utilisateur est connecté
            // On choisit la page d'affichage
            jspView = "views/protected/indexLogin.jsp";
        }
        // On va vers la page choisie
        try {
			DAO dao = new DAO(DataSourceFactory.getDataSource());
						
			switch (categorie) {
                                case "" : 
                                    request.setAttribute("codes", dao.produit());
                                    break;
				case "boissons": 
					
					request.setAttribute("codes", dao.produitparcategorie("Boissons"));								
					break;
				case "condiments": 
					request.setAttribute("codes", dao.produitparcategorie("Condiments"));
					break;
                                case "desserts": 
					request.setAttribute("codes", dao.produitparcategorie("Desserts"));
					break;
                                case "produits laitiers": 
					request.setAttribute("codes", dao.produitparcategorie("Produits laitiers"));
					break;
                                
                                case "pates et cereale": 
					request.setAttribute("codes", dao.produitparcategorie("Pâtes et céréales"));
					break;
                                case "viandes": 
					request.setAttribute("codes", dao.produitparcategorie("Viandes"));
					break;
                                case "produits secs": 
					request.setAttribute("codes", dao.produitparcategorie("produits secs"));
					break;
                                
                                case "poissons et fruit de mer": 
					request.setAttribute("codes", dao.produitparcategorie("poissons et fruit de mer"));
					break;
			}
		} catch (Exception ex) {
			Logger.getLogger("amazon").log(Level.SEVERE, "Action en erreur", ex);
			request.setAttribute("message", ex.getMessage());
		}
        request.getRequestDispatcher(jspView).forward(request, response);

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

    private void checkLogin(HttpServletRequest request) {
        // Les paramètres transmis dans la requête
        String loginParam = request.getParameter("loginParam");
        String passwordParam = request.getParameter("passwordParam");

        // Le login/password défini dans web.xml
        String login = getInitParameter("login");
        String password = getInitParameter("password");
        String userName = getInitParameter("userName");

        if ((login.equals(loginParam) && (password.equals(passwordParam)))) {
            // On a trouvé la combinaison login / password
            // On stocke l'information dans la session
            HttpSession session = request.getSession(true); // démarre la session
            session.setAttribute("userName", userName);
        } else { // On positionne un message d'erreur pour l'afficher dans la JSP
            request.setAttribute("errorMessage", "Login/Password incorrect");
        }
    }

    private void doLogout(HttpServletRequest request) {
        // On termine la session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }
}
