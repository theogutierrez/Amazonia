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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "admin", urlPatterns = {"/protected/admin"})
public class adminController extends HttpServlet {
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
        String userName = findUserInSession(request);
        String page = request.getParameter("page");
        String action = request.getParameter("action");
        String jspView ="../views/protected/admin.jsp";
        if (!"admin".equals(userName)) { // L'utilisateur n'est pas connecté ou admin
            // On choisit la page de login
            jspView = "../connexion";
            response.sendRedirect(jspView);
        } else { // L'utilisateur est connecté et est admin
            // On choisit la page d'admin suvant la page en paramètre
            if (null != page) {
                switch (page) {
                    case "ajouter":
                        if(action == "ajouter") { 
                            ajouterProduit(request);
                        } else {
                            jspView="../views/protected/adminAjouter.jsp";
                        }
                        break;
                    case "modifier":
                        if (action =="supprimer") {
                            supprimerProduit(request,response);
                        } else {
                            jspView="../views/protected/adminModifier.jsp";
                        }
                        break;
                    case "stat":
                        jspView = "../views/protected/admin.jsp";
                        break;
                }
            } else {
                jspView = "../views/protected/admin.jsp";
            } 
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
    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }
    
    private void ajouterProduit(HttpServletRequest request) {
        String nom = request.getParameter("nom");
        int categorie = Integer.parseInt(request.getParameter("categorie"));
        int fournisseur = Integer.parseInt(request.getParameter("fournisseur"));
        int reapprovisionnement = Integer.parseInt(request.getParameter("reapprovisionnement"));
        String quantite = request.getParameter("quantite");
        float prixU = Float.parseFloat(request.getParameter("prixU"));
        int uniteS = Integer.parseInt(request.getParameter("uniteS"));
        int uniteC = Integer.parseInt(request.getParameter("uniteC"));
        int disponible = Integer.parseInt(request.getParameter("disponible"));
        
        try {
            dao.addProduct(nom, fournisseur, disponible, reapprovisionnement, prixU, uniteC, quantite, categorie, uniteS);
            request.setAttribute("produitAjouter", "Votre produit a bien été ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    private void supprimerProduit(HttpServletRequest request, HttpServletResponse response) {
        String nom = request.getParameter("nom");      
		String message;
		try {
			int count = dao.delProduct(nom);
			// Générer du JSON
			if (count == 1) {
				message = String.format("Code %s supprimé", nom);
			} else {
				message = String.format("Code %s inconnu", nom);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			message = String.format("Impossible de supprimer '%s', ce code est utilisé", nom);
		}
		catch (SQLException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			message = ex.getMessage();
		}
		
		Properties resultat = new Properties();
		resultat.put("message", message);
		
		try (PrintWriter out = response.getWriter()) {
			// On spécifie que la servlet va générer du JSON
			response.setContentType("application/json;charset=UTF-8");
			// Générer du JSON
			Gson gson = new Gson();
			out.println(gson.toJson(resultat));
		} catch (IOException ex) {
                    Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
